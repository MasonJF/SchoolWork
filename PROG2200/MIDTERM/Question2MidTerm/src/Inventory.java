public class Inventory {



    private static int amountOfPens;
    private static boolean complete = false;

    private static String description = "Hi Russ, wanna buy a pen?!";



    public synchronized static void sellingSwitch() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amountOfPens--;

    }

    public synchronized static boolean outOfPens() {
        if (amountOfPens <= 0) {
            return true;
        }return false;
    }

    public static synchronized void operationComplete(){
      complete = true;
    }

    public static int getAmountOfPens() {
        return amountOfPens;
    }
    public static void setAmountOfPens(int amountOfPens) {
        Inventory.amountOfPens = amountOfPens;
    }


    public static String getDescription() {
        return description;
    }

    public static boolean isComplete() {
        return complete;
    }
}

