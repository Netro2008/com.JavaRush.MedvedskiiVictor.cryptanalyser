import java.io.IOException;
import java.util.Scanner;

public class Validator {
    public static int counter = 0;

    public static int keySet () {
        Scanner scanner5 = new Scanner(System.in);
        int keySet = -1;
        counter = 0;
        while (keySet <= 0 || keySet >= 32) {
            if (counter == 3) {
                System.out.println("Вы ввели ключ неправильно 3 раза, убедитесь, что вы делаете то, что нужно и перезапустите программу!");
                break;
            }
            try {
                keySet = Integer.parseInt(scanner5.nextLine());
            } catch (NumberFormatException exception) {
                keySet = -1;
                System.out.println("Вводите число!" + "\n" + "Повторите попытку снова:");
                counter++;
                continue;
            }

            if (keySet <= 0 || keySet >= 32) {
                System.out.println("Ключ должен быть строго от 1 до 31!");
                counter++;
            }
        }
        return keySet;
    }

    public static String filePathRead () {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        counter = 0;

        while (true) {
            if (counter == 3) {
                System.out.println("Вы ввели путь к файлу неверно 3 раза подряд!" + "Убедитесь, что вы выбрали правильный пункт меню и запустите программу снова!"
                        + "\n" + "Мы завершили работу программы!");
                break;
            }
            try {
                FileManager.readFile(filePath);
            } catch (IOException exception) {
                System.out.println("Проверьте путь, который вы написали!");
                filePath = null;
                counter++;
                continue;
            }
            if (filePath != null) {
                break;
            }
        }
        return filePath;
    }

    public static int choseMenu () {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int menuChose, counter = 0;

        while (true) {
            try {
                if (counter != 0) {
                    System.out.print("Вы выбрали несуществующий пункт меню, повторите попытку снова: ");
                }
                menuChose = Integer.parseInt(scanner.nextLine());
                if (menuChose == 1 || menuChose == 2 || menuChose == 9) {
                    break;
                }
                counter++;
            } catch (NumberFormatException exception) {
                System.out.println("Вы должны вводить число!");
            }
        }
        return menuChose;
    }
}