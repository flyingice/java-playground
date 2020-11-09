import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MockListTest {
    List mockedList = mock(List.class);

    @Test
    public void testVerifyNoMoreInteractions() {
        mockedList.add("one");
        mockedList.add("two");

        verify(mockedList).add("one");
        verify(mockedList).add("two");
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void testIgnoreStubs() {
        when(mockedList.get(0)).thenReturn(100);
        assertEquals(100, mockedList.get(0));
        mockedList.clear();

        verify(mockedList).clear();
        verifyNoMoreInteractions(ignoreStubs(mockedList));
    }

    @Test
    public void testVoid() {
        doAnswer(invocationOnMock -> {
            System.out.println("doAnswer mocked print");
            return null;
        }).when(mockedList).clear();

        mockedList.clear();
    }
}
