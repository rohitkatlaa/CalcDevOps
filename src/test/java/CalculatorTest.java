import static org.junit.Assert.*;
import org.junit.Test;

import calculator.Calculator;

public class CalculatorTest {
    private static final double DELTA = 1e-15;
    Calculator calc = new Calculator();

    @Test
    public void sqroot_test(){
        assertEquals("Testing square root of 64", 8, calc.sqroot(64), DELTA);
    }

    @Test
    public void factorial_test(){
        assertEquals("Testing factorial of 5", 120, calc.factorial(5), DELTA);
    }
}
