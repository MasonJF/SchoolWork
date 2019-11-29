package inheritance;

/**
 * main vehicle class which everything inherits from.
 */

public class vehicle {
    int topSpeed;
    private String color;

//    public ivehicle(){
//        this.topSpeed = 0;
//        this.color = "";
//    }

    /**
     *  instances top speed and color
     * @param topSpeed
     * @param color
     */
    public vehicle(int topSpeed, String color){
        this.topSpeed = topSpeed;
        this.color = color;

    }

    /**
     * sets top speed variable once instanced
     * @param newValue
     */
    void setTopSpeed(int newValue) {
        topSpeed = newValue;
    }

    /**
     * Sets the color once instanced.
     * @param newValue
     */
    public void setColor(String newValue) {
        color = newValue;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public String getColor() {
        return color;
    }
}
