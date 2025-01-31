import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class BruteForce {
    public static int indexesOfFiles3 = 0;
    public static int index3;
    public static String bruteForce = "";
    public static String bruteForce2 = "";

    public static String decryptByBruteForceFiles(String filepath, List<Character> alphabet) {
        index3 = 1;
        while (index3 < alphabet.size()) {
            try (FileOutputStream fos3 = new FileOutputStream("decryptedFile.txt_" + indexesOfFiles3)) {
                bruteForce = bruteForce.concat(Cipher.decrypt(filepath, index3));
                fos3.write(bruteForce.getBytes());

            } catch (IOException exception) {
                exception.printStackTrace();
            }
            indexesOfFiles3++;
            index3++;
        }

        return bruteForce;
    }

    public static String decryptByBruteForceConsole(String encryptedText, List<Character> alphabet) {
        index3 = 1;
        while (index3 < alphabet.size()) {
            bruteForce2 = bruteForce2.concat(Cipher.decrypt(encryptedText, index3));
            System.out.println("Вот расшифровка при ключе равном " + index3);

            index3++;
        }

        return bruteForce2;
    }
}
