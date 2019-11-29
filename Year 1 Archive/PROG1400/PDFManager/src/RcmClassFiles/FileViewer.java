package RcmClassFiles;


import javax.swing.*;
import java.awt.event.*;

public class FileViewer {
    private JButton backButton;
    private JEditorPane fileEdit;
    private JButton saveButton;
    private JPanel viewerPanel;
    private static JFrame frame = new JFrame("FileViewer");
    private String data;

    private FileViewer(String fileName) {

        fileEdit.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
        try {
            fileEdit.setText(FileIO.fileRead(fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
        saveButton.addActionListener(e -> {
            data = fileEdit.getText();
            FileIO.fileWrite(data, fileName);
        });
        backButton.addActionListener(e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
    }

    static void viewerRun(String name){
        frame.setContentPane(new FileViewer(name).viewerPanel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocation(50, 50);
        frame.setSize(800, 600);
        frame.setVisible(true);


    }


}
