package inheritance;

/**
 * Mainline instance, runs initiates classes and prints variables.
 */

public class Main {
    public static void main(String[] args) {
        car c1 = new car(50, "Green", 5, "JVC");
        airplane a1 = new airplane(575, "Aqua", 65000);
        vehicle v1 = new vehicle(90, "Blue");

        System.out.println(c1.printSpeed());
        System.out.println("Car Number of Passengers = " + c1.getNumOfPass());
        System.out.println("Car Type of Radio = " + c1.getTypeOfRadio());
        System.out.println("Car Colour = " + c1.getColor());

        System.out.println("Vehicle Color = " + v1.getColor());
        System.out.println("Vehicle TopSpeed = " + v1.getTopSpeed());

        System.out.println("Airplane Color = " + a1.getColor());
        System.out.println("Airplane TopSpeed = " + a1.getTopSpeed());
        System.out.println("Airplane MaxHeight = " + a1.getMaxHeight());

    }
}
