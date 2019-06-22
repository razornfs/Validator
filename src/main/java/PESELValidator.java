public class PESELValidator implements Validator {

    private static final int[] WEIGHTS = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    @Override
    public boolean validate(String PESEL) {
        PESEL = PESEL.trim();
        if (!PESEL.matches("[0-9]{11}")) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < WEIGHTS.length; i++) {
            int weight = WEIGHTS[i];
            int digit = Character.digit(PESEL.charAt(i), 10);
            sum += weight * digit;
        }
        int lastDigit = Character.digit(PESEL.charAt(PESEL.length() - 1), 10);
        return sum % 10 == lastDigit;
    }
}
