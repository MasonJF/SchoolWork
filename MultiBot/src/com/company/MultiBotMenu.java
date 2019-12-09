package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiBotMenu {
    private JPanel multibotPanel;
    private JComboBox skillDropDown;
    private JLabel skillLabel;
    private JLabel titleLabel;
    private JButton startButton;
    private static boolean startBool = false;
    private int dropDownReturn;




    public void guiMain() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(multibotPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocation(800, 600);
        frame.setAlwaysOnTop(true);
    }

    public MultiBotMenu() {
        startButton.addActionListener(e -> {
            dropDownReturn = skillDropDown.getSelectedIndex();
            startBool = true;
        });
    }

    public boolean isStartBool() {
        return startBool;
    }

    public void setStartBool(boolean startBool) {
        MultiBotMenu.startBool = startBool;
    }

    public int getDropDownReturn() {
        return dropDownReturn;
    }
}