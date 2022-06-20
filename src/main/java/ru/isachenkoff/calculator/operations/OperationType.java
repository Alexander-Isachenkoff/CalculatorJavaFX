package ru.isachenkoff.calculator.operations;

import java.util.function.Supplier;

public enum OperationType {
    
    ADDITION(Addition::new),
    SUBTRACTION(Subtraction::new),
    DIVISION(Division::new),
    PRODUCT(Product::new),
    POWER(Power::new),
    SQRT(Sqrt::new),
    SQUARE(Square::new),
    LN(Ln::new),
    SIN(Sin::new),
    COS(Cos::new),
    TAN(Tan::new),
    LOG(Log10::new),
    FACTORIAL(Factorial::new);
    
    OperationType(Supplier<Operation> operationSupplier) {
        this.operationSupplier = operationSupplier;
    }
    
    private final Supplier<Operation> operationSupplier;
    
    public static Operation createOperation(OperationType type) {
        return type.operationSupplier.get();
    }
    
}
