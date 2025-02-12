import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Cipher {
    public static String textForEncrypt = "";
    public static String textForDecrypt = "";

    protected static final List<Character> RUSSIAN_ALPHABET = Arrays.asList('а', 'б',
            'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

    protected static final List<Character> ENGLISH_ALPHABET = Arrays.asList('a', 'b',
            'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z');

    protected static List<Character> ALPHABET;


    public static void setLanguage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Our supporting languages
                1. English
                2. Russian
                0. Exit""");
        System.out.println();
        System.out.print("Choose the language of the program that you need: ");
        int clintChose;
        while (true) {
            try {
                clintChose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("You must write the number!" + " Be careful and try again: ");
                continue;
            }

            if (clintChose == 1) {
                ALPHABET = ENGLISH_ALPHABET;
            } else if (clintChose == 2) {
                ALPHABET = RUSSIAN_ALPHABET;
            } else if (clintChose == 0) {
                break;
            } else {
                System.out.print("You have selected a non-existent language! Please try again: ");
                continue;
            }
            break;
        }
        System.out.println();
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
