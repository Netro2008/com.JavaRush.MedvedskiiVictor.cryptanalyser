import java.io.IOException;
import java.util.Scanner;

public class MainCode {
    public static int key = -1;
    public static String textForRemakingRussian;
    public static boolean flag2 = true;

    public static void programStart () throws IOException {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Дорогой пользователь, добро пожаловать в мою программу по обработке шифра Цезаря!");
            System.out.println("Алфавит приложения - русские буквы, пишите русскими буквами!" + "\n" + "Вот весь алфавит: ");
            for (int i = 0; i < Cipher.ALPHABET.size(); i++) {
                System.out.print(Cipher.ALPHABET.get(i) + " ");
                if (i == 8 || i == 16 || i == 24 || i == 32) {
                    System.out.println();
                }
            }
        } else {
            System.out.println("Remember if you work with files they will appear only after closing the program!");
            System.out.println("Dear user, welcome to my program!" + " This is a program for working with the Caesar cipher." + "\n"
                    + "You selected an English language. Look at the alphabet (letters that will change)!");
            System.out.println();
            for (int i = 0; i < Cipher.ALPHABET.size(); i++) {
                System.out.print(Cipher.ALPHABET.get(i) + " ");
                if (i == 5 || i == 11 || i == 17 || i == 23) {
                    System.out.println();
                }
            }
            System.out.println();
        }

        Scanner scanner1 = new Scanner(System.in);
        int userChoice;
        while (flag2 && Validator.counter != 3) {
            textForRemakingRussian = "";
            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
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
            } else {
                System.out.println();
                System.out.println("""
                    Menu of the program:
                    1. Encrypting text
                    2. Decrypting text
                    3. Brute force
                    4. Statistical analysis
                    0. Exit""");
                System.out.println();
                System.out.print("Choose the point of the menu please: ");
            }
            userChoice = -1;

            while (userChoice < 0 || userChoice > 4) {
                try {
                    userChoice = Integer.parseInt(scanner1.nextLine());
                } catch (NumberFormatException exception1) {
                    if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                        System.out.print("Вы должны вводить число!!!" + "\n" + "Выберите пункт ещё раз: ");
                    } else {
                        System.out.print("Hey, you must write numbers, be careful!" + "\n" + "Select point of the menu again: ");
                    }
                    continue;
                }
                if (userChoice < 0 || userChoice > 4) {
                    if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                        System.out.print("Вы выбрали несуществующий пункт меню!" + " Повторите попытку: ");
                    } else {
                        System.out.print("You have selected a non-existent point! Please try again: ");
                    }
                }
                switch (userChoice) {
                    case 0:
                        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                            System.out.println("Вы вышли завершили работу программы!");
                        } else {
                            System.out.println("Program was closed! Thanks for using it, hope to see you again!");
                        }
                        flag2 = false;
                        break;

                    case 1:
                        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                            System.out.println();
                            System.out.println("""
                                    Меню
                                    1. Шифрование текста введённого в консоль
                                    2. Шифрование текста из файла
                                    9. Вернуться назад""");
                            System.out.println();
                            System.out.print("Выберите откуда вы будете считывать текст: ");
                        } else {
                            System.out.println();
                            System.out.println("""
                                Menu
                                1. Encrypting the text entered in the console
                                2. Encrypting text from a file
                                9. Go back""");
                            System.out.println();
                            System.out.print("Choose the point of the menu please: ");
                        }
                        int clintChose1;

                        clintChose1 = Validator.choseMenu();

                        if (clintChose1 == 1) {
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите текст в консоль для обработки: " + "\n");
                            } else {
                                System.out.print("Please write the text down below which you want to be encrypted: ");
                            }
                            textForRemakingRussian = scanner1.nextLine();
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("""
                                        Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                        Убидитесь что прочитали текст ниже \uD83D\uDC47
                                        """);
                                System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");
                            } else {
                                System.out.print("Please write a key (the amount by which the letters will be moved)! \uD83D\uDC47" + "\n" +
                                        "Your key must be in range from 1 to 25: ");
                            }

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            String encryptedText = Cipher.encrypt(textForRemakingRussian, key);
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Результат мы вывели на экран строкой ниже!");
                            } else {
                                System.out.println("The result we wrote right below the message!");
                            }
                            System.out.println(encryptedText);

                        } else if (clintChose1 == 2) {
                            String fileRead, fileRead2, reader;
                            String encryptedText;
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу, в котором находится текст, который необходимо зашифровать: ");
                            } else {
                                System.out.print("Please write filepath, where the text which you need to encrypt is: ");
                            }
                            fileRead = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите ключ: ");
                            } else {
                                System.out.print("Input key please: ");
                            }

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу, в который нужно будет записать зашифровку: ");
                            } else {
                                System.out.print("Write filepath where we will write your encrypted text: ");
                            }
                            fileRead2 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            reader = FileManager.readFile(fileRead);
                            encryptedText = Cipher.encrypt(reader, key);
                            FileManager.writeFile(encryptedText, fileRead2);
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Мы записали зашифровку в файл под названием " + fileRead2);
                            } else {
                                System.out.println("We wrote encrypted text right in your file \" " + fileRead2 + "\"");
                            }

                        } else {
                            break;
                        }
                        break;

                    case 2:
                        int clintChose2;
                        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                            System.out.println("Дорогой пользователь вы зашли в отдел расшифровки сообщений зашифрованных шифром Цезаря!");
                            System.out.println("Пожалуйста убедитесь, что у вас есть ключ для расшифровки, иначе вернитесь назад и используйте такой метод расшифровки как \"Brute force\" или Статистическим анализом!");
                            System.out.println();
                            System.out.println("""
                                    Меню
                                    1. Расшифровка текста по ключу(его наличие обязательно) из консоли
                                    2. Расшифровка текста по ключу(его наличие обязательно) с файла
                                    9. Вернуться назад""");
                            System.out.println();
                            System.out.print("Выберите пункт меню: ");
                        } else {
                            System.out.println("Dear user, you have entered the department of decoding messages encrypted with the Caesar cipher!");
                            System.out.println();
                            System.out.println("""
                                Menu
                                1. Decryption of the text by the key (it's presence is mandatory) from the console
                                2. Decryption of the text by the key (it's presence is mandatory) from the file
                                9. Go back""");
                            System.out.println();
                            System.out.println("Please be sure that you have the key to decrypt the text or go back to the menu \"9\" and run BruteForce or Statistical analysis!");
                            System.out.print("Choose the point of the menu: ");
                        }

                        clintChose2 = Validator.choseMenu();

                        if (clintChose2 == 1) {
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите текст, который хотите расшифровать: ");
                            } else {
                                System.out.print("Write the text that you want to be decrypted: ");
                            }

                            textForRemakingRussian = scanner1.nextLine();
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("""
                                        Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                        Убидитесь что прочитали текст ниже \uD83D\uDC47
                                        """);
                                System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");
                            } else {
                                System.out.print("Please write a key (the amount by which the letters will be moved)! \uD83D\uDC47" + "\n" +
                                        "Your key must be in range from 1 to 25: ");
                            }

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            String decryptedText = Cipher.decrypt(textForRemakingRussian, key);

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Расшифрованный текст мы вам написали прямо под этим сообщением!");
                            } else {
                                System.out.println("We wrote decrypted text right below the message!");
                            }
                            System.out.println(decryptedText);

                        } else if (clintChose2 == 2) {
                            String filePath2, filePath3, reader2;
                            String decryptedText;

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу из которого вам нужно расшифровать текст: ");
                            } else {
                                System.out.print("Please write filepath to the file text from which we will decrypt: ");
                            }
                            filePath2 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите ключ: ");
                            } else {
                                System.out.print("Input key: ");
                            }

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу в который нужно будет записать расшифровку: ");
                            } else {
                                System.out.print("Please write filepath to the file where we will write decrypted text: ");
                            }
                            filePath3 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            reader2 = FileManager.readFile(filePath2);
                            decryptedText = Cipher.decrypt(reader2, key);
                            FileManager.writeFile(decryptedText, filePath3);

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Сообщение в вашем файле разшифровано и перемещено в файл под названием \"" + filePath3 + "\"" + "\n");
                            } else {
                                System.out.println("We wrote encrypted text right in your file \" " + filePath3 + "\"");
                            }
                        } else {
                            break;
                        }
                        break;

                    case 3:
                        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                            System.out.println("Привет дорогой пользователь! Вы зашли в расшифровку BruteForce (расшифровка без ключа)!");
                            System.out.println();
                            System.out.println("""
                                    Меню
                                    1. Расшифровка текста с помощью BruteForce из консоли
                                    2. Расшифровка текста с помощью BruteForce с файла
                                    9. Вернуться назад""");
                            System.out.println();
                            System.out.print("Выберите нужный вам способ расшифровки: ");
                        } else {
                            System.out.println("Hello dear user! Welcome to BruteForce method (decrypting without key)");
                            System.out.println();
                            System.out.println("""
                                Menu
                                1. Decrypting text using BruteForce from the console
                                2. Decrypting text using BruteForce from a file
                                9. Go back""");
                            System.out.println();
                            System.out.print("Choose the point of the menu you need: ");
                        }
                        int clintChose3;

                        clintChose3 = Validator.choseMenu();

                        if (clintChose3 == 1) {

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Добро пожаловать в расшифровку методом BruteForce из консоли!" +
                                        "\n" + "Пожалуйста убедитесь, что вы вводите текст в 1 строчку, иначе лучше воспользуйтесь файлом!");
                                System.out.println("Введите текст, который вы желаете расшифровать и программа напишет вам все возможные варианты!"
                                        + "\n" + "Вам останется лишь выбрать какая расшифровка из них - верная");
                            } else {
                                System.out.println("Welcome to BruteForce decryption from the console!" + "\n" +
                                        "Please make sure that you enter the text in 1 line, otherwise you'd better use the file!");
                                System.out.println("Enter the text that you want to decipher and the program will write you all the possible options."
                                        + "\n" + "All you have to do is choose which one of them is the correct one!");
                            }
                            Scanner scanner4 = new Scanner(System.in);
                            String bruteForceInput = scanner4.nextLine();
                            BruteForce.decryptByBruteForceConsole(bruteForceInput, Cipher.ALPHABET);

                        } else if (clintChose3 == 2) {
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Добро пожаловать в расшифровку методом BruteForce с файла!" + "\n"
                                        + "Помните, этот способ создан, чтобы расшифровать файл, если у вас нету ключа, по-другому говоря методом подборки!");
                                System.out.print("Введите путь к файлу, который вы хотите расшифровать с помощью метода BruteForce: ");
                            } else {
                                System.out.println("Welcome to BruteForce decryption from a file!" +
                                        "\n" + "Remember, this method is designed to decrypt a file if you don't have a key, in other words, using the compilation method.");
                                System.out.print("Enter the path to the file that you want to decrypt using the BruteForce method: ");
                            }
                            String filePath = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            BruteForce.decryptByBruteForceFiles(filePath, Cipher.ALPHABET);
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Спасибо, что воспользовались нашей программой, чтобы файл отобразился завершите работу программы!");
                            } else {
                                System.out.println("The program has done everything to see the result, end the program! \"" + "0\"");
                            }

                        } else {
                            break;
                        }
                        break;
                    case 4:
                        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                            System.out.println("Добро пожаловать в метод статистического анализа!" + "\n" +
                                    "Данный метод принимает файл с любым русским текстом и на фоне него анализирует зашифрованный вами файл и пытается его расшифровать");
                            System.out.println("Важно помнить, что метод может допустить ошибку, но вероятность этого крайне мала," +
                                    " если метод вам выдал очень странный текст, воспользуйтесь методом BruteForce!");
                            System.out.println();
                            System.out.println("""
                                    Меню
                                    1. Расшифровка текста с помощью статистического анализа
                                    9. Вернуться назад""");
                            System.out.println();
                            System.out.print("Выберите пункт меню: ");
                        } else {
                            System.out.println("Welcome to the statistical analysis method!" + "\n" +
                                    "This method accepts a file with any text written in English and analyzes the encrypted file against it and tries to decrypt it.");
                            System.out.println("It is important to remember that the method may make a mistake, but the probability of this is extremely low," +
                                    " if the method gives you a very strange text, use the BruteForce method!");
                            System.out.println();
                            System.out.println("""
                                Menu
                                1. Decoding (decrypting) text using statistical analysis
                                9. Go back""");
                            System.out.println();
                            System.out.print("Choose the point of the menu you need: ");
                        }

                        int userChoice2;
                        while (true) {
                            try {
                                userChoice2 = Integer.parseInt(scanner1.nextLine());
                            } catch (NumberFormatException exception) {
                                if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                    System.out.print("Вводите число! Повторите попытку ещё раз: ");
                                } else {
                                    System.out.print("Please write numbers!" + "Please try again: ");
                                }
                                continue;
                            }
                            if (userChoice2 == 1 || userChoice2 == 9) {
                                break;
                            } else {
                                if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                    System.out.print("Вы выбрали несуществующий пункт меню!!!" + "\n" + "Повторите попытку: ");
                                } else {
                                    System.out.print("You have selected a non-existent menu item!" + "\n" + "Please try again: ");
                                }
                            }
                        }

                        if (userChoice2 == 1) {
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Введите путь к файлу в котором находится пример русского текста, любого, но чем больше текст, тем больше вероятность," +
                                        " что программа сработает корректно!");
                            } else {
                                System.out.println("Enter the path to the file containing an example of English text, any one, but the larger the text," +
                                        " the more likely it is that the program will work correctly!");
                            }
                            String filePath_1 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу, где находится зашифрованный текст: ");
                            } else {
                                System.out.print("Enter the path to the file where the encrypted text is located: ");
                            }
                            String filePath_2 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.print("Введите путь к файлу, в который нужно будет записать расшифровку, текста: ");
                            } else {
                                System.out.print("Enter the path to the file in which you will need to write the decryption of the text: ");
                            }
                            String filePath_3 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Пожалуйста подождите... Это может занять некоторое время!");
                            } else {
                                System.out.println("Please wait... It may take some time!");
                            }
                            key = StatisticAnalyser.statisticMethod(filePath_1, filePath_2);
                            String readString = FileManager.readFile(filePath_2);
                            String doneString = Cipher.decrypt(readString, key);
                            FileManager.writeFile(doneString, filePath_3);
                            System.out.println();
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Готово!" + " Расшифровка закончена!" + " При ключе = " + key + " текст наиболее похож на русский!");
                                System.out.println("Расшифровку мы записали в файл " + filePath_3);
                            } else {
                                System.out.println("Done!" + " Decrypting is finished!" + " When key = " + key + " the text is most similar to English!");
                                System.out.println("Decrypted text we wrote in the file \"" + filePath_3 + "\"");
                            }
                        } else {
                            break;
                        }
                        break;
                }
            }
        }
        scanner1.close();
    }
}
