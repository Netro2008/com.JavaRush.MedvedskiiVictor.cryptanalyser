package AtbashCipher;
import CaesarCipher.Cipher;
import MainClasses.Setup;
import MainClasses.TypicalPhrases;

import java.util.Scanner;

public class MainCodeOfAtbashCipher {
    public static void startAtbashCipher() {
        TypicalPhrases.helloMethod(Setup.wordForSelectingCipher);

        // пока что просто тестирование работы метода!
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (Cipher.ALPHABET == Cipher.RUSSIAN_ALPHABET) {
            AtbashCipher.encryptTextFromConsole(text, AtbashMainPhrases.russianAlphabetLength);
        }
    }
}
