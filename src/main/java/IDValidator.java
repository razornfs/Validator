public class IDValidator implements Validator {

    private static final int[] WEIGHTS = {7, 3, 1, 9, 7, 3, 1, 7, 3};
    private static final int ID_LENGTH = 9;
    private static final int PRECEDING_LETTERS = 3;
    private static final int ALPHABET_SIZE = 26;

    @Override
    public boolean validate(String ID) {
        ID = ID.trim();
        if (ID.length() != ID_LENGTH) {
            return false;
        }
        if (!ID.substring(0, PRECEDING_LETTERS).matches("[A-Z]+")) {
            return false;
        }
        if (!ID.substring(PRECEDING_LETTERS).matches("[0-9]+")) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < PRECEDING_LETTERS; i++) {
            int letterValue = Integer.parseInt(String.valueOf(ID.charAt(i)), ALPHABET_SIZE);
            sum += (letterValue + 10) * WEIGHTS[i];
        }
        for (int i = PRECEDING_LETTERS; i < ID_LENGTH; i++) {
            sum += Integer.parseInt(String.valueOf(ID.charAt(i))) * WEIGHTS[i];
        }
        return sum % 10 == 0;
    }
}
