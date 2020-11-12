import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdown {
    public static void run() {
        shutdownNowWhenThreadIsInterruptable();
        //shutdownNowWhenThreadIsNonInterruptable();
        shutdownNowThreadCheckingState();
        shutdownElegant();
    }

    public static void shutdownNowWhenThreadIsInterruptable() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            try {
                System.out.println("I am about to sleep");
                TimeUnit.SECONDS.sleep(10);
                System.out.println("I am awake");
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.shutdownNow();
    }

    public static void shutdownNowWhenThreadIsNonInterruptable() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // in non-blocking state all the time, can not exit before finish
        executor.execute(()-> {
            long cnt = 0;
            while(cnt < Long.MAX_VALUE) {
                cnt++;
            }
        });
        // the task keep running after shutdownNow()
        executor.shutdownNow();
    }

    public static void shutdownNowThreadCheckingState() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(()-> {
            long cnt = 0;
            while(cnt < Long.MAX_VALUE && !Thread.currentThread().isInterrupted()) {
                cnt++;
            }
            System.out.println("I have finished counting");
        });
        executor.shutdownNow();
    }

    public static void shutdownElegant() {
        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(()-> {
                long cnt = 0;
                while(cnt < Long.MAX_VALUE && !Thread.currentThread().isInterrupted()) {
                    cnt++;
                }
                System.out.println("I have finished counting");
            });
            // call shutdown() instead of shutdownNow() here
            executor.shutdown();
            if(!executor.awaitTermination(3, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
