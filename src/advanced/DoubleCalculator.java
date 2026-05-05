package advanced;

public class DoubleCalculator extends ACalculator {
    public DoubleCalculator(double val) {
        this.state = val;
    }
    @Override
    public void init() {
        this.state = 0.0;
    }
    public DoubleCalculator add(double v) {
        this.state = (Double)state + v;
        return this;
    }
    public DoubleCalculator subtract(double v) {
        this.state = (Double)state - v;
        return this;
    }
    public DoubleCalculator multiply(double v) {
        this.state = (Double)state * v;
        return this;
    }
}