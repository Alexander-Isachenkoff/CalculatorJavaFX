package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private double operand;
    
    @Override
    public String prepareStatement() {
        return switch (getSignPlace()) {
            case BEFORE -> getSign() + format(operand);
            case AFTER -> format(operand) + getSign();
        };
    }
    
    @Override
    public CalculationResult calc() {
        double result = apply(operand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    abstract double apply(double operand);
    
    public void setOperand(double operand) {
        this.operand = operand;
    }
    
    abstract SignPlace getSignPlace();
    
    enum SignPlace {
        BEFORE, AFTER
    }
}
