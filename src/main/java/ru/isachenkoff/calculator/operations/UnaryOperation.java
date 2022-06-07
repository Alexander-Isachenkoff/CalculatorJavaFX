package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private double operand;
    
    @Override
    public String prepareStatement() {
        String statement = "";
        switch (getSignPlace()) {
            case BEFORE:
                statement = getSign() + format(operand);
                break;
            case AFTER:
                statement = format(operand) + getSign();
                break;
        }
        return statement + "=";
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
