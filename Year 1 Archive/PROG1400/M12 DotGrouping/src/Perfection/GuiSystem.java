package Perfection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.*;
import java.util.Random;

public class GuiSystem {
    private JButton generateButton;
    public JSpinner spinnerGenerationValues;
    JPanel panel1;
    public JTextField enterCoordsDataFileTextField;
    private JButton browseButton;
    private JButton RUNPROGRAMButton;
    public JSpinner thresholdSpinner;
    private JFrame frame;
    static String newPath = "Coords.txt";
    private final JFileChooser fileChooser = new JFileChooser();


    GuiSystem() {

        //Data Random Generation

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random rand = new Random();
                String data = "";
                for(int i = 0; i < getSpinnerGenerationValues(); i++){
                    data = data + (rand.nextInt(550)+5)+";"+(rand.nextInt(650)+5)+";"+
                            Main.dotColors[rand.nextInt(Main.dotColors.length)].hashCode()+"\n";
                }
                FileIO.fileWrite(data, "Coords.txt");
                System.out.println(FileIO.fileRead("Coords.txt"));
            }
        });
        spinnerGenerationValues.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //File Browser

                fileChooser.setCurrentDirectory(new File("/git/w0422681"));
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                int returnVal = fileChooser.showOpenDialog(frame);

                // handle to file to move
                File afile = null;

                // open file chooser
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    afile = fileChooser.getSelectedFile();
                    // This is where a real application would open the file.
                    System.out.println("File Name=" + afile.getName());
                    System.out.println("File Path=" + afile.getAbsoluteFile());
                } else {
                    System.out.println("Open command cancelled by user.");
                }

                if (afile != null) {
                    enterCoordsDataFileTextField.setText(afile.getPath());
                    newPath = afile.getPath();
                }else{
                    newPath = "~/Coords.txt";
                }
//                HashMap<Integer, int[]> x = FileIO.parseCoords();
                System.out.println("suh");
            }
        });
        RUNPROGRAMButton.addActionListener(new ActionListener() {

            //Run the actual Program

            @Override
            public void actionPerformed(ActionEvent e) {
                if(newPath.equals("")){
                    newPath = "/Coords.txt";
                }
                Main_GUI.run(GuiSystem.this);
            }
        });

        thresholdSpinner.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }

    private int getSpinnerGenerationValues() {
        return (int) spinnerGenerationValues.getValue();
    }

    int getThresholdSpinner() {
        return (int) thresholdSpinner.getValue();
    }

}

