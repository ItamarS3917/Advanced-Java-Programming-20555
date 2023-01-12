
// An abstract class called Expression. This class will represent an arithmetic expression
public abstract class Expression {
    public abstract double calculate();

    @Override
    public boolean equals(Object other) {
        if (other instanceof Expression)
            return Math.round(this.calculate()) == Math.round(((Expression) other).calculate());
        return false;
    }
}