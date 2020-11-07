import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SimpleDataModelTest {
    @Test
    public void testSimpleDataModel() {
        final int id = 10;
        final String name = "smart";
        final String comment = "This is a test";
        List<Integer> numbers = Arrays.asList(1, 2, 4, 5);
        ImmutableSimpleDataModel data = ImmutableSimpleDataModel.builder().id(id).name(name).comment(comment).addAllNumbers(numbers).build();
        assertEquals(data.id(), id);
        assertEquals(data.name(), name);
        assertEquals(data.comment().get(), comment);
        assertEquals(data.numbers(), numbers);
    }
}
