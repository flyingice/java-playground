import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleFuture {
    public static void run() {
        playWithInvokeAll();
    }

    public static class Task implements Callable<Integer> {
        private int id;
        public Task(int id) {
            this.id = id;
        }

        @Override
        public Integer call() throws Exception {
            int cnt = 0;
            while(cnt < 10) {
                cnt++;
                TimeUnit.MILLISECONDS.sleep(100);
            }
            System.out.println("task " + id + " finished by " + Thread.currentThread().getName());
            return cnt;
        }
    }

    public static void playWithSubmit() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Task(0));
        executor.shutdown();
        try {
            System.out.println("waiting for the child task...");
            System.out.println(result.get());
        } catch(InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void playWithInvokeAll() {
        List<Task> tasks = IntStream.range(0, 10).mapToObj(Task::new).collect(Collectors.toList());
        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            System.out.println("waiting for all the child tasks to finish...");
            List<Future<Integer>> results = executor.invokeAll(tasks);
            Integer sum = results.stream().map(r -> {
                try {
                    return r.get();
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            }).reduce(0, Integer::sum);
            System.out.println("calculated sum: " + sum);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
