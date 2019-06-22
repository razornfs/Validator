public class ValidatorFactory {

    public static Validator getValidator(String validator) {
        switch (validator) {
            case "ID":
                return new IDValidator();
            case "PESEL":
                return new PESELValidator();
            default:
                return null;
        }
    }
}
