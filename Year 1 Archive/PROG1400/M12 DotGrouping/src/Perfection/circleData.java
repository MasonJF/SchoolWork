package Perfection;

import java.awt.*;
import java.util.ArrayList;

class circleData{

    //Thread that draws the circle

    int x;
    int y;
    Color colour;
    public static int totalCircles = 0;
    public boolean isWriting = false;
    public int id;
    public ArrayList<circleData> neighbourArray = new ArrayList<>();
    public static int writeCount = 0;
    circleData(int x, int y, Color colour) {
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.id = totalCircles;
        circleData.totalCircles += 1;
    }
//    private Color vari = Color.BLUE;

    void Paint(Graphics2D g2d) {
        g2d.setColor(this.colour);
        int shapeSize = 10;
        String data = "";
        boolean hasData = false;
        g2d.fillOval(x-shapeSize/2, y-shapeSize/2, shapeSize, shapeSize);
        for (circleData other:neighbourArray) {
            if(other.colour.equals(this.colour)) {

                hasData = true;
                data = data + this.x + ";" + this.y + ";" + this.colour.hashCode() + "\n";
                data = data + other.x + ";" + other.y + ";" + other.colour.hashCode() + "\n";
//                FileIO.fileWrite(data, "groups_" + this.id + ".txt");
                g2d.drawLine(this.x, this.y, other.x, other.y);

            }
        }
        if(hasData && isWriting) {
            writeCount = writeCount + 1;
            FileIO.fileWrite(data, "groups_" + writeCount + ".txt");

            this.isWriting = false;
        }
    }
}