package Interface;

public class integration implements ivehicle {
    public double setfuelPedal = 0.0;
    public double setbrakes = 0.0;
    public int swheel = 0;

    @Override
    public void applyfuelPedal(double fuelPedal) {
        setfuelPedal = setfuelPedal + fuelPedal;
    }

    @Override
    public void applyBrakes(double decrement) {
        setbrakes = setbrakes - decrement;
    }

    @Override
    public void steeringWheel(int wheelDegree) {
            swheel = swheel + wheelDegree;
    }
}
