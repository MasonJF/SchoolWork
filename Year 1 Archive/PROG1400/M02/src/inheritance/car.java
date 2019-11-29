package inheritance;

/**
 * Car extends from vehicle, adds type of radio and number of passengers
 * setters and getters here
 */



public class car extends vehicle {
    private int numOfPass;
    private String typeOfRadio;

//    public car() {
//        this.numOfPass = 0;
//        this.typeOfRadio = "";
//    }

    /**
     * Instances all variables for car
     * @param topSpeed
     * @param color
     * @param numOfPass
     * @param typeOfRadio
     */
    public car(int topSpeed, String color, int numOfPass, String typeOfRadio) {
        super(topSpeed, color);
        this.numOfPass = numOfPass;
        this.typeOfRadio = typeOfRadio;
    }

    String printSpeed(){
        return "Car top speed = " + this.topSpeed;
    }

    /**
     * sets variable for number of passengers
     * @param numOfPass
     */
    void setNumOfPass(int numOfPass) {
        this.numOfPass = numOfPass;
    }

    /**
     * sets string for the type of radio.
     * @param typeOfRadio
     */
    void setTypeOfRadio(String typeOfRadio) {
        this.typeOfRadio = typeOfRadio;
    }

    public int getNumOfPass() {
        return numOfPass;
    }

    public String getTypeOfRadio() {
        return typeOfRadio;
    }
}

