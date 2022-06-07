package ru.isachenkoff.calculator.operations;

public abstract class BinaryOperation extends AbstractOperation {
    
    private final double firstOperand;
    private final double secondOperand;
    
    public BinaryOperation(String sign, double firstOperand, double secondOperand) {
        super(sign);
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    
    @Override
    public String prepareStatement() {
        return format(firstOperand) + getSign() + format(secondOperand) + "=";
    }
    
    @Override
    public CalculationResult calc() {
        double result = apply(firstOperand, secondOperand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    abstract double apply(double firstOperand, double secondOperand);
}
