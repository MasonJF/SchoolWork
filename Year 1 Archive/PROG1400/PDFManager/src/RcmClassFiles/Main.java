package RcmClassFiles;

import javax.swing.*;

public class Main {
    private static MainMenu mainProgram = null;
    static JFrame addFrame = new JFrame("Portfolio Manager");


    public static void main(String[] args) {
        String data = FileIO.fileRead("selectedRoot.rotxt");
        if(data.equals("")) {
            FirstBoot firstBoot = new FirstBoot();
            JFrame frame = new JFrame("Portfolio Manager");
            frame.setContentPane(firstBoot.panel1);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setLocation(50, 50);
            frame.setSize(800, 600);
            frame.setVisible(true);
        }else{
            mainProg();
        }
    }

    static void mainProg() {
        JFrame frame = new JFrame("Portfolio Manager");
        mainProgram = new MainMenu();
        frame.setContentPane(mainProgram.menuPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50, 50);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    static void addFiles() {
        addFrame = new JFrame("Portfolio Manager");
        addFrame.setContentPane(new NameFile(mainProgram).panel1);
        addFrame.pack();
        addFrame.setLocation(75, 250);
        addFrame.setSize(800, 50);
        addFrame.setVisible(true);
    }
}