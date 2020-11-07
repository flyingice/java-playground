import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, 1, 2},
                {2, 4, 6},
                {-3, 8, 5},
                {0, 10, 10},
        });
    };

    @Parameterized.Parameter(0)
    public int inputLeft;
    @Parameterized.Parameter(1)
    public int inputRight;
    @Parameterized.Parameter(2)
    public int expected;

    @Test(timeout = 5000)
    public void testCalculator() {
        org.junit.Assert.assertEquals(expected, new Calculator().add(inputLeft, inputRight));
    }
}

class Calculator {
    public int add(int l, int r) {
        if(l * r == 0) {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch(InterruptedException e) {
                return 0;
            }
        }
        return l + r;
    }
}
