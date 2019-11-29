public class Customer extends Thread{

    private int amountPurchased = 0;

    private String name;


    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            while(!Inventory.outOfPens()) {
                sellPen();
            }
        Inventory.operationComplete();
            if(Inventory.isComplete()) {
                lastPrint(this);
            }
        }

    public void sellPen(){ // This needs to be Sync'd
        this.amountPurchased++;
        Inventory.sellingSwitch();
//        mySleep(20);
        System.out.println(this.name + " buys item " + (Inventory.getAmountOfPens() + 1));
    }

    public static void mySleep(int d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public synchronized void lastPrint(Customer customer) {
        System.out.println("Amount Purchased by: " + this.name + ": " + this.amountPurchased);
    }
}
