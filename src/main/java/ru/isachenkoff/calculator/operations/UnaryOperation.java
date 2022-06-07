package ru.isachenkoff.calculator.operations;

public abstract class UnaryOperation extends AbstractOperation {
    
    private double operand;
    
    public UnaryOperation(String sign) {
        super(sign);
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
    
    public void setOperand(double operand) {
        this.operand = operand;
    }
}
