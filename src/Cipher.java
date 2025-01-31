import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cipher {
    public static String textForEncrypt = "";
    public static String textForDecrypt = "";

    private static List<Character> ALPHABET = Arrays.asList('а', 'б',
            'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');


    public Cipher(ArrayList<Character> list) {
        ALPHABET = list;
    }

    public static String encrypt(String text, int key) {
        textForEncrypt = "";
        int alphabetIndex = 0, textIndex = 0, key2;
        char[] lettersFromText = text.toCharArray();
        int stringLength = text.length();
        while (textIndex < stringLength) {
            boolean checkingUpperCase = ALPHABET.get(alphabetIndex).equals(Character.toLowerCase(lettersFromText[textIndex])) && Character.isUpperCase(lettersFromText[textIndex]);
            boolean checking = ALPHABET.get(alphabetIndex).equals(lettersFromText[textIndex]);
            boolean symbolNotFound = alphabetIndex == ALPHABET.size() - 1 && !checking && !checkingUpperCase;

            if (alphabetIndex + key >= ALPHABET.size() && checkingUpperCase) {
                key2 = alphabetIndex + key - ALPHABET.size();
                alphabetIndex = 0;
                alphabetIndex = alphabetIndex + key2;
                textForEncrypt = textForEncrypt.concat(String.valueOf(Character.toUpperCase(ALPHABET.get(alphabetIndex))));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (alphabetIndex + key >= ALPHABET.size() && checking) {
                key2 = alphabetIndex + key - ALPHABET.size();
                alphabetIndex = 0;
                alphabetIndex = alphabetIndex + key2;
                textForEncrypt = textForEncrypt.concat(String.valueOf(ALPHABET.get(alphabetIndex)));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (checkingUpperCase) {
                alphabetIndex = alphabetIndex + key;
                textForEncrypt = textForEncrypt.concat(String.valueOf(Character.toUpperCase(ALPHABET.get(alphabetIndex))));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }
            if (checking) {
                alphabetIndex = alphabetIndex + key;
                textForEncrypt = textForEncrypt.concat(String.valueOf(ALPHABET.get(alphabetIndex)));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (symbolNotFound) {
                textForEncrypt = textForEncrypt.concat(String.valueOf(lettersFromText[textIndex]));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }
            alphabetIndex++;
        }

        return textForEncrypt;
    }

    public static String decrypt(String encryptedText, int key) {
        textForDecrypt = "";
        int alphabetIndex = 0, textIndex = 0, key2;
        char[] lettersFromText = encryptedText.toCharArray();
        int stringLength = encryptedText.length();

        while (textIndex < stringLength) {
            boolean checking = ALPHABET.get(alphabetIndex).equals(lettersFromText[textIndex]);
            boolean checkingUpperCase = ALPHABET.get(alphabetIndex).equals(Character.toLowerCase(lettersFromText[textIndex])) && Character.isUpperCase(lettersFromText[textIndex]);
            boolean symbolNotFound2 = alphabetIndex == ALPHABET.size() - 1 && !checking && !checkingUpperCase;

            if (alphabetIndex - key < 0 && checkingUpperCase) {
                key2 = Math.abs(key - alphabetIndex);
                alphabetIndex = ALPHABET.size();
                alphabetIndex = alphabetIndex - key2;
                textForDecrypt = textForDecrypt.concat(String.valueOf(Character.toUpperCase(ALPHABET.get(alphabetIndex))));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (alphabetIndex - key < 0 && checking) {
                key2 = Math.abs(key - alphabetIndex);
                alphabetIndex = ALPHABET.size();
                alphabetIndex = alphabetIndex - key2;
                textForDecrypt = textForDecrypt.concat(String.valueOf(ALPHABET.get(alphabetIndex)));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (checking) {
                alphabetIndex = alphabetIndex - key;
                textForDecrypt = textForDecrypt.concat(String.valueOf(ALPHABET.get(alphabetIndex)));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (checkingUpperCase) {
                alphabetIndex = alphabetIndex - key;
                textForDecrypt = textForDecrypt.concat(String.valueOf(Character.toUpperCase(ALPHABET.get(alphabetIndex))));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }

            if (symbolNotFound2) {
                textForDecrypt = textForDecrypt.concat(String.valueOf(lettersFromText[textIndex]));
                textIndex++;
                alphabetIndex = 0;
                continue;
            }
            alphabetIndex++;
        }

        return textForDecrypt;
    }
}
