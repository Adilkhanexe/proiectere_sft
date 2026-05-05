package advanced;

public abstract class ACalculator {
    protected Object state;
    public Object result() {
        return state;
    }
    public void clear() {
        init();
    }
    public abstract void init();
}