package ro.ulbs.proiectaresoftware.lab6.advanced;

public class DoubleCalculator extends ACalculator<Double> {

    @Override
    public DoubleCalculator init() {
        this.state = 0.0;
        return this;
    }

    public DoubleCalculator add(Double a, Double b) {
        this.state += b;
        return this;
    }

    public DoubleCalculator subtract(Double a) {
        this.state -= a;
        return this;
    }

    public DoubleCalculator multiply(Double a) {
        this.state *= a;
        return this;
    }

    public DoubleCalculator divide(Double a, Double b) {
        this.state /= b;
        return this;
    }
}