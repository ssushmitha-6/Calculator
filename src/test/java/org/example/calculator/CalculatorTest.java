package org.example.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testBasicOperations() {
        assertEquals(5.0, calculator.calculate(Operation.ADD, 2, 3));
        assertEquals(1.0, calculator.calculate(Operation.SUBTRACT, 3, 2));
        assertEquals(6.0, calculator.calculate(Operation.MULTIPLY, 2, 3));
        assertEquals(2.0, calculator.calculate(Operation.DIVIDE, 6, 3));
    }

    @Test
    public void testChainingOperations() {
        Number result = calculator.chainCalculate(5, Operation.ADD, 3, Operation.MULTIPLY, 2);
        assertEquals(16.0, result);
    }

    @Test
    public void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.calculate(Operation.DIVIDE, 1, 0));
    }

    @Test
    public void testUnsupportedOperation() {
        assertThrows(UnsupportedOperationException.class, () -> calculator.calculate(null, 1, 2));
    }

    @Test
    public void testExtensibility() {
        calculator.addOperation(Operation.ADD, (a, b) -> a.doubleValue() + b.doubleValue() + 1);
        assertEquals(6.0, calculator.calculate(Operation.ADD, 2, 3));
    }

}
