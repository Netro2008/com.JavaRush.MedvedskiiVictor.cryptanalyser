import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BruteForce {
    public static int indexesOfFiles;
    public static String bruteForce = "";
    public static String bruteForce2 = "";

    public static void decryptByBruteForceFiles(String filepath, List<Character> alphabet) {
        indexesOfFiles = 1;
        String bruteForcing;

        while (indexesOfFiles < alphabet.size() - 1) {
            try (FileOutputStream fos3 = new FileOutputStream("decryptedFile.txt_" + indexesOfFiles)) {
                bruteForcing = FileManager.readFile(filepath);
                bruteForce = Cipher.decrypt(bruteForcing, indexesOfFiles);
                fos3.write(bruteForce.getBytes());
            } catch (IOException e) {
                if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                    System.out.print("Something went wrong... Try again please: ");
                } else {
                    System.out.println("Произошла ошибка... Попробуйте снова: ");
                }
            }
            indexesOfFiles++;
        }
    }

    public static void decryptByBruteForceConsole(String encryptedText, List<Character> alphabet) {
        indexesOfFiles = 1;
        while (indexesOfFiles < alphabet.size() - 1) {
            bruteForce2 = Cipher.decrypt(encryptedText, indexesOfFiles);
            if (Cipher.ALPHABET.equals(Cipher.ENGLISH_ALPHABET)) {
                System.out.println("Here is the decryption with the key " + indexesOfFiles);
            } else {
                System.out.println("Вот расшифровка при ключе равном " + indexesOfFiles);
            }
            System.out.println(bruteForce2);
            System.out.println();

            indexesOfFiles++;
        }
    }
}
