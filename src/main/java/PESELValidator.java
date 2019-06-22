public class PESELValidator implements Validator {

    private static final int[] WEIGHTS = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};

    @Override
    public boolean validate(String PESEL) {
        PESEL = PESEL.trim();
        if (PESEL.length() != 11) {
            return false;
        }
        if (!PESEL.matches("[0-9]+")) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < WEIGHTS.length; i++) {
            int weight = WEIGHTS[i];
            int digit = Character.digit(PESEL.charAt(i), 10);
            sum += weight * digit;
        }
        return sum % 10 == Character.digit(PESEL.charAt(PESEL.length() - 1), 10);
    }
}
