import java.util.Scanner;

public class Validator {

    public static int keySet () {
        Scanner scanner5 = new Scanner(System.in);
        int keySet = -1;
        while (keySet <= 0 || keySet >= 32) {
            try {
                keySet = Integer.parseInt(scanner5.nextLine());
            } catch (NumberFormatException exception) {
                keySet = -1;
                System.out.println("Вводите число!" + "\n" + "Повторите попытку снова:");
            }
            if (keySet <= 0 || keySet >= 32) {
                System.out.println("Ключ должен быть строго от 1 до 31!");
            }
        }
        return keySet;
    }

    public static int numberFormat () {
        int userChoice;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
                if (userChoice != 1 && userChoice != 2 && userChoice != 9) {
                    System.out.println("Вы выбрали несуществуйщий пункт, повторите попытку: ");
                    continue;
                }
                break;
            } catch (NumberFormatException exception) {
                System.out.print("Вы выбираете пункт в меню, это должно быть число!" + "\n" + "Повторите попытку: ");
            }
        }
        return userChoice;
    }

}