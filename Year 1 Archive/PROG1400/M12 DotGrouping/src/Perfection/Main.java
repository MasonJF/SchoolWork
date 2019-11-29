package Perfection;

import javax.swing.*;
import java.awt.*;

public class Main {
    static Color[] dotColors= new Color[]{Color.BLUE, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE};
    public static void main(String[] args) {
        JFrame frame = new JFrame("Data Grouping");
        frame.setContentPane(new GuiSystem().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50, 50);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
