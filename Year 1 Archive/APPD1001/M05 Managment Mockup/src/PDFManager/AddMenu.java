package PDFManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddMenu {
    private JFormattedTextField formattedTextField1;
    private JButton browseButton;
    JPanel panel;
    private JButton backButton;
    JButton browseButton1;
    JButton javaButton;
    JButton TBAButton1;
    JButton TBAButton;
    JTextField locationMoveFileToTextField;
    private JFrame frame;
    File afile = null;

    // Create a file chooser
    final JFileChooser fc = new JFileChooser();


    public AddMenu(WindowManager win) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new MainMenu(myApp).panel);
            }
        });
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new File("/"));
                int returnVal = fc.showOpenDialog(frame);

                // hamdle to file to move

                // open file chooser
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    afile = fc.getSelectedFile();
                    // This is where a real application would open the file.
                    System.out.println("File Name=" + afile.getName());
                    System.out.println("File Path=" + afile.getAbsolutePath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }

                // rename choosen file to somewhere c:\folderB

                if (afile != null) {
                    formattedTextField1.setText(afile.getAbsolutePath());
                }
            }
        });
        browseButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.setCurrentDirectory(new File("/"));
                int returnVal = fc.showOpenDialog(frame);

                // hamdle to file to move
                File afile = null;

                // open file chooser
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    afile = fc.getCurrentDirectory();
                    // This is where a real application would open the file.
                    System.out.println("File Name=" + afile.getName());
                    System.out.println("File Path=" + afile.getPath());
                } else {
                    System.out.println("Open command cancelled by user.");
                }

                // rename choosen file to somewhere c:\folderB

                if (afile != null) {
                    locationMoveFileToTextField.setText(afile.getPath());
                }
            }
        });
        javaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (afile != null) {
                    try {
                        if (afile.renameTo(new File("/GIT/w0422681/APPD1001/M05 Managment Mockup/PDFs/JAVA/" + afile.getName()))) {
                            System.out.println("File is moved successful!");
                        } else {
                            System.out.println("File is failed to move!");
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

//    private void initialize() {
//
//        // List the directory
//        File[] files = new File("/").listFiles();
//
//        // If this pathname does not denote a directory, then listFiles() returns null.
//        List<String> results = new ArrayList<String>();
//        if (files == null) {
//            System.out.println("No Files....di you create dir called c:\folderA  ?");
//        } else {
//            for (File file : files) {
//                if (file.isFile()) {
//                    results.add(file.getName());
//                    System.out.println("File=" + file.getName());
//                }
//            }
//        }
//
//    }
}

