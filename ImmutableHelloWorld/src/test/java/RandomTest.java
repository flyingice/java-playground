import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RandomTest {
    @Test
    public void testAssertNotNull() {
        assertNotNull("The parameter can not be null", new String("Hello"));
    }

    @Test
    public void testB() {
        System.out.println("second");
    }

    @Test
    public void testA() {
        System.out.println("first");
    }

    @Test
    public void testC() {
        System.out.print("third");
    }
}
