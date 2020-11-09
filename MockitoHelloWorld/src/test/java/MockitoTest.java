import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {
    @Mock
    Dependency mockDependency;
    Dependent dependent;

    @Before
    public void setUp() {
        dependent = new Dependent(mockDependency);
    }

    @Test
    public void testConsolidateData() throws InterruptedException {
        dependent.consolidateData(1, 2, 3);

        verify(mockDependency).getDataFromDatabase(1, 2, 3);
    }

    @Test
    public void testThrownException() throws InterruptedException {
        when(mockDependency.getDataFromDatabase(0)).thenThrow(InterruptedException.class);
        when(mockDependency.getDataFromDatabase(1, 2, 3, 4, 5)).thenReturn(100);

        assertEquals(-1, dependent.consolidateData(0));
        assertEquals(90, dependent.consolidateData(1, 2, 3, 4, 5));
        verify(mockDependency, times(2).description("holy crap")).getDataFromDatabase(any());
    }

    @Test
    public void testDummy() {
        // dummyProcessing() -> dummy()
        // default value is returned by the mock without when().thenReturn specification
        assertEquals(0, dependent.dummyProcessing());
    }

    @Test
    public void testSpy() {
        Dependency d = spy(Dependency.class);
        // real dummy() is called by dummyProcessing()
        assertEquals(10, new Dependent(d).dummyProcessing());

        // partial mock as an alternative having the same effect
        when(dependent.dummyProcessing()).thenCallRealMethod();
        assertEquals(10, dependent.dummyProcessing());
    }
}
