package org.lwjglb.game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Random;

import static org.lwjglb.game.DummyGame.r;

public class GameGUI {

    private JPanel panelMain;
    private JButton clearButton;
    private JButton resetButton;
    private JButton carButton;
    JSpinner spinner1;
    private JButton airplaneButton;
    JTextField xPositionTextField;
    JTextField zPositionTextField;
    JTextField xVelocityTextField;
    JTextField zVelocityTextField;
    private JButton randomButton;
    private JTextField yPositionTextField;
    private JTextField yVelocityTextField;
    public JButton leftButton;
    public JButton rightButton;
    public JButton upButton;
    public JButton downButton;
    static Integer spinVal;
    static Float xpValue = 0.0000f;
    static Float zpValue = 0.0000f;
    static Float xvValue = 0.0000f;
    static Float zvValue = 0.0000f;
    static Float yvValue = 0.0000f;
    static Float ypValue = 0.0000f;
    private static Float yvSpeed = 0.04f;
    public static int isLeft;
    public static int isRight;
    public static int isUp;
    public static int isDown;



    private static Boolean clearCommand = false;
    private static Boolean resetCommand = false;
    private static Boolean addCarCommand = false;
    private static Boolean addAirplaneCommand = false;


    public GameGUI()  {
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearCommand = true;
                System.out.println(" Clear Button");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCommand = true;
            }
        });

        carButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCarCommand = true;
                spinVal = (Integer) spinner1.getValue();
                try {
                    xpValue = Float.parseFloat(xPositionTextField.getText());
                    zpValue = Float.parseFloat(zPositionTextField.getText());
                    xvValue = Float.parseFloat(xVelocityTextField.getText());
                    zvValue = Float.parseFloat(zVelocityTextField.getText());
                    ypValue = -15f;
                    yvValue = 0f;
                }catch (Exception ex){
                    xpValue = r.nextFloat();
                    zpValue = r.nextFloat();
                    xvValue = r.nextFloat();
                    zvValue = r.nextFloat();
                    ypValue = -14.8f;
                    yvValue = 0f;
                }
                System.out.println(xpValue);
                System.out.println(zpValue);
                System.out.println(xvValue);
                System.out.println(zvValue);

            }
        });
        spinner1.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                float randomXP = 0 + rand.nextFloat() * (1);
                float randomZP = 0 + rand.nextFloat() * (1);
                float randomXV = 0 + rand.nextFloat() * (1);
                float randomZV = 0 + rand.nextFloat() * (1);
                float randomYP = 0 + rand.nextFloat() * (1);
                float randomYV = 0 + rand.nextFloat() * (1);
                xPositionTextField.setText(Float.toString(randomXP));
                zPositionTextField.setText(Float.toString(randomZP));
                xVelocityTextField.setText(Float.toString(randomXV));
                zVelocityTextField.setText(Float.toString(randomZV));
                yPositionTextField.setText(Float.toString(randomYP));
                yVelocityTextField.setText(Float.toString(randomYV));

                }

        });
        airplaneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addAirplaneCommand = true;
                spinVal = (Integer) spinner1.getValue();
                try {
                    xpValue = Float.parseFloat(xPositionTextField.getText());
                    zpValue = Float.parseFloat(zPositionTextField.getText());
                    xvValue = Float.parseFloat(xVelocityTextField.getText());
                    zvValue = Float.parseFloat(zVelocityTextField.getText());
                    ypValue = Float.parseFloat(yPositionTextField.getText());
                    yvValue = yvSpeed * Float.parseFloat(yVelocityTextField.getText());
                }catch (Exception ex){
                    xpValue = r.nextFloat();
                    zpValue = r.nextFloat();
                    xvValue = r.nextFloat();
                    zvValue = r.nextFloat();
                    ypValue = r.nextFloat();
                    yvValue = yvSpeed * r.nextFloat();

                }
            }
        });
        leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLeft = 1;
                isRight = 0;
            }
        });
        rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isLeft = 0;
                isRight = 1;
            }
        });
        upButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isUp = 1;
                isDown = 0;
            }
        });
        downButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isUp = 0;
                isDown = 1;
            }
        });
    }


    static void guiSetup() {
        JFrame frame = new JFrame("GameGUI");
        frame.setContentPane(new GameGUI().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(150,150);  //so it isn't at very top left
        frame.setVisible(true);
    }

    // Force that when reset vaue is read back as true, it is reset to false
    // so that we don't get a studder of multiple resets.
    // Also, DO NOT include a setter for this field as that would defeat the design.
    static Boolean getClearCommand() {
        boolean returnValue = false;
        if (clearCommand) {
            clearCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

    static Boolean getResetCommand() {
        boolean returnValue = false;
        if (resetCommand) {
            resetCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

    static Boolean getAddCarCommand() {
        boolean returnValue = false;
        if (addCarCommand) {
            addCarCommand = false;
            returnValue = true;
        }
        return returnValue;
    }
    static Boolean getAddAirplaneCommand() {
        boolean returnValue = false;
        if (addAirplaneCommand) {
            addAirplaneCommand = false;
            returnValue = true;
        }
        return returnValue;
    }

}


