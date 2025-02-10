import java.io.IOException;
import java.util.Scanner;

public class EnglishProgram {
    public static String textForRemakingEnglish;
    public static int key = -1;

    public static void startOfTheProgram() throws IOException {
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

        Scanner scanner1 = new Scanner(System.in);
        int userChoice;
        boolean flag2 = true;
        while (flag2 && Validator.counter != 3) {
            textForRemakingEnglish = "";
            System.out.println();
            System.out.println("""
                    Menu of the program:
                    1. Encrypting text
                    2. Decrypting text
                    3. Brute force
                    4. Statistical analysis
                    0. Exit""");
            System.out.println();
            System.out.print("Choose menu : ");
            userChoice = -1;

            while (userChoice < 0 || userChoice > 4) {
                try {
                    userChoice = Integer.parseInt(scanner1.nextLine());
                } catch (NumberFormatException exception1) {
                    System.out.print("Hey, you must write numbers, be careful!" + "\n" + "Select point of the menu again: ");
                    continue;
                }
                if (userChoice < 0 || userChoice > 4) {
                    System.out.print("You have selected a non-existent point! Please try again: ");
                }

                switch (userChoice) {
                    case 0:
                        System.out.println("Program was closed! Thanks for using it, hope to see you again!");
                        flag2 = false;
                        break;

                    case 1:
                        System.out.println();
                        System.out.println("""
                                Menu
                                1. Encrypting the text entered in the console
                                2. Encrypting text from a file
                                9. Go back""");
                        System.out.println();
                        System.out.print("Choose the point of the menu please: ");
                        int clintChose1;

                        clintChose1 = Validator.choseMenuEnglish();

                        if (clintChose1 == 1) {
                            System.out.print("Please write the text down below which you want to be encrypted: ");
                            textForRemakingEnglish = scanner1.nextLine();
                            System.out.print("Please write a key (the amount by which the letters will be moved)! \uD83D\uDC47" + "\n" +
                                    "Your key must be in range from 1 to 25: ");
                            key = Validator.keySetEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }

                            String encryptedText = Cipher.encrypt(textForRemakingEnglish, key);
                            System.out.println("The result we wrote right below!");
                            System.out.println(encryptedText);

                        } else if (clintChose1 == 2) {
                            String fileRead, fileRead2, reader;
                            String encryptedText;
                            System.out.print("Please write filepath, where the text which you need to encrypt is: ");
                            fileRead = Validator.filePathReadEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }

                            System.out.print("Input key please: ");

                            key = Validator.keySetEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }

                            System.out.print("Write filepath where we will write your encrypted text: ");
                            fileRead2 = Validator.filePathReadEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            reader = FileManager.readFile(fileRead);
                            encryptedText = Cipher.encrypt(reader, key);
                            FileManager.writeFile(encryptedText, fileRead2);
                            System.out.println("We wrote encrypted text right in your file \" " + fileRead2 + "\"");

                        } else {
                            break;
                        }
                        break;

                    case 2:
                        int clintChose2;
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

                        clintChose2 = Validator.choseMenuEnglish();

                        if (clintChose2 == 1) {
                            System.out.print("Write the text that you want to be decrypted: ");
                            textForRemakingEnglish = scanner1.nextLine();
                            System.out.print("Please write a key (the amount by which the letters will be moved)! \uD83D\uDC47" + "\n" +
                                    "Your key must be in range from 1 to 25: ");

                            key = Validator.keySetEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }
                            String decryptedText = Cipher.decrypt(textForRemakingEnglish, key);
                            System.out.println("We wrote decrypted text right below the message");
                            System.out.println(decryptedText);

                        } else if (clintChose2 == 2) {
                            String filePath2, filePath3, reader2;
                            String decryptedText;
                            System.out.print("Please write filepath to the file text from which we will decrypt: ");
                            filePath2 = Validator.filePathReadEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }

                            System.out.print("Input key: ");

                            key = Validator.keySetEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            System.out.print("Please write filepath to the file where we will write decrypted text: ");
                            filePath3 = Validator.filePathReadEnglish();

                            if (Validator.counter == 3) {
                                continue;
                            }
                            reader2 = FileManager.readFile(filePath2);
                            decryptedText = Cipher.decrypt(reader2, key);
                            FileManager.writeFile(decryptedText, filePath3);

                            System.out.println("We wrote encrypted text right in your file \" " + filePath3 + "\"");
                        } else {
                            break;
                        }
                        break;

                    case 3:
                        System.out.println("Hello dear user! Welcome to BruteForce method (decrypting without key)");
                        System.out.println();
                        System.out.println("""
                                Menu
                                1. Decrypting text using BruteForce from the console
                                2. Decrypting text using BruteForce from a file
                                9. Go back""");
                        System.out.println();
                        System.out.print("Choose the point of the menu you need: ");
                        int clintChose3;

                        clintChose3 = Validator.choseMenuEnglish();

                        if (clintChose3 == 1) {
                            System.out.println("Welcome to BruteForce decryption from the console!" + "\n" +
                                    "Please make sure that you enter the text in 1 line, otherwise you'd better use the file!");
                            System.out.println("Enter the text that you want to decipher and the program will write you all the possible options."
                                    + "\n" + "All you have to do is choose which one of them is the correct one!");
                            Scanner scanner4 = new Scanner(System.in);
                            String bruteForceInput = scanner4.nextLine();
                            BruteForce.decryptByBruteForceConsole(bruteForceInput, Cipher.ALPHABET);

                        } else if (clintChose3 == 2) {
                            System.out.println("Welcome to BruteForce decryption from a file!" +
                                    "\n" + "Remember, this method is designed to decrypt a file if you don't have a key, in other words, using the compilation method.");
                            System.out.print("Enter the path to the file that you want to decrypt using the BruteForce method: ");
                            String filePath = Validator.filePathReadEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            BruteForce.decryptByBruteForceFiles(filePath, Cipher.ALPHABET);
                            System.out.println("The program has done everything to see the result, end the program!");

                        } else {
                            break;
                        }
                        break;
                    case 4:
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

                        int userChoice2;
                        while (true) {
                            try {
                                userChoice2 = Integer.parseInt(scanner1.nextLine());
                            } catch (NumberFormatException exception) {
                                System.out.print("Please write numbers!" + "Please try again: ");
                                continue;
                            }
                            if (userChoice2 == 1 || userChoice2 == 9) {
                                break;
                            } else {
                                System.out.print("You have selected a non-existent menu item!" + "\n" + "Please try again: ");
                            }
                        }

                        if (userChoice2 == 1) {
                            System.out.println("Enter the path to the file containing an example of English text, any one, but the larger the text," +
                                    " the more likely it is that the program will work correctly!");
                            String filePath_1 = Validator.filePathReadEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            System.out.print("Enter the path to the file where the encrypted text is located: ");
                            String filePath_2 = Validator.filePathReadEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }
                            System.out.print("Enter the path to the file in which you will need to write the decryption of the text: ");
                            String filePath_3 = Validator.filePathReadEnglish();
                            if (Validator.counter == 3) {
                                continue;
                            }

                            System.out.println("Please wait... It may take some time!");
                            key = StatisticAnalyser.statisticMethod(filePath_1, filePath_2);
                            String readString = FileManager.readFile(filePath_2);
                            String doneString = Cipher.decrypt(readString, key);
                            FileManager.writeFile(doneString, filePath_3);
                            System.out.println();
                            System.out.println("Done!" + " Decrypting is finished!" + " When key = " + key + " the text is most similar to English!");
                            System.out.println("Decrypted text we wrote in the file \"" + filePath_3 + "\"");
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
