package MainClasses;

import AtbashCipher.MainCodeOfAtbashCipher;
import CaesarCipher.Cipher;
import CaesarCipher.MainCode;
import XorCipher.MainXORClass;

import java.io.IOException;

public class Setup {
    public static String wordForSelectingCipher;

    public static void setup() {
        int selectingCipher = SelectCipher.selectCipher();
        System.out.println();
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
            } else if (selectingCipher == 3) {
                Cipher.setLanguage();
                MainXORClass.mainClassOFXORCipher();
            }
        } catch (IOException exception) {
            System.out.println("IOException: " + exception.getMessage());
        }
    }
}
