import picocli.CommandLine;

public class Main implements Runnable {
    @CommandLine.Option(names = "-v", required = true)
    private String validatorType;
    @CommandLine.Option(names = "-id", required = true)
    private String ID;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    public void run() {
        Validator validator = ValidatorFactory.getValidator(validatorType.toUpperCase());
        if (validator == null) {
            System.out.println("Niepoprawny typ validatora");
            return;
        }
        if (validator.validate(ID)) {
            System.out.println("Ten numer jest poprawny");
        } else {
            System.out.println("Ten numer jest niepoprawny");
        }
    }
}
