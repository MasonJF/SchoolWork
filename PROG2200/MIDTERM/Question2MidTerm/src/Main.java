public class Main {

    public static void main(String[] args) {
        Inventory.setAmountOfPens(10);
        Customer thread1 = new Customer("THREAD 1");
        Customer thread2 = new Customer("THREAD 2");
        Customer thread3 = new Customer("THREAD 3");
        Customer thread4 = new Customer("THREAD 4");
        Customer thread5 = new Customer("THREAD 5");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


        System.out.println("Name: Pens");
        System.out.println("Description: " + Inventory.getDescription());
        System.out.println("Inventory Count: " + Inventory.getAmountOfPens());
    }
}
