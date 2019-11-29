package PDFManager;

public class Main {
    public static void main(String[] args){
        WindowManager myApp = new WindowManager();
        myApp.initFrame("Test", new WelcomeScreen(myApp).panel1);
    }
}
