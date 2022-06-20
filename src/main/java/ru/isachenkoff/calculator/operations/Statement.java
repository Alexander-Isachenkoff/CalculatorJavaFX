package ru.isachenkoff.calculator.operations;

public interface Statement {
    String prepareStatement();
    
    CalculationResult calc();
}
