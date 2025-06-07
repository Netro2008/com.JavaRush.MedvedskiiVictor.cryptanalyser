package AtbashCipher;
import CaesarCipher.CaesarMainPhrases;
import CaesarCipher.Cipher;
import MainClasses.Confirmation;
import MainClasses.Setup;
import MainClasses.TypicalPhrases;

import java.io.IOException;
import java.util.Scanner;

public class MainCodeOfAtbashCipher {
    public static Scanner scanner = new Scanner(System.in);

    public static void startAtbashCipher() throws IOException {
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
                            String resultOfMethodWork;
                            AtbashMainPhrases.writeYourText();
                            String text = scanner.nextLine();
                            resultOfMethodWork = AtbashCipherConsole.encryptOrDecryptTextFromConsole(text, Cipher.ALPHABET);
                            System.out.println("Your encrypted text: " + resultOfMethodWork);

                            int confirmationChoice = Confirmation.confirmationOfContinuingWorkingProgram();
                            if (confirmationChoice == 2) {
                                CaesarMainPhrases.endedProgram();
                                flag = false;
                                flag2 = false;
                                break;
                            }

                            System.out.println();
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 2) {
                            AtbashMainPhrases.writeFilePath();
                            String filepath = scanner.nextLine();
                            AtbashMainPhrases.writeSecondFilePath();
                            String filepathWhereDoneResultShouldBe = scanner.nextLine();
                            AtbashCipherFromFile.encryptOrDecryptFromFile(filepath, filepathWhereDoneResultShouldBe, Cipher.ALPHABET);
                            AtbashMainPhrases.endedEncryptingText();

                            int confirmationChoice = Confirmation.confirmationOfContinuingWorkingProgram();
                            if (confirmationChoice == 2) {
                                CaesarMainPhrases.endedProgram();
                                flag = false;
                                flag2 = false;
                                break;
                            }

                            System.out.println();
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 9) {
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 0) {
                             flag = false;
                            flag2 = false;
                            break;
                        }
                    case 2:
                        AtbashMainPhrases.helloPhraseAtbashCipher();
                        AtbashMainPhrases.fileOrConsoleMethodDecrypting();
                        userChoiceInEncryptingMenu = AtbashHelper.userChoiceInMainMenu();

                        if (userChoiceInEncryptingMenu == 1) {
                            String resultOfMethodWork;
                            AtbashMainPhrases.writeYourText();
                            String text = scanner.nextLine();
                            resultOfMethodWork = AtbashCipherConsole.encryptOrDecryptTextFromConsole(text, Cipher.ALPHABET);
                            System.out.println("Your decrypted text: " + resultOfMethodWork);

                            int confirmationChoice = Confirmation.confirmationOfContinuingWorkingProgram();
                            if (confirmationChoice == 2) {
                                CaesarMainPhrases.endedProgram();
                                flag = false;
                                flag2 = false;
                                break;
                            }

                            System.out.println();
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 2) {
                            AtbashMainPhrases.writeFilePath();
                            String filepath = scanner.nextLine();
                            AtbashMainPhrases.writeSecondFilePath();
                            String filepathWhereDoneResultShouldBe = scanner.nextLine();
                            AtbashCipherFromFile.encryptOrDecryptFromFile(filepath, filepathWhereDoneResultShouldBe, Cipher.ALPHABET);
                            AtbashMainPhrases.endedEncryptingText();

                            int confirmationChoice = Confirmation.confirmationOfContinuingWorkingProgram();
                            if (confirmationChoice == 2) {
                                CaesarMainPhrases.endedProgram();
                                flag = false;
                                flag2 = false;
                                break;
                            }

                            System.out.println();
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 9) {
                            flag2 = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 0) {
                            flag = false;
                            flag2 = false;
                            break;
                        }
                    case 0:
                        flag = false;
                        flag2 = false;
                        break;
                }
            }
        }
    }
}
