import org.junit.*;

public class FixtureTest {
    @BeforeClass
    public static void globalSetUp() {
        System.out.println("globalSetUp");
    }

    @AfterClass
    public static void globalTearDown() {
        System.out.println("globalTearDown");
    }

    @Before
    public void setUp() {
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}

