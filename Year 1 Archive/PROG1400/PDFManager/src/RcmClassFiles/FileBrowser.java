package RcmClassFiles;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FileBrowser {

    public static String browse() {
        final JFileChooser fileChooser = new JFileChooser();
        JFrame frame = new JFrame();
        String newPath = "";
        fileChooser.setCurrentDirectory(new File("/Users/masonfraser/"));
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
//            FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
//            selectADirectoryTextField.setText(FileIO.fileRead("selectedRoot.rotxt"));
        } else {
            System.out.println("Open command cancelled by user.");
        }

        if (afile != null) {
//            FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
            newPath = afile.getPath();
//            updateUIComponents(newPath);
        }
        return newPath;
    }
}