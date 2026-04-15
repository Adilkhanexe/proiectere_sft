package ro.ulbs.proiectaresoftware.lab6.advanced;

public abstract class ACalculator<T> {
    T state;

    abstract ACalculator<T> init();

    public T result() {
        return state;
    }
}