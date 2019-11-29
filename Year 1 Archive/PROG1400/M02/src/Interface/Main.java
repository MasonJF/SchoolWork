package Interface;

public class Main {
    public static void main(String[] args) {
        integration Car = new integration();

        System.out.println("Brake percentage: " + Car.setbrakes);
        System.out.println("Fuel Pedal Percentage: " + Car.setfuelPedal);
        System.out.println("Steering wheel degree: " + Car.swheel);

        Car.applyBrakes(5.9);
        Car.applyfuelPedal(78.4);
        Car.steeringWheel(-4);

        System.out.println("Brake percentage: " + Car.setbrakes);
        System.out.println("Fuel Pedal Percentage: " + Car.setfuelPedal);
        System.out.println("Steering wheel degree: " + Car.swheel);
    }

}
