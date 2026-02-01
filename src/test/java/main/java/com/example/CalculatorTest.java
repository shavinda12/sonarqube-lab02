package main.java.com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddOperation() {
        int result = calculator.calculate(10, 5, Calculator.Operation.ADD);
        assertEquals(15, result);
    }

    @Test
    void testAddNegativeNumbers() {
        int result = calculator.calculate(-10, -5, Calculator.Operation.ADD);
        assertEquals(-15, result);
    }

    @Test
    void testSubtractOperation() {
        int result = calculator.calculate(10, 5, Calculator.Operation.SUBTRACT);
        assertEquals(5, result);
    }

    @Test
    void testSubtractNegativeResult() {
        int result = calculator.calculate(5, 10, Calculator.Operation.SUBTRACT);
        assertEquals(-5, result);
    }

    @Test
    void testMultiplyOperation() {
        int result = calculator.calculate(10, 5, Calculator.Operation.MULTIPLY);
        assertEquals(50, result);
    }

    @Test
    void testMultiplyByZero() {
        int result = calculator.calculate(10, 0, Calculator.Operation.MULTIPLY);
        assertEquals(0, result);
    }

    @Test
    void testDivideOperation() {
        int result = calculator.calculate(10, 5, Calculator.Operation.DIVIDE);
        assertEquals(2, result);
    }

    @Test
    void testDivideByZeroThrowsException() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.calculate(10, 0, Calculator.Operation.DIVIDE));
        assertEquals("Division by zero is not allowed", exception.getMessage());
    }

    @Test
    void testModuloOperation() {
        int result = calculator.calculate(10, 3, Calculator.Operation.MODULO);
        assertEquals(1, result);
    }

    @Test
    void testModuloWithEvenDivision() {
        int result = calculator.calculate(10, 5, Calculator.Operation.MODULO);
        assertEquals(0, result);
    }

    @Test
    void testPowerOperation() {
        int result = calculator.calculate(2, 3, Calculator.Operation.POWER);
        assertEquals(8, result);
    }

    @Test
    void testPowerOfZero() {
        int result = calculator.calculate(5, 0, Calculator.Operation.POWER);
        assertEquals(1, result);
    }

    @Test
    void testPowerOfOne() {
        int result = calculator.calculate(5, 1, Calculator.Operation.POWER);
        assertEquals(5, result);
    }
}