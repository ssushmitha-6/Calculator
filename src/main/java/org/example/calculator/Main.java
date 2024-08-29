package org.example.calculator;

public class Main {
    public static void main(String[] args) {
        // Initialize the calculator
        Calculator calculator = new Calculator();

        // Perform basic calculations
        Number additionResult = calculator.calculate(Operation.ADD, 10, 5);
        Number subtractionResult = calculator.calculate(Operation.SUBTRACT, 10, 5);
        Number multiplicationResult = calculator.calculate(Operation.MULTIPLY, 10, 5);
        Number divisionResult = calculator.calculate(Operation.DIVIDE, 10, 5);

        System.out.println("Addition: 10 + 5 = " + additionResult);
        System.out.println("Subtraction: 10 - 5 = " + subtractionResult);
        System.out.println("Multiplication: 10 * 5 = " + multiplicationResult);
        System.out.println("Division: 10 / 5 = " + divisionResult);

        // Demonstrate chaining operations
        Number chainResult = calculator.chainCalculate(10, Operation.ADD, 5, Operation.MULTIPLY, 2);
        System.out.println("Chaining (10 + 5) * 2 = " + chainResult);

        // Adding a new operation (e.g., MODULO)
        Operation MODULO = Operation.valueOf("MODULO");
        calculator.addOperation(MODULO, (a, b) -> a.doubleValue() % b.doubleValue());

        Number moduloResult = calculator.calculate(MODULO, 10, 3);
        System.out.println("Modulo: 10 % 3 = " + moduloResult);

        // Handling unsupported operations gracefully
        try {
            calculator.calculate(null, 10, 5);
        } catch (UnsupportedOperationException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Handling division by zero gracefully
        try {
            calculator.calculate(Operation.DIVIDE, 10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
