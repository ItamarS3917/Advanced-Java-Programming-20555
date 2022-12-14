// A class called SubtractionExpression inheriting from the CompoundExpression class, the class represents a subtraction expression
public class SubtractionExpression extends CompoundExpression {

    public SubtractionExpression(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double calculate() {
        return _firstOperand.calculate() - _secondOperand.calculate();
    }

    @Override
    public String toString() {
        return _firstOperand.calculate() + " - " + _secondOperand.calculate();
    }
}
