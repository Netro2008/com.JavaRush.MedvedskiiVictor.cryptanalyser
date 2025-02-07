import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static int key = -1;
    public static String textForRemaking;

    public static void main(String[] args) throws IOException {
        System.out.println("Дорогой пользователь, добро пожаловать в мою программу по обработке шифра Цезаря!");
        System.out.println("Алфавит приложения - русские буквы, пишите русскими буквами!" + "\n" + "Вот весь алфавит: ");
        for (int i = 0; i < Cipher.ALPHABET.size(); i++) {
            if (i == Cipher.ALPHABET.size() -1) {
                System.out.println(Cipher.ALPHABET.get(i));
                break;
            }
            System.out.print(Cipher.ALPHABET.get(i) + " ");
            if (i == 8 || i == 16 || i == 24 || i == 32) {
                System.out.println();
            }
        }

        Scanner scanner1 = new Scanner(System.in);
        int userChoice;
        boolean flag2 = true;
        while (flag2) {
            textForRemaking = "";
            System.out.println();
            System.out.println("""
                    Меню программы (полный функционал)
                    1. Шифрование
                    2. Расшифровка с ключом
                    3. Brute force
                    4. Статистический анализ
                    0. Выход""");
            System.out.println();
            System.out.print("Выберите нужный вам пункт: ");
            try {
                userChoice = Integer.parseInt(scanner1.nextLine());
            } catch (NumberFormatException exception) {
                System.out.println("Программа не смогла прочитать выбранный вами пункт(");
                System.out.print("Пожалуйста повторите попытку: ");
                userChoice = Integer.parseInt(scanner1.nextLine());
            }

            while (userChoice < 0 || userChoice > 4) {
                try {
                    System.out.print("Вы выбрали несуществующий пункт меню! Будьте внимательны!!!" + "\n" + "Повторите попытку ввода снова: ");
                    userChoice = Integer.parseInt(scanner1.nextLine());
                } catch (NumberFormatException exception1) {
                    System.out.print("Вы должны вводить число!!!" + "\n" + "Выберите пункт ещё раз: ");
                    userChoice = Integer.parseInt(scanner1.nextLine());
                }
            }
            switch (userChoice) {
                case 0:
                    System.out.println("Вы вышли завершили работу программы!");
                    flag2 = false;
                    break;

                case 1:
                    System.out.println();
                    System.out.println("""
                            Меню
                            1. Шифрование текста введённого в консоль
                            2. Шифрование текста из файла
                            9. Вернуться назад""");
                    System.out.println();
                    System.out.print("Выберите откуда вы будете считывать текст: ");
                    int clintChose1;

                    clintChose1 = Validator.numberFormat();

                    if (clintChose1 == 1) {
                        System.out.print("Введите текст в консоль для обработки: " + "\n");
                        textForRemaking = scanner1.nextLine();
                        System.out.print("""
                                Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                Убидитесь что прочитали текст ниже \uD83D\uDC47
                                """);
                        System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");

                        key = Validator.keySet();
                        String encryptedText = Cipher.encrypt(textForRemaking, key);
                        System.out.println(encryptedText);

                    } else if (clintChose1 == 2) {
                        String fileRead, fileRead2, reader;
                        Scanner scanner2 = new Scanner(System.in);
                        String encryptedText;
                        System.out.print("Введите путь к файлу, в котором находится текст, который необходимо зашифровать: ");
                        fileRead = scanner2.nextLine();
                        System.out.print("Введите ключ: ");

                        key = Validator.keySet();

                        System.out.print("Введите путь к файлу, в который нужно будет записать зашифровку: ");
                        fileRead2 = scanner2.nextLine();
                        try {
                            reader = FileManager.readFile(fileRead);
                            encryptedText = Cipher.encrypt(reader, key);
                            FileManager.writeFile(encryptedText, fileRead2);
                        } catch (FileNotFoundException exception) {
                            System.out.println("Извините программа не смогла найти какой-то из файлов!" + "\n" + "Возможно вы неправильно ввели их путь, проверьте правильность написания пути и попробуйте ещё раз!");
                            break;
                        }
                        System.out.println("Сообщение в вашем файле зашифровано и перемещено в файл под названием \"" + fileRead2 + "\"");

                    } else {
                        break;
                    }
                    break;

                case 2:
                    System.out.println("Дорогой пользователь вы зашли в отдел расшифровки сообщений зашифрованных шифром Цезаря!");
                    System.out.println("Пожалуйста убедитесь, что у вас есть ключ для расшифровки, иначе вернитесь назад и используйте такой метод расшифровки как \"Brute force\"");
                    System.out.println();
                    System.out.println("""
                            Меню
                            1. Расшифровка текста по ключу(его наличие обязательно) из консоли
                            2. Расшифровка текста по ключу(его наличие обязательно) с файла
                            9. Вернуться назад""");
                    System.out.println();
                    int clintChose2;
                    System.out.print("Выберите пункт меню: ");

                    clintChose2 = Validator.numberFormat();

                    if (clintChose2 == 1) {
                        System.out.println("Введите текст, который хотите расшифровать: ");
                        textForRemaking = scanner1.nextLine();
                        System.out.print("""
                                Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                Убидитесь что прочитали текст ниже \uD83D\uDC47
                                """);
                        System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");

                        key = Validator.keySet();
                        String decryptedText = Cipher.decrypt(textForRemaking, key);
                        System.out.println(decryptedText);

                    } else if (clintChose2 == 2) {
                        String filePath2, filePath3, reader2;
                        Scanner scanner3 = new Scanner(System.in);
                        String decryptedText;
                        System.out.print("Введите путь к файлу из которого вам нужно расшифровать текст: ");
                        filePath2 = scanner3.nextLine();
                        System.out.print("Введите ключ: ");

                        key = Validator.keySet();

                        System.out.print("Введите путь к файлу в который нужно будет записать расшифровку: ");
                        filePath3 = scanner3.nextLine();

                        try {
                            reader2 = FileManager.readFile(filePath2);
                            decryptedText = Cipher.decrypt(reader2, key);
                            FileManager.writeFile(decryptedText, filePath3);
                        } catch (FileNotFoundException exception) {
                            System.out.println("Извините программа не смогла найти какой-то из файлов!" + "\n" + "Возможно вы неправильно ввели их путь, проверьте правильность написания пути и попробуйте ещё раз!");
                            break;
                        }

                        System.out.println("Сообщение в вашем файле разшифровано и перемещено в файл под названием \"" + filePath3 + "\"" + "\n");
                    } else {
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Привет дорогой пользователь! Вы зашли в расшифровку BruteForce (расшифровка без ключа)!");
                    System.out.println();
                    System.out.println("""
                            Меню
                            1. Расшифровка текста с помощью BruteForce из консоли
                            2. Расшифровка текста с помощью BruteForce с файла
                            9. Вернуться назад""");
                    System.out.println();
                    System.out.print("Выберите нужный вам способ расшифровки: ");
                    int clintChose3;

                    clintChose3 = Validator.numberFormat();

                    if (clintChose3 == 1) {
                        System.out.println("Добро пожаловать в расшифровку методом BruteForce из консоли!" + "\n" + "Пожалуйста убедитесь, что вы вводите текст в 1 строчку, иначе лучше воспользуйтесь файлом!");
                        System.out.println("Введите текст, который вы желаете расшифровать и программа напишет вам все возможные варианты!" + "\n" + "Вам останется лишь выбрать какая расшифровка из них - верная");
                        Scanner scanner4 = new Scanner(System.in);
                        String bruteForceInput = scanner4.nextLine();
                        BruteForce.decryptByBruteForceConsole(bruteForceInput, Cipher.ALPHABET);

                    } else if (clintChose3 == 2) {
                        Scanner scanner4 = new Scanner(System.in);
                        System.out.println("Добро пожаловать в расшифровку методом BruteForce с файла!" + "\n" + "Помните, этот способ создан, чтобы расшифровать файл, если у вас нету ключа, по-другому говоря методом подборки!");
                        System.out.print("Введите путь к файлу, который вы хотите расшифровать с помощью метода BruteForce: ");
                        String filePath = scanner4.nextLine();
                        BruteForce.decryptByBruteForceFiles(filePath, Cipher.ALPHABET);
                        System.out.println("Спасибо, что воспользовались нашей программой, обязательно заглядывайте ещё!!");

                    } else {
                        break;
                    }
                case 4:

            }
        }
        scanner1.close();
    }
}