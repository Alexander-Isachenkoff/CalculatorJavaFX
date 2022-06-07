package ru.isachenkoff.calculator.operations;

import java.util.Optional;
import java.util.function.Supplier;

public class OperationFactory {
    
    public enum OperationType {
        ADDITION(Addition::new),
        SUBTRACTION(() -> null),
        DIVISION(() -> null),
        PRODUCT(() -> null),
        SQRT(Sqrt::new),
        SQUARE(() -> null);
        
        OperationType(Supplier<Operation> operationSupplier) {
            this.operationSupplier = operationSupplier;
        }
        
        private final Supplier<Operation> operationSupplier;
        
    }
    
    public static Optional<Operation> createOperation(OperationType type) {
        return Optional.of(type.operationSupplier.get());
    }
    
}
