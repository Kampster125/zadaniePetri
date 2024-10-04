import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;

public class CodeGenerator {

    private int length;
    private String code;
    private static final String DIGITS = "0123456789";
    private static final String ALPHANUMERIC = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private SecureRandom random = new SecureRandom();

    public CodeGenerator(int length) {

        if (length != 4 && length != 6 && length != 12 && length != 16) {
            throw new IllegalArgumentException("Długość kodu musi wynosić 4, 6, 12 lub 16.");
        }
        this.length = length;
        this.code = generateCode();
    }

    private String generateCode() {
        StringBuilder sb = new StringBuilder(length);
        String charSet;

        if (length == 4 || length == 6) {
            charSet = DIGITS;
        }

        else {
            charSet = ALPHANUMERIC;
        }

        for (int i = 0; i < length; i++) {
            sb.append(charSet.charAt(random.nextInt(charSet.length())));
        }

        return sb.toString();
    }

    public void displayCode() {
        System.out.println("Wygenerowany kod: " + this.code);
    }

    public void saveToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(this.code);
            System.out.println("Kod zapisany do pliku: " + filename);
        } catch (IOException e) {
            System.err.println("Błąd zapisu do pliku: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CodeGenerator pinGenerator = new CodeGenerator(4);
        pinGenerator.displayCode();

        CodeGenerator tokenGenerator = new CodeGenerator(12);
        tokenGenerator.displayCode();

        tokenGenerator.saveToFile("token.txt");
    }
}
