package rudimentary;

public class Main {
    public static void main(String[] args) {
        car c1 = new car();
        airplane a1 = new airplane();
        vehicle v1 = new vehicle();
//
        System.out.print("Car color = ");
        System.out.println(c1.getColor());
        System.out.print("Car topspeed = ");
        System.out.println(c1.getTopSpeed());
        System.out.print("Car Number of Passengers = ");
        System.out.println(c1.getNumOfPass());
        System.out.print("Car Type of Radio = ");
        System.out.println(c1.getTypeOfRadio());


        System.out.print("Vehicle Color = ");
        System.out.println(v1.getColor());
        System.out.print("Vehicle TopSpeed = ");
        System.out.println(v1.getTopSpeed());

        System.out.print("Airplane Color = ");
        System.out.println(a1.getColor());
        System.out.print("Vehicle TopSpeed = ");
        System.out.println(a1.getTopSpeed());
        System.out.print("Airplane MaxHeight = ");
        System.out.println(a1.getMaxHeight());
    }
}
