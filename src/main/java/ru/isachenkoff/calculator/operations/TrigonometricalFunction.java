package ru.isachenkoff.calculator.operations;

abstract class TrigonometricalFunction extends UnaryOperation {
    
    private Unit unit;
    
    TrigonometricalFunction(String sign) {
        super(sign, true);
    }
    
    TrigonometricalFunction(String sign, boolean needParentheses) {
        super(sign, needParentheses);
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    public void setUnit(Unit unit) {
        this.unit = unit;
    }
    
    @Override
    final double apply(double operand) {
        double value = (unit == Unit.DEG) ? Math.toRadians(operand) : operand;
        return applyInternal(value);
    }
    
    abstract double applyInternal(double operand);
    
    @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
