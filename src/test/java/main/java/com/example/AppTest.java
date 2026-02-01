package main.java.com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    //Test cases for the app class

    @Test
    void testCalculatorLogic() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(10, 5, Calculator.Operation.ADD);
        assertEquals(15, result);
    }

    @Test
    void testCalculatorOperations() {
        Calculator calculator = new Calculator();
        
        assertEquals(15, calculator.calculate(10, 5, Calculator.Operation.ADD));
        assertEquals(5, calculator.calculate(10, 5, Calculator.Operation.SUBTRACT));
        assertEquals(50, calculator.calculate(10, 5, Calculator.Operation.MULTIPLY));
        assertEquals(2, calculator.calculate(10, 5, Calculator.Operation.DIVIDE));
    }

    @Test
    void testCalculatorDivideByZero() {
        Calculator calculator = new Calculator();
        assertThrows(ArithmeticException.class, () -> {
            calculator.calculate(10, 0, Calculator.Operation.DIVIDE);
        });
    }

    @Test
    void testUserServiceInstantiation() {
        UserService service = new UserService("test_password");
        assertNotNull(service);
    }

    @Test
    void testUserServiceWithNullPassword() {
        UserService service = new UserService(null);
        assertNotNull(service);
    }

}