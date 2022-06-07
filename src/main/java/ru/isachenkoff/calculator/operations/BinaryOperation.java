package ru.isachenkoff.calculator.operations;

public abstract class BinaryOperation extends AbstractOperation {
    
    private final Double firstOperand;
    private Double secondOperand;
    
    public BinaryOperation(String sign, Double firstOperand, Double secondOperand) {
        super(sign);
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }
    
    @Override
    public String prepareStatement() {
        String statement = format(firstOperand) + getSign();
        if (hasSecondOperand()) {
            statement += format(secondOperand) + "=";
        }
        return statement;
    }
    
    @Override
    public CalculationResult calc() {
        double result = apply(firstOperand, secondOperand);
        String statement = prepareStatement();
        return new CalculationResult(result, statement);
    }
    
    abstract double apply(double firstOperand, double secondOperand);
    
    public boolean hasSecondOperand() {
        return secondOperand != null;
    }
    
    public Double getFirstOperand() {
        return firstOperand;
    }
    
    public Double getSecondOperand() {
        return secondOperand;
    }
    
    public void setSecondOperand(Double secondOperand) {
        this.secondOperand = secondOperand;
    }
}
