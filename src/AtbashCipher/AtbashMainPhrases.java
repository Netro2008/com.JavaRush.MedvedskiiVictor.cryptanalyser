package AtbashCipher;

import CaesarCipher.Cipher;

public class AtbashMainPhrases {
    public static void helloPhraseAtbashCipher() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Hello dear user, welcome to Atbash encrypting service!" +
                    "\n" + "Please choose the point of the menu which is provided below!");
            System.out.println();
        } else {
            System.out.print("Здравствуйте, спасибо, что используете мою программу связанную с шифрами!" +
                    "\n" + "Выберите нужный вам пункт из меню ниже!");
            System.out.println();
        }
    }

    public static void youMustWriteANumber() {
        if(Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please enter a number! Try again: ");
        } else {
            System.out.print("Вводите число! Попробуйте попытку ещё раз: ");
        }
    }

    public static void nonExistentPointOfTheMenu() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("You chose non-existent point of the menu! Please try again: ");
        } else {
            System.out.println("Вы выбрали несуществующий пункт меню! Повторите попытку выбора: ");
        }
    }

    public static void atbashCipherMeinMenu() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("Atbash cipher");
            System.out.println("""
                    Menu of the program:
                    1. Encrypting text
                    2. Decrypting text
                    0. Exit""");
            System.out.println();
            System.out.print("Please choose the point of the menu: ");
        } else {
            System.out.println("Шифр Атбаша");
            System.out.println("""
                    Меню программы:
                    1. Зашифровка текста
                    2. Расшифровка текста
                    0. Выход""");
            System.out.println();
            System.out.print("Пожалуйста выберите пункт меню: ");
        }
    }

    public static void fileOrConsoleMethod() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("""
                    The menu:
                    1. Encrypting text from console
                    2. Encrypting text from file
                    9. Back
                    0. Exit""");
            System.out.println();
            System.out.print("Please choose the point of the menu: ");
        } else {
            System.out.println("""
                    Меню программы:
                    1. Зашифровка текста введённого в консоль
                    2. Зашифровка текста взятого из файла
                    9. Назад
                    0. Выход""");
            System.out.println();
            System.out.print("Пожалуйста выберите пункт меню: ");
        }
    }

    public static void fileOrConsoleMethodDecrypting() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("""
                    The menu:
                    1. Decrypting text from console
                    2. Decrypting text from file
                    9. Back
                    0. Exit""");
            System.out.println();
            System.out.print("Please choose the point of the menu: ");
        } else {
            System.out.println("""
                    Меню программы:
                    1. Расшифровка текста введённого в консоль
                    2. Расшифровка текста взятого из файла
                    9. Назад
                    0. Выход""");
            System.out.println();
            System.out.print("Пожалуйста выберите пункт меню: ");
        }
    }

    public static void writeYourText() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please write text that you want to encrypt/decrypt: ");
        } else {
            System.out.print("Пожалуйста напишите текст, который хотите зашифровать/расшифровать: ");
        }
    }

    public static void writeFilePath() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please write file path to the file where text that you want to encrypt/decrypt is: ");
        } else {
            System.out.print("Пожалуйста введите путь к файлу, в котором находится текст для зашифровки/расшифровки: ");
        }
    }

    public static void writeSecondFilePath() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.print("Please write file path to the file where you want to write encrypted/decrypted text: ");
        } else {
            System.out.print("Пожалуйста введите путь к файлу, в котором находится зашифровка/расшифровка вашего текста: ");
        }
    }

    public static void endedEncryptingText() {
        if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
            System.out.println("Your text was encrypted and written to the file! End the program to see the result!");
        } else {
            System.out.println("Ваш текст был зашифрован и записан в файл! Завершите работу программы, чтобы увидеть результат!");
        }
    }
}
