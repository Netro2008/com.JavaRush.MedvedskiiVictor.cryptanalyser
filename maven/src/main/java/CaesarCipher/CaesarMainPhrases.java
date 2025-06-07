package CaesarCipher;

public class CaesarMainPhrases {
    public static void programMenu() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println();
            System.out.println("""
                        Меню программы (полный функционал)
                        1. Шифрование
                        2. Расшифровка с ключом
                        3. BruteForce
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
                    3. BruteForce
                    4. Statistical analysis
                    0. Exit""");
            System.out.println();
            System.out.print("Choose the point of the menu please: ");
        }
    }

    public static void mustWriteOnlyNumber() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.print("Вы должны вводить число!!!" + "\n" + "Выберите пункт ещё раз: ");
        } else {
            System.out.print("Hey, you must write a number, be careful!" + "\n" + "Select the point of the menu again: ");
        }
    }

    public static void nonExistMenuPoint() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.print("Вы выбрали несуществующий пункт меню!" + " Повторите попытку: ");
        } else {
            System.out.print("You have selected a non-existent point of the menu! Please try again: ");
        }
    }

    public static void endedProgram() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Вы завершили работу программы!");
        } else {
            System.out.println("The program was completed! Thanks for using it, hope to see you again!");
        }
    }

    public static void encryptingMenu() {
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
                                1. Encrypting a text entered in the console
                                2. Encrypting a text from the file
                                9. Go back""");
            System.out.println();
            System.out.print("Choose the point of the menu please: ");
        }
    }

    public static void decryptingMenu() {
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
            System.out.println("Please make sure that you have the key to decrypt the text or go back to the menu \"9\" and run main.CaesarCipher.BruteForce or Statistical analysis!");
            System.out.print("Choose the point of the menu: ");
        }
    }

    public static void bruteForceMenu() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Привет дорогой пользователь! Вы зашли в расшифровку main.CaesarCipher.BruteForce (расшифровка без ключа)!");
            System.out.println();
            System.out.println("""
                                    Меню
                                    1. Расшифровка текста с помощью main.CaesarCipher.BruteForce из консоли
                                    2. Расшифровка текста с помощью main.CaesarCipher.BruteForce с файла
                                    9. Вернуться назад""");
            System.out.println();
            System.out.print("Выберите нужный вам способ расшифровки: ");
        } else {
            System.out.println("Hello dear user! Welcome to main.CaesarCipher.BruteForce method (decrypting without key)");
            System.out.println();
            System.out.println("""
                                Menu
                                1. Decrypting the text using main.CaesarCipher.BruteForce from the console
                                2. Decrypting the text using main.CaesarCipher.BruteForce from the file
                                9. Go back""");
            System.out.println();
            System.out.print("Choose the point of the menu you need: ");
        }
    }

    public static void bruteForceMethodFromConsole() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Добро пожаловать в расшифровку методом BruteForce из консоли!" +
                    "\n" + "Пожалуйста убедитесь, что вы вводите текст в 1 строчку, иначе лучше воспользуйтесь файлом!");
            System.out.println("Введите текст, который вы желаете расшифровать и программа напишет вам все возможные варианты!"
                    + "\n" + "Вам останется лишь выбрать какая расшифровка из них - верная");
        } else {
            System.out.println("Welcome to BruteForce decryption from the console!" + "\n" +
                    "Please make sure that you enter the text in one line, otherwise it will be better to use the file!");
            System.out.println("Enter the text that you want to decipher and the program will give you all the possible options."
                    + "\n" + "All you have to do is to choose which one is the correct one!");
        }
    }

    public static void bruteForceMethodFromFile() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Добро пожаловать в расшифровку методом BruteForce с файла!" + "\n"
                    + "Помните, этот способ создан, чтобы расшифровать файл, если у вас нету ключа, по-другому говоря методом подборки!");
            System.out.print("Введите путь к файлу, который вы хотите расшифровать с помощью метода main.CaesarCipher.BruteForce: ");
        } else {
            System.out.println("Welcome to BruteForce decryption from a file!" +
                    "\n" + "Remember, this method is designed to decrypt a file if you don't have a key, in other words, using the compilation method.");
            System.out.print("Enter the path to the file that you want to be decrypted using the main.CaesarCipher.BruteForce method: ");
        }
    }

    public static void statisticalAnalysisMenu() {
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
                    "This method accepts any file in English and analyzes the encrypted file and tries to decrypt it.");
            System.out.println("It is important to remember that the method can make a mistake, but the probability of this is extremely low," +
                    " if you get a very strange text as a result, use the BruteForce method instead!");
            System.out.println();
            System.out.println("""
                    Menu
                    1. Decoding (decrypting) text using statistical analysis
                    9. Go back""");
            System.out.println();
            System.out.print("Choose the point of the menu you need: ");
        }
    }

    public static void textInConsole() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.print("Введите текст в консоль для обработки: " + "\n");
        } else {
            System.out.print("Please write the text down below which you want to be encrypted or decrypted: ");
        }
    }

    public static void selectingKey() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.print("""
                                        Введите ключ (количество символов на которое будет осуществляться сдвиг)!
                                        Убидитесь что прочитали текст ниже \uD83D\uDC47
                                        """);
            System.out.print("Дорогой пользователь, помни, что значение твоего ключа может быть строго от 1 до 31: ");
        } else {
            System.out.print("Please write the key (the amount by which the letters will be moved)! \uD83D\uDC47" + "\n" +
                    "Your key must be in range from 1 to 25: ");
        }
    }

    public static void wroteResultOfMethodWorkInConsole() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Результат мы вывели на экран строкой ниже!");
        } else {
            System.out.println("We have written the result right below the message!");
        }
    }

    public static void selectFilePath() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.print("Введите путь к файлу, в котором находится текст, который необходимо зашифровать: ");
        } else {
            System.out.print("Please write the filepath, where the text which you need to encrypt is: ");
        }
    }

    public static void filePathForTextForStatisticAnalysis() {
        if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
            System.out.println("Введите путь к файлу в котором находится пример русского текста, любого, но чем больше текст, тем больше вероятность," +
                    " что программа сработает корректно!");
        } else {
            System.out.println("Enter the path to the file containing an example of any English text!" + "\n"
                    + "Keep in mind, the larger the text, the better chances to decrypt it correctly");
        }
    }
}