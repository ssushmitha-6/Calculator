# Extensible Calculator

## Overview

This project aims to create a simple yet extensible calculator in Java, capable of handling various operations. The implementation adheres to fundamental object-oriented principles, with a strong emphasis on the Open-Closed Principle, ensuring the system remains easy to maintain and extend.

## Features

1. **Basic Operations**: Supports fundamental operations such as ADD, SUBTRACT, MULTIPLY, and DIVIDE.
2. **Operation Chaining**: Users can perform a sequence of operations on a single value, similar to a standard calculator.
3. **Extensibility**: The calculator is designed to accommodate new operations without altering existing code.
4. **IoC Compatibility**: The design supports Inversion of Control (IoC) principles, allowing for flexible testing and easy swapping of components.
5. **Error Handling**: The calculator manages invalid operations gracefully, such as handling division by zero and unsupported operations.

## Design Choices

1. **Operation Enum**: The `Operation` enum is used to define standard operations. Additional operations can be added by extending this enum, without modifying the `Calculator` class.
2. **Open-Closed Principle**: The `Calculator` class is built to allow extensions without changes to its core code. This is achieved using a map that stores operations and their implementations, enabling the addition of new operations at runtime.
3. **IoC Compatibility**: The design is compatible with dependency injection frameworks, enhancing flexibility in testing and component swapping.
4. **Error Handling**: The calculator throws meaningful exceptions for invalid operations, such as division by zero or unsupported operations.

## Project Structure

CalculatorProject/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org.example.calculator/
│   │           └── Calculator.java
│   │           └── Operation.java
│   │           └── README.md
│   └── test/
│       └── java/
│           └── org.example.calculator/
│               └── CalculatorTest.java
└── pom.xml