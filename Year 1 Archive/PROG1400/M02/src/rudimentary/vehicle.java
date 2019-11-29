package rudimentary;

public class vehicle{
    int topSpeed;
    private String color;

    public vehicle(){
        this.topSpeed = 0;
        this.color = "";
    }

    public vehicle(int topSpeed, String color){
        this.topSpeed = topSpeed;
        this.color = color;

    }
    void setTopSpeed(int newValue) {
        topSpeed = newValue;
    }
    void setColor(String newValue) {
        color = newValue;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    String getColor() {
        return color;
    }
}
