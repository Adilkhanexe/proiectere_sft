package ro.ulbs.proiectaresoftware.lab6.advanced;

public class Lab5Adv {
    public static void main(String[] args) {
        NewIntCalculator calculator = new NewIntCalculator();
        Integer resultInteger = calculator.init().add(7, 10).add(7, 5).subtract(7, 3).multiply(2).divide(-6, 3).result();
        System.out.println("5.5.2 Integer: " + resultInteger);

        DoubleCalculator dCalculator = new DoubleCalculator();
        Double resultDouble = dCalculator.init().add(2.5, 10.0).add(2.5, 5.0).subtract(3.3).multiply(2.2).divide(5.0, 3.0).result();
        System.out.println("5.5.2 Double: " + resultDouble);
    }
}