public class MainApp {
    public static void main(String[] args) {
        Cipher.setLanguage();
        try {
            MainCode.programStart();
        } catch (Exception exception) {
            System.out.println("The program was completed! If it was completed by mistake, start it again!");
        }
    }
}