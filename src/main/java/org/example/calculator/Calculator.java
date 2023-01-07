package org.example.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private static final List<NewArithmeticOperator> operators
            = new ArrayList<>(List.of(new AdditionOperator(), new SubtractionOperator(), new SupplyOperator(), new DivisionOperator()));

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        return operators.stream()
                .filter(o -> o.supports(operator))
                .map(o -> o.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }
}
