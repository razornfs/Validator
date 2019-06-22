import org.junit.Test;

import static org.junit.Assert.*;

public class IDValidatorTest {

    private Validator validator = new IDValidator();

    @Test
    public void test_higher_length() {
        String ID = "ABC1234567";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_lower_length() {
        String ID = "ABC12345";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_ID_not_starting_with_3_letters() {
        String ID = "A0A000000";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_ID_not_ending_with_6_numbers() {
        String ID = "AAA0A0A0A";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_correct_ID() {
        String ID = "OLH281658";
        assertTrue(validator.validate(ID));
    }


}
