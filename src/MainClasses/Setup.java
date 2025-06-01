package MainClasses;

import AtbashCipher.MainCodeOfAtbashCipher;
import CaesarCipher.Cipher;
import CaesarCipher.MainCode;

public class Setup {
    public static String wordForSelectingCipher;

    public static void setup() {
        int selectingCipher = SelectCipher.selectCipher();
        try {
            if (selectingCipher == 1) {
                Cipher.setLanguage();
                if (Cipher.ALPHABET == Cipher.RUSSIAN_ALPHABET) {
                    wordForSelectingCipher = "Цезаря";
                } else if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
                    wordForSelectingCipher = "Caesar";
                }
                MainCode.programStart();
            } else if (selectingCipher == 2) {
                Cipher.setLanguage();
                if (Cipher.ALPHABET == Cipher.RUSSIAN_ALPHABET) {
                    wordForSelectingCipher = "Атбаша";
                } else if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
                    wordForSelectingCipher = "Atbash";
                }
                MainCodeOfAtbashCipher.startAtbashCipher();
            }
        } catch (Exception exception) {
            System.out.println("The program was completed! If it was completed by mistake, start it again!");
        }
    }
}
