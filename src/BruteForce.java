import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BruteForce {
    public static int indexesOfFiles3;
    public static int index3;
    public static String bruteForce = "";
    public static String bruteForce2 = "";

    public static void decryptByBruteForceFiles(String filepath, List<Character> alphabet) {
        index3 = 1;
        indexesOfFiles3 = 1;
        String bruteForcing;

        while (index3 < alphabet.size()) {
            try (FileOutputStream fos3 = new FileOutputStream("decryptedFile.txt_" + indexesOfFiles3)) {
                bruteForcing = FileManager.readFile(filepath);
                bruteForce = Cipher.decrypt(bruteForcing, index3);
                fos3.write(bruteForce.getBytes());
            } catch (IOException e) {
                System.out.println("Произошла ошибка... Попробуйте снова!");
            }
            indexesOfFiles3++;
            index3++;
        }
    }

    public static void decryptByBruteForceConsole(String encryptedText, List<Character> alphabet) {
        index3 = 1;
        while (index3 < alphabet.size() - 1) {
            bruteForce2 = Cipher.decrypt(encryptedText, index3);
            System.out.println("Вот расшифровка при ключе равном " + index3);
            System.out.println(bruteForce2);
            System.out.println();

            index3++;
        }
    }
}
