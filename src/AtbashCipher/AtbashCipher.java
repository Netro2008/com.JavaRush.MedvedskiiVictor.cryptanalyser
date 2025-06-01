package AtbashCipher;

import java.util.List;

import static CaesarCipher.Cipher.*;

public class AtbashCipher {
    public static String encryptTextFromConsole(String text, List<Character> alphabet) {
        String resultOfMethod = "";
        String [] stringArray = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            stringArray[i] = String.valueOf(text.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                boolean flag = stringArray[i].equalsIgnoreCase(String.valueOf(ENGLISH_ALPHABET.get(j)));
                boolean leadFlag = stringArray[i].equals(String.valueOf(ENGLISH_ALPHABET.get(j)).toUpperCase());

                if (flag && leadFlag) {
                    resultOfMethod = resultOfMethod + Character.toUpperCase(ENGLISH_ALPHABET.get(ENGLISH_ALPHABET.size() - j - 1));
                    break;
                }
                if (flag) {
                    resultOfMethod = resultOfMethod + ENGLISH_ALPHABET.get(ENGLISH_ALPHABET.size() - j - 1);
                    break;
                }
                if (j == alphabet.size() - 1) {
                    resultOfMethod = resultOfMethod + stringArray[i];
                }
            }
        }
        return resultOfMethod;
    }

    public static String decryptTextFromConsole(String text, List<Character> alphabet) {
        String decryptedText = "";
        String [] stringArray = new String[text.length()];
        for (int i = 0; i < text.length(); i++) {
            stringArray[i] = String.valueOf(text.charAt(i));
        }

        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < alphabet.size(); j++) {
                boolean flag = stringArray[i].equalsIgnoreCase(String.valueOf(ENGLISH_ALPHABET.get(j)));
                boolean leadFlag = stringArray[i].equals(String.valueOf(ENGLISH_ALPHABET.get(j)).toUpperCase());

                if (flag && leadFlag) {
                    decryptedText = decryptedText + Character.toUpperCase(ENGLISH_ALPHABET.get(ENGLISH_ALPHABET.size() - j - 1));
                    break;
                }
                if (flag) {
                    decryptedText = decryptedText + ENGLISH_ALPHABET.get(ENGLISH_ALPHABET.size() - j - 1);
                    break;
                }
                if (j == alphabet.size() - 1) {
                    decryptedText = decryptedText + stringArray[i];
                }
            }
        }
        return decryptedText;
    }
}
