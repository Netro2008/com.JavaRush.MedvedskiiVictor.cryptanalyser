package XorCipher;

import CaesarCipher.Cipher;

public class MainPhrasesXOR {
    public static void helloPhrase() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("Hello dear user, welcome to XOR cipher program!");
            System.out.println("""
                                Menu:
                                1. Encrypting text
                                2. Decrypting text
                                0. Exit""");
            System.out.print("Please choose one of the following options: ");
        } else {
            System.out.println("Добро пожаловать в программу по шифру XOR!");
            System.out.println("""
                                Меню:
                                1. Зашифровка текста
                                2. Расшифровка текста
                                0. Выход""");
            System.out.print("Пожалуйста выберите один из следующих пунктов меню: ");
        }
    }

    public static void pleaseWriteText() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please write text that you want to be encrypted: ");
        } else {
            System.out.print("Пожалуйста введите текст, который вы хотите зашифровать: ");
        }
    }

    public static void welcomeToEncryptingDecryptingMethod(boolean decrypting) {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("Welcome to encrypting/decrypting method!");

            if (!decrypting) {
                System.out.println("""
                        Menu:
                        1. Encrypting text from console
                        2. Encrypting text from file
                        9. Back
                        0. Exit""");
                System.out.print("Please choose one of the following options: ");
            } else {
                System.out.println("""
                        Menu:
                        1. Decrypting text from console
                        2. Decrypting text from file
                        9. Back
                        0. Exit""");
                System.out.print("Please choose one of the following options: ");
            }
        } else {
            System.out.print("Добро пожаловать в метод по зашифровке/расшифровке текста!");

            if (!decrypting) {
                System.out.println("""
                        Меню:
                        1. Зашифровка текста из консоли
                        2. Зашифровка текста из файла
                        9. Назад
                        0. Выход""");
                System.out.print("Пожалуйста выберите один из следующих пунктов меню: ");
            } else {
                System.out.println("""
                        Меню:
                        1. Расшифровка текста из консоли
                        2. Расшифровка текста из файла
                        9. Назад
                        0. Выход""");
                System.out.print("Пожалуйста выберите один из следующих пунктов меню: ");
            }
        }
    }

    public static void userWroteNotAWord() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please enter a word, not something else! Try again: ");
        } else {
            System.out.print("Пожалуйста введите только 1 слово! Попробуйте ещё раз: ");
        }
    }

    public static void endedEncryptingOrDecryptingText() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("The result of the method work is written below the message in coding Base64 format!");
        } else {
            System.out.println("Результат метода мы вывели на экран под этим сообщением в формате кодировки Base64!");
        }
    }

    public static void endedEncryptingOrDecryptingTextToFile() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("The result of the method is written to the file, please end the program to see the result!");
        } else {
            System.out.println("Результат метода мы записали в файл! Для отображения результата завершите работу программы!");
        }
    }

    public static void endedDecryptingText() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("The result of the method work is written below the message!");
        } else {
            System.out.println("Результат метода мы вывели на экран под этим сообщением!");
        }
    }
}
