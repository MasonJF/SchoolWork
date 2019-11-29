package rudimentary;

public class car {
    private int numOfPass;
    private int topSpeed;
    private String color;
    private String typeOfRadio;

    public car() {
        this.topSpeed = 0;
        this.color = "";
        this.numOfPass = 0;
        this.typeOfRadio = "";
    }

    public car(int topSpeed, String color, int numOfPass, String typeOfRadio) {
        this.topSpeed = topSpeed;
        this.color = color;
        this.numOfPass = numOfPass;
        this.typeOfRadio = typeOfRadio;
    }

    void setNumOfPass(int numOfPass) {
        this.numOfPass = numOfPass;
    }

    void setTypeOfRadio(String typeOfRadio) {
        this.typeOfRadio = typeOfRadio;
    }
    void setColor(String color) {
        this.color = color;
    }

    void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }
    public int getTopSpeed() {
        return topSpeed;
    }
    String getColor() {
        return color;
    }


    int getNumOfPass() {
        return numOfPass;
    }

    String getTypeOfRadio() {
        return typeOfRadio;
    }
}

