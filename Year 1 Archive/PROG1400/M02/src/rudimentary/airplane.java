package rudimentary;


public class airplane {
    private int maxHeight;
    private String color;
    private int topSpeed;

    public airplane(){
        this.maxHeight = 0;
        this.color = "";
        this.topSpeed = 0;
    }

    public airplane(int topSpeed, String color, int maxHeight) {
        this.maxHeight = maxHeight;
        this.topSpeed = topSpeed;
        this.color = color;
    }



    public void setMaxHeight(int newValue) {
        maxHeight = newValue;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
    public void setColor(String newValue) {
        color = newValue;
    }

    public String getColor() {
        return color;
    }
    public void setTopSpeed(int newValue) {
        topSpeed = newValue;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

}
