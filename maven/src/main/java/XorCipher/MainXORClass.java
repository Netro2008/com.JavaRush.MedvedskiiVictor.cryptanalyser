package XorCipher;

import CaesarCipher.CaesarMainPhrases;
import MainClasses.Confirmation;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class MainXORClass {
    public static void mainClassOFXORCipher() {
        int userChoiceInMainMenu;
        boolean flag = true, flag2 = true;
        Scanner scanner = new Scanner(System.in);

        while (flag2) {
            MainPhrasesXOR.helloPhrase();
            userChoiceInMainMenu = GettingPersonInfo.gettingUserChoice(false);
            flag = true;
            while (flag) {
                switch (userChoiceInMainMenu) {
                    case 1:
                        MainPhrasesXOR.welcomeToEncryptingDecryptingMethod(false);
                        int userChoiceInEncryptingMenu = GettingPersonInfo.gettingUserChoice(true);

                        if (userChoiceInEncryptingMenu == 1) {
                            MainPhrasesXOR.pleaseWriteText();
                            String text = GettingPersonInfo.gettingUserText();
                            String key = EncryptingAndDecryptingMethod.makingKey(24);

                            byte[] bytes = EncryptingAndDecryptingMethod.encryptingText(text, key);
                            String resultInBase64String = Base64.getEncoder().encodeToString(bytes);
                            System.out.println();
                            MainPhrasesXOR.endedEncryptingOrDecryptingText();
                            System.out.println(resultInBase64String);
                            System.out.println("Your key is: " + key);
                            System.out.println();

                            int confirmationChoice = Confirmation.confirmationOfContinuingWorkingProgram();
                            if (confirmationChoice == 2) {
                                CaesarMainPhrases.endedProgram();
                                flag = false;
                                flag2 = false;
                                break;
                            }
                            System.out.println();

                            flag = false;
                            break;
                        } else if (userChoiceInEncryptingMenu == 2) {

                        } else if (userChoiceInEncryptingMenu == 9) {
                            flag = false;
                            break;
                        } else {
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
