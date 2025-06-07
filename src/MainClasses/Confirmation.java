package MainClasses;

import CaesarCipher.Cipher;

import java.util.IllegalFormatException;
import java.util.Scanner;

public class Confirmation {
    public static int confirmationOfContinuingWorkingProgram() {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        System.out.println("""
                    Confirmation menu:
                    1. Continue using program
                    2. Finish the program""");
        System.out.println();

        while (true) {
            try {
                userChoice = scanner.nextInt();
            } catch (IllegalFormatException exception) {
                if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
                    System.out.print("You must write a number! Please try again: ");
                } else {
                    System.out.println("Вы написали не число! Пожалуйста, попробуйте снова: ");
                }
                continue;
            }

            if (userChoice == 1 || userChoice == 2) {
                break;
            } else {
                if (Cipher.ALPHABET == Cipher.ENGLISH_ALPHABET) {
                    System.out.print("You must write a number between 1 and 2! Please try again: ");
                } else {
                    System.out.println("Вы должны написать число от 1 до 2! Пожалуйста, попробуйте снова: ");
                }
            }
        }
        return userChoice;
    }
}
