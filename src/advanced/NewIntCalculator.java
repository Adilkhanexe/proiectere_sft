package advanced;

public class NewIntCalculator extends ACalculator {
    public NewIntCalculator(int val) {
        this.state = val;
    }
    @Override
    public void init() {
        this.state = 0;
    }
    public NewIntCalculator add(int v) {
        this.state = (Integer)state + v;
        return this;
    }
    public NewIntCalculator subtract(int v) {
        this.state = (Integer)state - v;
        return this;
    }
    public NewIntCalculator multiply(int v) {
        this.state = (Integer)state * v;
        return this;
    }
}