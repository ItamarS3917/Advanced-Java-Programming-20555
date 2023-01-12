
// An abstract class called CompoundExpression that inherits from Expression. This class represents a complex arithmetic expression
public abstract class CompoundExpression extends Expression {
    protected Expression _firstOperand;
    protected Expression _secondOperand;

    public CompoundExpression(Expression firstOp , Expression secondOp)
    {
        _firstOperand = firstOp;
        _secondOperand = secondOp;
    }
}
