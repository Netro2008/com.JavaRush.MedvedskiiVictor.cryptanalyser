import java.io.*;

public class FileManager {
    public static String readText = "";

    public static String readFile(String filePath) throws IOException {
        readText = "";
        FileReader reader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(reader);
        while (bufferedReader.ready()) {
            readText = readText.concat(String.valueOf(bufferedReader.readLine())) + "\n";
        }
        return readText;
    }

    public static void writeFile(String content, String filePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filePath);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
             bufferedWriter.write(content);
        }
    }
}
