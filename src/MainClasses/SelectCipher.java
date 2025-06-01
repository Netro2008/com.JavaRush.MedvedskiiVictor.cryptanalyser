package MainClasses;

import java.util.Scanner;

public class SelectCipher {
    public static int selectCipher() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello dear user of our program!" + "\n"
                + "We support some different ciphers, please select one which you need!");
        System.out.println("""
                Our ciphers
                1. Caesar Cipher
                2. Atbash Cipher
                0. Finish program""");
        System.out.print("Please select cipher: ");
        int numberForSelectingCipher;

        while(true) {
            try {
                numberForSelectingCipher = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer!");
                System.out.print("Try again: ");
                continue;
            }
            if (numberForSelectingCipher == 1) {
                break;
            } else if (numberForSelectingCipher == 2) {
                break;
            } else if (numberForSelectingCipher == 0) {
                break;
            }
            System.out.print("Please select cipher only from the ciphers below: ");
        }
        return numberForSelectingCipher;
    }
}
