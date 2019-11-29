public class Customer extends Thread{

    private int amountPurchased = 0;

    private String name;


    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void run() {
            while(!Inventory.outOfPens()) {
                mySleep(30);
                sellPen();
                mySleep(11);
            }
        Inventory.operationComplete();
            if(Inventory.isComplete()) {
                lastPrint(this);
            }
        }

    public synchronized void sellPen(){
        this.amountPurchased++;
        mySleep(79);
        Inventory.sellingSwitch();
        mySleep(27);
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
