import java.io.IOException;
import java.util.Scanner;

public class Validator {
    public static int counter = 0;

    public static int keySet () {
        Scanner scanner = new Scanner(System.in);
        int keySet = -1;
        counter = 0;
        while (true) {
            if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                if (counter == 3) {
                    System.out.println();
                    System.out.println("You wrote the wrong key 3 times in a row, please make sure that you selected the point of the menu correctly and run the program again!"
                            + "\n" + "The program was completed!");
                    break;
                }
            } else {
                if (counter == 3) {
                    System.out.println();
                    System.out.println("Вы ввели ключ неправильно 3 раза, убедитесь, что вы делаете то, что нужно и перезапустите программу!");
                    break;
                }
            }

            try {
                keySet = Integer.parseInt(scanner.nextLine());
                System.out.println();
            } catch (NumberFormatException exception) {
                keySet = -1;
                if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                    System.out.print("You must write the number!" + "\n" + "Try again please: ");
                } else {
                    System.out.print("Вводите число!" + "\n" + "Повторите попытку снова: ");
                }
                counter++;
                continue;
            }

            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                if (keySet <= 0 || keySet >= 32 && counter != 2) {
                    System.out.print("Ключ должен быть строго от 1 до 31!" + "\n" + "Повторите попытку ввода: ");
                    counter++;
                    continue;
                }
                if (keySet <= 31) {
                    break;
                }
            } else {
                if (keySet <= 0 || keySet >= 26 && counter != 2) {
                    System.out.print("The key must be in range from 1 to 25!" + "\n" + "Try to enter the key again please: ");
                    counter++;
                    continue;
                }
                if (keySet <= 25) {
                    break;
                }
            }
            counter++;
        }
        return keySet;
    }

    public static String filePathRead () {
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.nextLine();
        counter = 0;

        while (true) {
            if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                if (counter == 3) {
                    System.out.println();
                    System.out.println("You wrote filepath incorrectly 3 times in a row!" + "\n" +
                            "The program was completed, but you can always start it again! Next time be careful");
                    break;
                }
            } else {
                if (counter == 3) {
                    System.out.println();
                    System.out.println("Вы ввели путь к файлу неверно 3 раза подряд!" + " Убедитесь, что вы выбрали правильный пункт меню и запустите программу снова!"
                            + "\n" + "Мы завершили работу программы!");
                    break;
                }
            }

            if (filePath == null) {
                filePath = scanner.nextLine();
                System.out.println();
            }
            try {
                FileManager.readFile(filePath);
            } catch (IOException exception) {
                if (counter != 2) {
                    if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                        System.out.print("Check the filepath you wrote!" + " The program can't find your file or something went wrong" + "\n" + "Try again please: ");
                    } else {
                        System.out.print("Проверьте путь, который вы написали!" + "\n" + "Повторите попытку: ");
                    }
                }
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
        int menuChose, counter1 = 0;

        while (true) {
            try {
                menuChose = Integer.parseInt(scanner.nextLine());
                System.out.println();
                if (menuChose == 1 || menuChose == 2 || menuChose == 9) {
                    break;
                }
            } catch (NumberFormatException exception) {
                if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                    System.out.print("You must write the number!" + "\n" + "Try again please: ");
                } else {
                    System.out.print("Вы должны вводить число!" + "\n" + "Повторите попытку ввода: ");
                }
                continue;
            }
            if (counter1 != 0) {
                if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                    System.out.print("You have chosen non-existent point of the menu! Try again please: ");
                } else {
                    System.out.print("Вы выбрали несуществующий пункт меню, повторите попытку снова: ");
                }
            }
            counter1++;
        }
        return menuChose;
    }
}