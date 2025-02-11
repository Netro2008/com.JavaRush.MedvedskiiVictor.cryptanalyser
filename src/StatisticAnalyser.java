import java.io.IOException;

public class StatisticAnalyser {
    public static int statisticMethod (String filePath, String filePath2) throws IOException {
        int counter = 0, counter_2 = -1, key_2 = 0, keyCounter = 1, k = 0, m = 0, counter_3 = 0;
        String exampleString = FileManager.readFile(filePath);
        String notDoneString = FileManager.readFile(filePath2);
        String [] strings_1, strings_2;
        strings_1 = exampleString.split(" ");
        strings_2 = notDoneString.split(" ");
        String decrypting;

        while (keyCounter < Cipher.ALPHABET.size() - 1) {
            decrypting = Cipher.decrypt(strings_2[k], keyCounter);
            if (strings_1[m].equalsIgnoreCase(decrypting)) {
                counter++;
            }
            k++;
            counter_3++;
            if (strings_2.length == counter_3 && m != strings_1.length - 1) {
                counter_3 = 0;
                k = 0;
                m++;
            }
            if (m == strings_1.length - 1) {
                if (counter > counter_2) {
                    counter_2 = counter;
                    key_2 = keyCounter;
                }

                m = 0;
                k = 0;
                counter_3 = 0;
                counter = 0;
                keyCounter++;
            }
        }
        return key_2;
    }
}
