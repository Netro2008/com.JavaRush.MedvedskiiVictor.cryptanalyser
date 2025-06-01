package AtbashCipher;
import CaesarCipher.Cipher;
import MainClasses.Setup;
import MainClasses.TypicalPhrases;

import java.util.Scanner;

public class MainCodeOfAtbashCipher {
    public static Scanner scanner = new Scanner(System.in);

    public static void startAtbashCipher() {
        boolean flag = true, flag2 = true;
        int userChoiceInEncryptingMenu, userChoice;

        while (flag) {
            flag2 = true;
            TypicalPhrases.helloMethod(Setup.wordForSelectingCipher);
            AtbashMainPhrases.atbashCipherMeinMenu();
            userChoice = AtbashHelper.userChoiceInMenu();
            System.out.println();
            while (flag2) {
                switch (userChoice) {
                    case 1:
                        AtbashMainPhrases.helloPhraseAtbashCipher();
                        AtbashMainPhrases.fileOrConsoleMethod();
                        userChoiceInEncryptingMenu = AtbashHelper.userChoiceInMainMenu();

                        if (userChoiceInEncryptingMenu == 1) {
                            AtbashMainPhrases.writeYourText();
                            String text = scanner.nextLine();
                            String resultOfMethodWork = AtbashCipher.encryptTextFromConsole(text, Cipher.ENGLISH_ALPHABET);
                            System.out.println(resultOfMethodWork);
                            System.out.println();
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 2) {

                        } else if (userChoiceInEncryptingMenu == 9) {
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 0) {
                            flag = false;
                            flag2 = false;
                            break;
                        }
                    case 2:

                    case 0:
                        flag = false;
                        flag2 = false;
                        break;
                }
            }
        }
    }
}
