package MainClasses;

import CaesarCipher.Cipher;
import CaesarCipher.MainCode;

public class MainApp {
    public static void main(String[] args) {
        int selectingCipher = SelectCipher.selectCipher();
        try {
            if (selectingCipher == 1) {
                Cipher.setLanguage();
                MainCode.programStart();
            } else if (selectingCipher == 2) {
                Cipher.setLanguage();

            }
        } catch (Exception exception) {
            System.out.println("The program was completed! If it was completed by mistake, start it again!");
        }
    }
}