package ru.isachenkoff.calculator.operations;

 class Ln extends UnaryOperation {
    
     Ln() {
         super("ln", true);
     }
    
     @Override
     double apply(double operand) {
         return Math.log(operand);
     }
    
     @Override
    SignPlace getSignPlace() {
        return SignPlace.BEFORE;
    }
}
