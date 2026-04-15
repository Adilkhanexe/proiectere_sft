import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab6.advanced.DoubleCalculator;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new DoubleCalculator().init();
    }

    @Test
    public void testAddPositive() {
        Assertions.assertEquals(5.5, calculator.add(0.0, 5.5).result(), 0.001);
    }

    @Test
    public void testDivideBy0() {
        calculator.add(0.0, 5.0).divide(0.0, 0.0);
        Assertions.assertEquals(Double.POSITIVE_INFINITY, calculator.result());
    }
}