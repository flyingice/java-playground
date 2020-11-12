import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFuturePlay {
    public static void run() throws Exception {
        multipleCompletableFutures();
    }

    public static void sleep(int duration) {
        try {
            TimeUnit.MILLISECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Integer work() {
        int delta = new Random().nextInt(1000);
        if(delta < 500) {
            sleep(delta);
            System.out.println("awake from the sleep");
        } else {
            throw new RuntimeException("sth has went wrong");
        }
        return delta;
    }

    public static void simpleCompletableFuture() {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(CompletableFuturePlay::work);
        // setup callbacks
        future.thenAccept(r -> {
            System.out.println("I've got the result: " + r);
        });
        future.exceptionally(e -> {
            e.printStackTrace();
            return null;
        });

        // dirty workaround to prevent the main thread from terminating
        sleep(1000);
    }

    public static void multipleCompletableFutures() {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            sleep(500);
            System.out.println("doing my job: 1st step");
        }).thenRunAsync(() -> {
            sleep(500);
            System.out.println("doing my job: 2nd step");
        });

        System.out.println("waiting for the completion of tasks");
        future.join();
        System.out.println("done");
    }
}
