import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
    public static void run() {
        mixLimitAndParallelIsTricky();
    }

    public static void mixLimitAndParallelIsTricky() {
        final int LIMIT = 10;
        // The output is not necessarily [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as expected
        List<Integer> l1 = Stream.generate(new Supplier<Integer>() {
            private int cnt = 0;
            @Override
            public Integer get() {
                return cnt++;
            }
        }).limit(LIMIT).parallel().collect(Collectors.toList());
        System.out.println("l1: " + l1);

        // Strangely, it doesn't work neither
        List<Integer> l2 = Stream.generate(new Supplier<Integer>() {
            private AtomicInteger cnt = new AtomicInteger();
            @Override
            public Integer get() {
                return cnt.getAndIncrement();
            }
        }).limit(LIMIT).parallel().collect(Collectors.toList());
        System.out.println("l2: " + l2);

        // IntStream.range() solves the problem
        List<Integer> l3 = (List<Integer>) IntStream.range(0, LIMIT).parallel().boxed().collect(Collectors.toList());
        System.out.println("l3: " + l3);
    }
}
