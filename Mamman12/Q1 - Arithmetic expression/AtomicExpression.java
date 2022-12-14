// A class named Atomic Expression that inherits from Expression This class represents an atomic arithmetic expression.
public class AtomicExpression extends Expression {

    private double _atomicArithmeticExpression;

    public AtomicExpression(double realNumber) {
        _atomicArithmeticExpression = realNumber;
    }

    @Override
    public String toString() {
        return _atomicArithmeticExpression + "";
    }

    @Override
    public double calculate() {
        return _atomicArithmeticExpression;
    }
}
