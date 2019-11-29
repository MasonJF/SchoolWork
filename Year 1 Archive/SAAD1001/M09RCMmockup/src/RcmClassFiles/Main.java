package RcmClassFiles;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("RCM");
        frame.setContentPane(new MainMenu().menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50, 50);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}