package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private final double operand;
    
    public UnaryOperation(String sign, double operand) {
        super(sign);
        this.operand = operand;
    }
    
    @Override
    public String prepareStatement() {
        return getSign() + format(operand);
    }
    
    @Override
    public CalculationResult calc() {
        double result = apply(operand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    abstract double apply(double operand);
}
