package ru.isachenkoff.calculator.operations;

import java.util.Optional;
import java.util.function.Supplier;

public enum OperationType {
    
    ADDITION(Addition::new),
    SUBTRACTION(Subtraction::new),
    DIVISION(Division::new),
    PRODUCT(Product::new),
    POWER(Power::new),
    SQRT(Sqrt::new),
    SQUARE(Square::new);
    
    OperationType(Supplier<Operation> operationSupplier) {
        this.operationSupplier = operationSupplier;
    }
    
    private final Supplier<Operation> operationSupplier;
    
    public static Optional<Operation> createOperation(OperationType type) {
        return Optional.of(type.operationSupplier.get());
    }
    
}
