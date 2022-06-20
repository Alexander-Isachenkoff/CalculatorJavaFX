package ru.isachenkoff.calculator;

import ru.isachenkoff.calculator.operations.CalculationResult;

public interface Statement {
    String prepareStatement();
    
    CalculationResult calc();
}
