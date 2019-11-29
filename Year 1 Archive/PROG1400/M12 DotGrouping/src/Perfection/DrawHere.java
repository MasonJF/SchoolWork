package Perfection;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DrawHere extends JPanel implements ActionListener {

//    public static Graphics2D g2d;

    private HashMap<Integer, circleData> dotCollection = new HashMap<>();
    //        int[][] intArray = new int[2][2];
    int[][] xAndY = FileIO.parseCoords(GuiSystem.newPath);
//    private ArrayList<circleData> dataList = new ArrayList<>();

//    private circleData dot;

    DrawHere(GuiSystem guiSys) {
//        Random rand = new Random();
        Random rand = new Random();

        for (int[] ints : xAndY) {

            circleData dot = new circleData(ints[0], ints[1], new Color(ints[2]));
//           dataList.add(dot);
            dotCollection.put(dotCollection.size(), dot);
//            dot.start();

        }
        int threshold = guiSys.getThresholdSpinner();
        groupCheck(threshold);
        // Set up cat
        this.setFocusable(true);
        this.requestFocusInWindow();

    }

    public void groupCheck(int threshold){
        String data = "";
        int groupCount = 0;
        for (circleData item:dotCollection.values()) {
            item.neighbourArray = new ArrayList<>();
            for (circleData other : dotCollection.values()) {
//                if (item.colour.hashCode() == other.colour.hashCode()){
                    if (item != other) {
                        if (rangeCheck(item.x, other.x, threshold, -threshold)
                                && rangeCheck(item.y, other.y, threshold, -threshold)) {
                            item.neighbourArray.add(other);
                            data = data + other.x + ";" + other.y + ";" + other.colour.hashCode() + "\n";
    //                        FileIO.fileWrite(data, "groups_"+groupCount+".txt");
                            }
//                        FileIO.fileWrite(data, "groups_"+groupCount+".txt");
//                        }

                    }
                    if (item == other) {
                        item.neighbourArray.remove(item);
                    }
                }
            item.isWriting = true;
//            groupCount += 1;
            }
        System.out.println(data);
        System.out.println(groupCount);
        }

//    public void groupColour(){
//        String data = "";
//        int groupCount = 0;
//        for (circleData item:dotCollection.values()) {
//            item.neighbourArray = new ArrayList<>();
//            for (circleData other : dotCollection.values()) {
//                if (item.colour.hashCode() == other.colour.hashCode()){
//                    if (item != other) {
//                            item.neighbourArray.add(other);
//                            item.neighbourArray.remove(item);
//                            data = data + other.x + ";" + other.y + ";" + other.colour.hashCode() + "\n";
//                            //                        FileIO.fileWrite(data, "groups_"+groupCount+".txt");
//                        }
////                        FileIO.fileWrite(data, "groups_"+groupCount+".txt");
//                    }
//
//                }
//            }
//            groupCount += 1;
//        }
//        System.out.println(data);
//        System.out.println(groupCount);
//    }
//        System.out.println(xAndY.get(0)[0]);
//        for(int i = 0; i < dotCollection.size(); i++){
//            temp = new circleData(xAndY.get(i)[0], xAndY.get(i)[1]);
//            System.out.println(temp.x);
//            System.out.println(xAndY.get(i)[0]);
//            for (int j = 0; j < xAndY.size(); j++){
//                if(i != j){
//                    if(rangeCheck(temp.x, xAndY.get(j)[0], 50, -50) && rangeCheck(temp.y, xAndY.get(j)[1], 50, -50)){
//                        System.out.println("group; " + temp.x + ", " + xAndY.get(j)[0]);
//
//                    }else{
//                        System.out.println("Not group");
//                    }
//                }
//            }
//        }
//    }

    public static boolean rangeCheck(int x, int y, int max, int min) {
        if (x - y < max) {
            return x - y > min;
        }
        return false;
    }




    public void paintComponent(Graphics g) {

        // Setup and clear the buffer
        BufferedImage bufferedImage = new BufferedImage(this.getWidth(),
                this.getHeight(), BufferedImage.TYPE_INT_BGR);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setColor(getBackground());
        g2d.fillRect(0,  0,  this.getWidth(),  this.getHeight());  //fill with background color
        g2d.scale(1, -1);
        g2d.translate(0, -getHeight());
        // Draw on the buffer
        for (circleData i: dotCollection.values()){
            i.Paint(g2d);
        }
//        g1.Paint(g2d);
//        g2.Paint(g2d);
//        g3.Paint(g2d);
        // Set the buffer to be visible
        Graphics2D g2dComponent = (Graphics2D) g;
        g2dComponent.drawImage(bufferedImage, null, 0, 0);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();


        //Take focus if we don't have it
        if (!this.isFocusOwner()) {
            this.requestFocusInWindow();
        }
    }
}
