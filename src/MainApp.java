import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        Cipher.setLanguage();

        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            RussianProgram.programStart();
        } else {
            EnglishProgram.startOfTheProgram();
        }
    }
}