package org.example.calculator;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 + operand2;
        }
    },
    SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 - operand2;
        }
    },
    SUPPLY("*") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 * operand2;
        }
    },
    DIVISION("/") {
        @Override
        public int arithmeticCalculate(int operand1, int operand2) {
            return operand1 / operand2;
        }
    };

    private String operation;

    ArithmeticOperator(String operation) {
        this.operation = operation;
    }

    public static int calculate(int operand1, String operation, int operand2) {
        return from(operation).arithmeticCalculate(operand1, operand2);
    }

    public static ArithmeticOperator from(String other) {
        return Arrays.stream(ArithmeticOperator.values())
                .filter(o -> o.operation.equals(other))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }

    public abstract int arithmeticCalculate(final int operand1, final int operand2);
}
