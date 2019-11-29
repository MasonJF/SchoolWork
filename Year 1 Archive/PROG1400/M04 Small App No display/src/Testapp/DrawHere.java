package Testapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;


public class DrawHere extends JPanel implements ActionListener {



    private Gun g1;
    private Gun g2;
    private Gun g3;

    DrawHere() {

        System.out.println("Test");

        // Set up cat
        Random rand = new Random();
        g1 = new Gun(rand.nextInt(25)+5, rand.nextInt(25)+5, "Hi Russ");
        g1.vari = Color.GREEN;
        g2 = new Gun(rand.nextInt(25)+5, rand.nextInt(25)+5, "Have a good day");
        g2.vari = Color.BLUE;
        g3 = new Gun(rand.nextInt(25)+5, rand.nextInt(25)+5, "Bye Russ");
        g3.vari = Color.RED;
        g1.start();
        g2.start();
        g3.start();

        this.setFocusable(true);
        this.requestFocusInWindow();



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
        g1.Paint(g2d);
        g2.Paint(g2d);
        g3.Paint(g2d);

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
