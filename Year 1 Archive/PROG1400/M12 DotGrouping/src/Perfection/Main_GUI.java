package Perfection;

import javax.swing.*;
import java.awt.*;

class Main_GUI {

    static void run(GuiSystem guiSys) {
        System.out.println(Integer.MAX_VALUE);
//        System.exit(0);

        // Set up jFrame window for drawing
        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        DrawHere d = new DrawHere(guiSys);
        frame.setContentPane(d);
        frame.getRootPane().setBackground(Color.LIGHT_GRAY);
        frame.setVisible(true);

        // Set up Timer
        Timer timer = new Timer(5, d); // Set time, and this object gets event
        timer.setInitialDelay(100); //
        timer.setCoalesce(true); // Don't stack up events
        timer.start(); // Start the timer object

        System.out.println("B");

    }
}
