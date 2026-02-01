package main.java.com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void testCalculatorLogic() {
        // Test the Calculator logic that's used in main
        Calculator calculator = new Calculator();
        int result = calculator.calculate(10, 5, Calculator.Operation.ADD);
        assertEquals(15, result);
    }

    @Test
    void testUserServiceInstantiation() {
        // Test that UserService can be instantiated with a password
        UserService service = new UserService("test_password");
        assertNotNull(service);
    }

    @Test
    void testUserServiceWithNullPassword() {
        // Test that UserService handles null password
        UserService service = new UserService(null);
        assertNotNull(service);
    }

    @Test
    void testCalculatorOperations() {
        // Test multiple operations used in the app
        Calculator calculator = new Calculator();

        assertEquals(15, calculator.calculate(10, 5, Calculator.Operation.ADD));
        assertEquals(5, calculator.calculate(10, 5, Calculator.Operation.SUBTRACT));
        assertEquals(50, calculator.calculate(10, 5, Calculator.Operation.MULTIPLY));
    }
}