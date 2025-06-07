package main.MainClasses;

import main.CaesarCipher.Cipher;

public class TypicalPhrases {
    public static void helloMethod(String cipherName) {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Вы выбрали русский язык!");
            System.out.println("Дорогой пользователь, добро пожаловать в программу по обработке шифра " + cipherName + "!");
            System.out.println("Алфавит приложения - русские буквы, пишите русскими буквами!" + "\n" + "Вот весь алфавит: ");
            for (int i = 0; i < Cipher.ALPHABET.size(); i++) {
                System.out.print(Cipher.ALPHABET.get(i) + " ");
                if (i == 8 || i == 16 || i == 24 || i == 32) {
                    System.out.println();
                }
            }
            System.out.println();
        } else {
            System.out.println("Dear user you have chosen the English language!");
            System.out.println("Remember if you work with files they will appear only after completing the program!");
            System.out.println("Welcome to the program! This is a program for working with the " + cipherName + " cipher." + "\n"
                    + "You have selected the English language. Look at the alphabet (letters that will change)!");
            for (int i = 0; i < Cipher.ALPHABET.size(); i++) {
                System.out.print(Cipher.ALPHABET.get(i) + " ");
                if (i == 5 || i == 11 || i == 17 || i == 23) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
}
