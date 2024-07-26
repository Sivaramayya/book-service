package testcases;
import org.junit.jupiter.api.AfterAll;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTestCase {

    private int num1;
    private int num2;


    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before all tests");
    }


    @AfterAll
    static void cleanupAfterAll() {
        System.out.println("After all tests");
    }


    @BeforeEach
    void setupBeforeEach() {
        System.out.println("Before each test");
        num1 = 2;
        num2 = 3;
    }


    @AfterEach
    void cleanupAfterEach() {
        System.out.println("After each test");
    }


    @Test
    void testAddTwoNumbers() {
        System.out.println("Adding two numbers");
        int result = num1 + num2;
        assertEquals(5, result, "the sum should be 5");
    }

    @Test
    void testAnotherMethod() {
        System.out.println("Another test method");

    }
}
