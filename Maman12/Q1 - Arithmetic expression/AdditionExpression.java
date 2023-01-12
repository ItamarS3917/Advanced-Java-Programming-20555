// A class called AdditionExpression inheriting from the CompoundExpression class, the class represents a addition expression
public class AdditionExpression extends CompoundExpression {

    public AdditionExpression(Expression firstOp, Expression secondOp) {
        super(firstOp, secondOp);
    }

    @Override
    public double calculate() {
        return _firstOperand.calculate() + _secondOperand.calculate();
    }

    @Override
    public String toString() {
        return _firstOperand.calculate() + " + " + _secondOperand.calculate();
    }

}
