package PDFManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class WelcomeScreen {
    private JLabel welcomeText;
    JPanel panel1;
    JButton beginButton;
//    public static JFrame frame = new JFrame("GUI");


    public WelcomeScreen(WindowManager win) {
        beginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
//                frame.pack();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new MainMenu(myApp).panel);
            }
        });
    }

    //    public void runFrame() {
//        frame.setContentPane(new WelcomeScreen().panel1);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
////        frame.pack();
//        frame.setLocation(50, 50);  //so it isn't at very top left
//        frame.setVisible(true);

}