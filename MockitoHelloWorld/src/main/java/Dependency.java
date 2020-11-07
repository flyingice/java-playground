import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Dependency {
    int getDataFromDatabase(int ...varargs) throws InterruptedException {
        try {
            // simulate time-consuming data lookup
            TimeUnit.SECONDS.sleep(10);
        } catch(InterruptedException e) {
            System.err.println(e);
            throw e;
        }

        return IntStream.of(varargs).sum();
    }
}
