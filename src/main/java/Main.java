import picocli.CommandLine;

public class Main implements Runnable {

    @CommandLine.Parameters(index = "0")
    private String ID;

    public static void main(String[] args) {
        CommandLine.run(new Main(), args);
    }

    public void run() {
        Validator idValidator = new IDValidator();
        if (idValidator.validate(ID)) {
            System.out.println("Ten numer dowodu osobistego jest poprawny");
        } else {
            System.out.println("Ten numer dowodu osobistego jest niepoprawny");
        }
    }
}
