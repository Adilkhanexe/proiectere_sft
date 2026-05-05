package advanced;

public class AppLab5 {
    public static void main(String[] args) {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        intCalc.add(5).subtract(3).multiply(2);
        System.out.println("Result Integer: " + intCalc.result());

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        doubleCalc.add(5.0).subtract(3.3).multiply(2.2);
        System.out.println("Result Double: " + doubleCalc.result());
    }
}