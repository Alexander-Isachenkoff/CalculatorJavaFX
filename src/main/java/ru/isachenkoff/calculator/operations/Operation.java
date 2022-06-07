package ru.isachenkoff.calculator.operations;

public interface Operation {
    String prepareStatement();
    
    String getSign();
    
    CalculationResult calc();
}
