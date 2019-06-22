import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PESELValidatorTest {
    private Validator PESELValidator = new PESELValidator();

    @Test
    public void test_lower_length() {
        String PESEL = "1234567890";
        assertFalse(PESELValidator.validate(PESEL));
    }

    @Test
    public void test_higher_length() {
        String PESEL = "123456789012";
        assertFalse(PESELValidator.validate(PESEL));
    }

    @Test
    public void test_PESEL_not_consisting_of_digits() {
        String PESEL = "1234A567890";
        assertFalse(PESELValidator.validate(PESEL));
    }

    @Test
    public void test_correct_PESEL() {
        String PESEL = "22060915917";
        assertTrue(PESELValidator.validate(PESEL));
    }

    @Test
    public void test_incorrect_PESEL() {
        String PESEL = "22060915918";
        assertTrue(PESELValidator.validate(PESEL));
    }
}
