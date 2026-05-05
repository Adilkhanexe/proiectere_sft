package ro.ulbs.proiectaresoftware.lab6.advanced;

public class NewIntCalculator extends ACalculator<Integer> {

    @Override
    public NewIntCalculator init() {
        this.state = 0;
        return this;
    }
    public NewIntCalculator add(int i, Integer a) {
        this.state += a;
        return this;
    }
    public NewIntCalculator subtract(int i, Integer a) {
        this.state -= a;
        return this;
    }
    public NewIntCalculator multiply(Integer a) {
        this.state *= a;
        return this;
    }
    public NewIntCalculator multiply(int i, Integer a) {
        this.state *= a;
        return this;
    }

    public NewIntCalculator divide(int i, Integer a) {
        if (a == 0) throw new ArithmeticException("Division by zero");
        this.state /= a;
        return this;
    }
}