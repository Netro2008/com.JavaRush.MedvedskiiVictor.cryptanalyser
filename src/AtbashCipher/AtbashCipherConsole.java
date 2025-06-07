package AtbashCipher;

import java.util.List;

import static CaesarCipher.Cipher.*;

public class AtbashCipherConsole {
    public static String encryptOrDecryptTextFromConsole(String text, List<Character> alphabet) {
        String doneText = "";
        String [] stringArray = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            stringArray[i] = String.valueOf(text.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                boolean flag = stringArray[i].equalsIgnoreCase(String.valueOf(alphabet.get(j)));
                boolean leadFlag = stringArray[i].equals(String.valueOf(alphabet.get(j)).toUpperCase());

                if (ALPHABET == RUSSIAN_ALPHABET && stringArray[j].equals("ы")) {
                    doneText = doneText + "ы";
                    break;
                }

                if (ALPHABET == RUSSIAN_ALPHABET && stringArray[j].equals("Ы")) {
                    doneText = doneText + "Ы";
                    break;
                }

                if (flag && leadFlag) {
                    doneText = doneText + Character.toUpperCase(alphabet.get(alphabet.size() - j - 1));
                    break;
                }
                if (flag) {
                    doneText = doneText + alphabet.get(alphabet.size() - j - 1);
                    break;
                }
                if (j == alphabet.size() - 1) {
                    doneText = doneText + stringArray[i];
                }
            }
        }
        return doneText;
    }
}
