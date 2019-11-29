public class Customer extends Thread {

    private int amountPurchased = 0;

    private String name;

    private Observer reggie;

    Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while(!Inventory.outOfPens()) {
                sellPen();
            }
            Inventory.operationComplete();
            if(Inventory.isComplete()) {
                lastPrint();
                if(reggie != null) {
                    reggie.event(name, amountPurchased);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.setPriority("high");
            logging(e);
        }
    }

    private synchronized void sellPen(){ // This needs to be Sync'd
        this.amountPurchased++;
        Inventory.sellingSwitch();
//        mySleep(20);
        System.out.println(this.name + " buys item " + (Inventory.getAmountOfPens() + 1));
    }

    private synchronized void lastPrint() {
        System.out.println("Amount Purchased by: " + this.name + ": " + this.amountPurchased);
//        this.logging(null);
    }

    private void logging(Exception e) {
        if(!Logger.isPerformanceMode()) {
            if(Logger.getPriority().equals("high")){
                Logger log = Logger.getInstance();
                if(e == null)
                    e = new Exception("Exception in Logging was Null");
                log.logError(e);
            } else {
                Logger log = Logger.getInstance();
                log.logStuff(this.name, this.amountPurchased);
            }
        }
    }

    public void setReggie(Observer reggie) {
        this.reggie = reggie;
    }

}
