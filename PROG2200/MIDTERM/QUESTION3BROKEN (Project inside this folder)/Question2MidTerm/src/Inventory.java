public class Inventory {



    private static int amountOfPens;
    private static boolean complete = false;

    private static String description = "Hi Russ, wanna buy a pen?!";
//    private static boolean currentlySelling = false;


    public static void sellingSwitch() { // This needs to be Sync'd

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        amountOfPens--;

    }

    public static boolean outOfPens() { // This needs to be Sync'd
        if (amountOfPens <= 0) {
//            System.out.println("SOLD OUT!!");
            return true;
        }return false;
    }

    public static void operationComplete(){ // This needs to be Sync'd
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

