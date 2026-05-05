import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ro.ulbs.proiectaresoftware.lab6.advanced.NewIntCalculator;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new NewIntCalculator().init();
    }

    @Test
    public void testAddPositive() {
        Assertions.assertEquals(10, calculator.add(0, 10).result());
    }

    @Test
    public void testAddNegatives() {
        Assertions.assertEquals(-10, calculator.add(0, -10).result());
    }

    @Test
    public void testSubtractPositives() {
        Assertions.assertEquals(7, calculator.add(0, 10).subtract(0, 3).result());
    }

    @Test
    public void testMultiplyPositives() {
        Assertions.assertEquals(21, calculator.add(0, 7).multiply(0, 3).result());
    }

    @Test
    public void testDivideBy0() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0, 0);
        });
    }
}