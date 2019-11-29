package inheritance;

/**
 * Air plane class extending from vehicle setters and getters for maxHeight here
 */

public class airplane extends vehicle {
    private int maxHeight;

//    public airplane(){
//        this.maxHeight = 0;
//    }

    /**
     * Sets the variables for the airplane.
     * @param topSpeed
     * @param color
     * @param maxHeight
     */
    public airplane(int topSpeed, String color, int maxHeight){
        super(topSpeed, color);
        this.maxHeight = maxHeight;
    }

    /**
     * Sets the max height variable
     * @param newValue
     */
    public void setMaxHeight(int newValue) {
        maxHeight = newValue;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}
