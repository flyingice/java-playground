import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class MockListParameterizedTest {
    List mockedList = mock(List.class);

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5},
        });
    };

    @Parameterized.Parameter(0)
    public int expected;
    @Parameterized.Parameter(1)
    public int input;

    @Test
    public void testThenAnswer() {
        when(mockedList.get(anyInt())).thenAnswer((Answer) invocationOnMock -> {
            int param = (int) invocationOnMock.getArgument(0);
            return param;
        });

        assertEquals(expected, mockedList.get(expected));
    }
}