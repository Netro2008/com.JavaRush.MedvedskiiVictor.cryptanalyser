import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MainApp {
    public static int key;
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
        boolean flag1;
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

            while (userChoice < 0 || userChoice > 3) {
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
                    flag1 = true;
                    System.out.println();
                    System.out.println("""
                            Меню
                            1. Шифрование текста введённого в консоль
                            2. Шифрование текста из файла
                            9. Вернуться назад""");
                    System.out.println();
                    System.out.print("Выберите откуда вы будете считывать текст: ");
                    int clintChose1, count1 = 0;

                    try {
                        clintChose1 = Integer.parseInt(scanner1.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Программа не смогла прочитать выбранный вами пункт(");
                        System.out.print("Пожалуйста повторите попытку: ");
                        clintChose1 = Integer.parseInt(scanner1.nextLine());
                    }

                    while (clintChose1 != 1 && clintChose1 != 2 && clintChose1 != 9) {
                        try {
                            if (count1 != 0) {
                                System.out.print("Вы выбрали несуществуйщий пункт, повторите попытку: ");
                                clintChose1 = Integer.parseInt(scanner1.nextLine());
                            }
                            if (clintChose1 == 1 || clintChose1 == 2 || clintChose1 == 9) {
                                break;
                            }
                            count1++;
                        } catch (NumberFormatException exception2) {
                            System.out.print("Вы выбираете пункт в меню, это должно быть число!" + "\n" + "Повторите попытку: ");
                            clintChose1 = Integer.parseInt(scanner1.nextLine());
                        }
                    }

                    if (clintChose1 == 1) {
                        System.out.print("Введите текст в консоль для обработки: " + "\n");
                        textForRemaking = scanner1.nextLine();
                        System.out.print("""
                                Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                Убидитесь что прочитали текст ниже \uD83D\uDC47
                                """);
                        System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");
                        key = Integer.parseInt(scanner1.nextLine());
                        while (flag1) {
                            try {
                                if (key >= 1 && key <= 31) {
                                    System.out.println("Ключ введён верно, результат мы вывели в консоли под этим сообщением!");
                                    String str = Cipher.encrypt(textForRemaking, key);
                                    System.out.println(str);
                                    flag1 = false;
                                } else {
                                    System.out.print("Ключ введён неверно! Повторите попытку:" + "\n");
                                    key = Integer.parseInt(scanner1.nextLine());
                                }
                            } catch (NumberFormatException exception) {
                                System.out.print("Будьте внимательны, вводите число!" + "\n" + "Введите номер выбранного пункта меню ещё раз: ");
                                key = Integer.parseInt(scanner1.nextLine());
                            }
                        }
                    } else if (clintChose1 == 2) {
                        String fileRead, fileRead2, reader;
                        Scanner scanner2 = new Scanner(System.in);
                        String encryptedText;
                        System.out.print("Введите путь к файлу, в котором находится текст, который необходимо зашифровать: ");
                        fileRead = scanner2.nextLine();
                        System.out.print("Введите ключ: ");
                        key = Integer.parseInt(scanner2.nextLine());
                        while (flag1) {
                            try {
                                if (key >= 1 && key <= 31) {
                                    System.out.println("Ключ введён верно!");
                                    flag1 = false;
                                } else {
                                    System.out.print("Ключ введён неверно! Повторите попытку:" + "\n");
                                    key = Integer.parseInt(scanner1.nextLine());
                                }
                            } catch (NumberFormatException exception3) {
                                System.out.print("Ключ должен быть числом! Введите число: ");
                                key = Integer.parseInt(scanner1.nextLine());
                            }
                        }
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
                    int clintChose2, count2 = 0;
                    System.out.print("Выберите пункт меню: ");

                    try {
                        clintChose2 = Integer.parseInt(scanner1.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Программа не смогла прочитать выбранный вами пункт(");
                        System.out.print("Пожалуйста повторите попытку: ");
                        clintChose2 = Integer.parseInt(scanner1.nextLine());
                    }

                    while (clintChose2 != 1 && clintChose2 != 2 && clintChose2 != 9) {
                        try {
                            if (count2 != 0) {
                                System.out.print("Вы выбрали несуществуйщий пункт, повторите попытку: ");
                                clintChose2 = Integer.parseInt(scanner1.nextLine());
                            }
                            if (clintChose2 == 1 || clintChose2 == 2 || clintChose2 == 9) {
                                break;
                            }
                            count2++;
                        } catch (NumberFormatException exception4) {
                            System.out.print("Вам необходимо ввести номер пункта, это должно быть число!" + "\n" + "Повторите попытку ввода: ");
                            clintChose2 = Integer.parseInt(scanner1.nextLine());
                        }
                    }

                    boolean flag3 = true;
                    if (clintChose2 == 1) {
                        System.out.println("Введите текст, который хотите расшифровать: ");
                        textForRemaking = scanner1.nextLine();
                        System.out.print("""
                                Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                Убидитесь что прочитали текст ниже \uD83D\uDC47
                                """);
                        System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");
                        key = Integer.parseInt(scanner1.nextLine());
                        while (flag3) {
                            try {
                                if (key >= 1 && key <= 31) {
                                    System.out.println("Ключ введён верно!");
                                    System.out.println("Вот расшифрованный текст: " + "\n" + Cipher.decrypt(textForRemaking, key));
                                    flag3 = false;
                                } else {
                                    System.out.print("Ключ введён неверно! Повторите попытку:" + "\n");
                                    key = Integer.parseInt(scanner1.nextLine());
                                }
                            } catch (NumberFormatException exception5) {
                                System.out.print("Вводите число!" + "\n" + "Повторите попытку ввода: ");
                                key = Integer.parseInt(scanner1.nextLine());
                            }
                        }

                    } else if (clintChose2 == 2) {
                        String filePath2, filePath3, reader2;
                        Scanner scanner3 = new Scanner(System.in);
                        String decryptedText;
                        System.out.print("Введите путь к файлу из которого вам нужно расшифровать текст: ");
                        filePath2 = scanner3.nextLine();
                        System.out.print("Введите ключ: ");
                        key = Integer.parseInt(scanner3.nextLine());
                        while (flag3) {
                            try {
                                if (key >= 1 && key <= 31) {
                                    System.out.println("Ключ введён верно!");
                                    flag3 = false;
                                } else {
                                    System.out.print("Ключ введён неверно! Повторите попытку:" + "\n");
                                    key = Integer.parseInt(scanner1.nextLine());
                                }
                            } catch (NumberFormatException exception6) {
                                System.out.print("Ключ должен являться числом!" + "\n" + "Повторите попытку ввода ключа: ");
                                key = Integer.parseInt(scanner1.nextLine());
                            }
                        }
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
                    int clintChose3, count3 = 0;

                    try {
                        clintChose3 = Integer.parseInt(scanner1.nextLine());
                    } catch (NumberFormatException exception) {
                        System.out.println("Программа не смогла прочитать выбранный вами пункт(");
                        System.out.print("Пожалуйста повторите попытку: ");
                        clintChose3 = Integer.parseInt(scanner1.nextLine());
                    }

                    while (clintChose3 != 1 && clintChose3 != 2 && clintChose3 != 9) {
                        try {
                            if (count3 != 0) {
                                System.out.print("Вы выбрали несуществуйщий пункт, повторите попытку: ");
                                clintChose3 = Integer.parseInt(scanner1.nextLine());
                            }
                            if (clintChose3 == 1 || clintChose3 == 2 || clintChose3 == 9) {
                                break;
                            }
                            count3++;
                        } catch (NumberFormatException exception7) {
                            System.out.print("Вводите число, будьте осторожны!" + "Повторите попытку ввода: ");
                            clintChose3 = Integer.parseInt(scanner1.nextLine());
                        }
                    }
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
            }
        }
        scanner1.close();
    }
}