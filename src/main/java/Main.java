import picocli.CommandLine;

public class Main implements Runnable {

    @CommandLine.ArgGroup(exclusive = true, multiplicity = "1")
    private Exclusive exclusive;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    public void run() {
        Validator validator = null;
        String toValidate = "";
        if (exclusive.ID != null) {
            validator = new IDValidator();
            toValidate = exclusive.ID;
        }
        if (exclusive.PESEL != null) {
            validator = new PESELValidator();
            toValidate = exclusive.PESEL;
        }
        if (validator.validate(toValidate)) {
            System.out.println("Ten numer jest poprawny");
        } else {
            System.out.println("Ten numer jest niepoprawny");
        }
    }

    static class Exclusive {
        @CommandLine.Option(names = {"-p", "-pesel", "-PESEL"}, required = true)
        String PESEL;
        @CommandLine.Option(names = "-id", required = true)
        String ID;
    }
}
