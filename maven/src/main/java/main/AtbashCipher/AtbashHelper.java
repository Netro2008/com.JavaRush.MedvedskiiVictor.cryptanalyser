package main.AtbashCipher;
import java.util.Scanner;

public class AtbashHelper {
    public static int userChoiceInMainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                AtbashMainPhrases.youMustWriteANumber();
                continue;
            }
            if (choice == 1) {
                break;
            } else if (choice == 2) {
                break;
            } else if (choice == 9) {
                break;
            } else if (choice == 0) {
                break;
            } else {
                AtbashMainPhrases.nonExistentPointOfTheMenu();
            }
        }
        return choice;
    }

    public static int userChoiceInMenu() {
        int userChoice;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                AtbashMainPhrases.youMustWriteANumber();
                continue;
            }
            if (userChoice == 1) {
                break;
            } else if (userChoice == 2) {
                break;
            } else if (userChoice == 0) {
                break;
            } else {
                AtbashMainPhrases.nonExistentPointOfTheMenu();
            }
        }
        return userChoice;
    }
}
