import org.junit.jupiter.api.*;

public class JUnitCycleTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("@BeforeEach");
    }

    @Test
    public void junitTest1() {
        System.out.println("test1");
    }

    @Test
    public void junitTest2() {
        System.out.println("test2");
    }

    @Test
    public void junitTest3() {
        System.out.println("test3");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach");
    }
}
