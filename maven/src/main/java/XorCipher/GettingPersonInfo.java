package XorCipher;

import java.util.ArrayList;
import java.util.Scanner;

public class GettingPersonInfo {
    public static String gettingUserText() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int gettingUserChoice(boolean forthElement) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 999;

        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("Please enter a number, not something else! Try again: ");
            }
            if (userChoice == 1 || userChoice == 2 || userChoice == 0) {
                break;
            }

            if (forthElement && userChoice == 9) {
                break;
            }
        }

        return userChoice;
    }
}
