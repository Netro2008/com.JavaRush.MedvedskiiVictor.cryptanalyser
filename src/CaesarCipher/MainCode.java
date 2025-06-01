package CaesarCipher;

import MainClasses.Setup;
import MainClasses.TypicalPhrases;

import java.io.IOException;
import java.util.Scanner;

public class MainCode {
    public static int key = -1;
    public static String textForRemakingRussian;
    public static boolean flag2 = true;

    public static void programStart () throws IOException {
        TypicalPhrases.helloMethod(Setup.wordForSelectingCipher);

        Scanner scanner1 = new Scanner(System.in);
        int userChoice;
        while (flag2 && Validator.counter != 3) {
            textForRemakingRussian = "";
            CaesarMainPhrases.programMenu();
            userChoice = -1;

            while (userChoice < 0 || userChoice > 4) {
                try {
                    userChoice = Integer.parseInt(scanner1.nextLine());
                } catch (NumberFormatException exception1) {
                    CaesarMainPhrases.mustWriteOnlyNumber();
                    continue;
                }
                if (userChoice < 0 || userChoice > 4) {
                    CaesarMainPhrases.nonExistMenuPoint();
                }
                switch (userChoice) {
                    case 0:
                        CaesarMainPhrases.endedProgram();
                        flag2 = false;
                        break;

                    case 1:
                        CaesarMainPhrases.encryptingMenu();
                        int clintChose1;

                        clintChose1 = Validator.choseMenu();

                        if (clintChose1 == 1) {
                            CaesarMainPhrases.textInConsole();
                            textForRemakingRussian = scanner1.nextLine();
                            CaesarMainPhrases.textInConsole();

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            String encryptedText = Cipher.encrypt(textForRemakingRussian, key);
                            CaesarMainPhrases.wroteResultOfMethodWorkInConsole();
                            System.out.println(encryptedText);

                        } else if (clintChose1 == 2) {
                            String fileRead, fileRead2, reader;
                            String encryptedText;
                            CaesarMainPhrases.selectFilePath();
                            fileRead = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            CaesarMainPhrases.selectingKey();

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            CaesarMainPhrases.selectFilePath();
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
                                System.out.println("We have written the encrypted text right into your file \"" + fileRead2 + "\"");
                            }

                        } else {
                            break;
                        }
                        break;

                    case 2:
                        int clintChose2;
                        CaesarMainPhrases.decryptingMenu();

                        clintChose2 = Validator.choseMenu();

                        if (clintChose2 == 1) {
                            CaesarMainPhrases.textInConsole();

                            textForRemakingRussian = scanner1.nextLine();
                            CaesarMainPhrases.selectingKey();

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            String decryptedText = Cipher.decrypt(textForRemakingRussian, key);

                            CaesarMainPhrases.wroteResultOfMethodWorkInConsole();
                            System.out.println(decryptedText);

                        } else if (clintChose2 == 2) {
                            String filePath2, filePath3, reader2;
                            String decryptedText;

                            CaesarMainPhrases.selectFilePath();
                            filePath2 = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            CaesarMainPhrases.selectingKey();

                            key = Validator.keySet();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            CaesarMainPhrases.selectFilePath();
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
                                System.out.println("The message is encrypted right into your file \"" + filePath3 + "\"");
                            }
                        } else {
                            break;
                        }
                        break;

                    case 3:
                        CaesarMainPhrases.bruteForceMenu();
                        int clintChose3;

                        clintChose3 = Validator.choseMenu();

                        if (clintChose3 == 1) {
                            CaesarMainPhrases.bruteForceMethodFromConsole();

                            Scanner scanner4 = new Scanner(System.in);
                            String bruteForceInput = scanner4.nextLine();
                            BruteForce.decryptByBruteForceConsole(bruteForceInput, Cipher.ALPHABET);

                        } else if (clintChose3 == 2) {
                            CaesarMainPhrases.bruteForceMethodFromFile();
                            String filePath = Validator.filePathRead();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            BruteForce.decryptByBruteForceFiles(filePath, Cipher.ALPHABET);
                            if (Cipher.ALPHABET.equals(Cipher.RUSSIAN_ALPHABET)) {
                                System.out.println("Спасибо, что воспользовались нашей программой, чтобы файл отобразился завершите работу программы!");
                            } else {
                                System.out.println("Thanks for using out program, please complete the program to see the file! \"" + "0\"");
                            }

                        } else {
                            break;
                        }
                        break;
                    case 4:
                        CaesarMainPhrases.statisticalAnalysisMenu();

                        int userChoice2;
                        while (true) {
                            try {
                                userChoice2 = Integer.parseInt(scanner1.nextLine());
                            } catch (NumberFormatException exception) {
                                CaesarMainPhrases.mustWriteOnlyNumber();
                                continue;
                            }
                            if (userChoice2 == 1 || userChoice2 == 9) {
                                break;
                            } else {
                                CaesarMainPhrases.nonExistMenuPoint();
                            }
                        }

                        if (userChoice2 == 1) {
                            CaesarMainPhrases.filePathForTextForStatisticAnalysis();
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
                                System.out.print("Enter the path to the file into which you need to write the decryption of the text: ");
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
                                System.out.println("Done!" + " Decrypting is finished!" + " If the key equals " + key + " the text is the most similar to English!");
                                System.out.println("The message is decrypted right into your file \"" + filePath_3 + "\"");
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
