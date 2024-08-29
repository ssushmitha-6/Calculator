package org.example.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private final Map<Operation, BiFunction<Number, Number, Number>> operationMap;

    public Calculator() {
        operationMap = new HashMap<>();
        operationMap.put(Operation.ADD, (a, b) -> a.doubleValue() + b.doubleValue());
        operationMap.put(Operation.SUBTRACT, (a, b) -> a.doubleValue() - b.doubleValue());
        operationMap.put(Operation.MULTIPLY, (a, b) -> a.doubleValue() * b.doubleValue());
        operationMap.put(Operation.DIVIDE, (a, b) -> {
            if (b.doubleValue() == 0) throw new ArithmeticException("Division by zero is not allowed.");
            return a.doubleValue() / b.doubleValue();
        });
    }

    public Number calculate(Operation op, Number num1, Number num2) {
        if (!operationMap.containsKey(op)) {
            throw new UnsupportedOperationException("Operation not supported: " + op);
        }
        return operationMap.get(op).apply(num1, num2);
    }

    public Number chainCalculate(Number initialValue, Object... operations) {
        Number result = initialValue;
        for (int i = 0; i < operations.length; i += 2) {
            Operation op = (Operation) operations[i];
            Number value = (Number) operations[i + 1];
            result = calculate(op, result, value);
        }
        return result;
    }

    public void addOperation(Operation op, BiFunction<Number, Number, Number> operation) {
        operationMap.put(op, operation);
    }

}
