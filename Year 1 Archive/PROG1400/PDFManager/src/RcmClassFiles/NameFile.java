package RcmClassFiles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.*;

public class NameFile {
    JPanel panel1;
    private JTextField nameOfFileTextField;
    private JButton browseButton1;
    private JButton addButton;

    public NameFile(MainMenu kappa) {
        browseButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameOfFileTextField.setText(FileBrowser.browse());
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path toBeMoved = Paths.get(nameOfFileTextField.getText());
                Path moveTarget = Paths.get("/Users/masonfraser/Documents/PDFHolder/"+new File(toBeMoved.toString()).getName());

                try {
                    Files.copy(toBeMoved, moveTarget, REPLACE_EXISTING);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                Main.addFrame.dispatchEvent(new WindowEvent(Main.addFrame, WindowEvent.WINDOW_CLOSING));
                kappa.refreshFileStructure();

            }
        });
    }

    public boolean refreshCheck(){
        return true;
    }
}
