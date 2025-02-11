public class MainApp {
    public static void main(String[] args) {
        Cipher.setLanguage();
        try {
            MainCode.programStart();
        } catch (Exception exception) {
            System.out.println("The program was closed! If it was closed by mistake start it again!");
        }
    }
}