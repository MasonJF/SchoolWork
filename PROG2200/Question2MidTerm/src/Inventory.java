class Inventory {


    private static int amountOfPens;
    private static boolean complete = false;

    //    private static boolean currentlySelling = false;


    synchronized static void sellingSwitch() { // This needs to be Sync'd
        amountOfPens--;
        System.out.println(amountOfPens);

    }

    synchronized static boolean outOfPens() { // This needs to be Sync'd
                    System.out.println("SOLD OUT!!");
        return amountOfPens <= 0;
    }

    synchronized static void operationComplete() { // This needs to be Sync'd
        complete = true;
    }

    static int getAmountOfPens() {
        return amountOfPens;
    }

    static void setAmountOfPens(int amountOfPens) {
        Inventory.amountOfPens = amountOfPens;
    }


    static String getDescription() {
        return "Hi Russ, wanna buy a pen?!";
    }

    static boolean isComplete() {
        return complete;
    }
}

