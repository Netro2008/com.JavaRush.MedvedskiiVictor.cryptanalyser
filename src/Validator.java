import java.io.IOException;
import java.util.Scanner;

public class Validator {
    public static int counter = 0;

    public static int keySet () {
        Scanner scanner5 = new Scanner(System.in);
        int keySet = -1;
        counter = 0;
        while (keySet <= 0 || keySet >= 32) {
            try {
                keySet = Integer.parseInt(scanner5.nextLine());
            } catch (NumberFormatException exception) {
                keySet = -1;
                System.out.println("Вводите число!" + "\n" + "Повторите попытку снова:");
            }

            if (keySet <= 0 || keySet >= 32) {
                System.out.println("Ключ должен быть строго от 1 до 31!");
                counter++;
            }

            if (counter == 3) {
                System.out.println("Вы ввели ключ неправильно 3 раза, убедитесь, что вы делаете то, что нужно и перезапустите программу!");
                break;
            }
        }
        return keySet;
    }

    public static int numberFormat () {
        int userChoice = -1;
        Scanner scanner = new Scanner(System.in);
        counter = 0;

        while (true) {
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                System.out.print("Вы выбираете пункт в меню, это должно быть число!" + "\n" + "Повторите попытку: ");
                counter++;
            }
            if (userChoice != 1 && userChoice != 2 && userChoice != 9) {
                System.out.println("Вы выбрали несуществуйщий пункт, повторите попытку: ");
                counter++;
                continue;
            }
            if (counter == 3) {
                System.out.println("Вы ввели ключ неправильно 3 раза, убедитесь, что вы делаете то, что нужно и перезапустите программу!");
                break;
            }
            break;
        }
        return userChoice;
    }

    public static String filePathRead () {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        counter = 0;

        while (true) {
            try {
                FileManager.readFile(filePath);
            } catch (IOException exception) {
                System.out.println("Проверьте путь, который вы написали!");
                filePath = null;
                counter++;
            }
            if (filePath != null) {
                break;
            }
            if (counter == 3) {
                System.out.println("Вы ввели путь к файлу неверно 3 раза подряд!" + "Убедитесь, что вы выбрали правильный пункт меню и запустите программу снова!"
                + "\n" + "Мы завершили работу программы!");
                break;
            }
        }
        return filePath;
    }
}