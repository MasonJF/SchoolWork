package PDFManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
public class ExploreMenuOLD2 {

    JPanel panel;
    JLabel files;
    public JFrame frame;
    private JScrollPane scrollPane;
    private JSplitPane splitPane;
    private JTree genreTree;
    private JButton addButton;
    JScrollPane spane;
    private JButton removeButton;
    private JButton back;
    private FileSystemModel fileSystemModel;
    private JTextArea fileDetailsTextArea = new JTextArea();

    public ExploreMenuOLD2(WindowManager win, String directory) {
        fileDetailsTextArea.setEditable(false);
        fileSystemModel = new FileSystemModel(new File(directory));
        JTree genreTree = new JTree(fileSystemModel);
        genreTree.setEditable(true);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, new JScrollPane(
                genreTree), new JScrollPane(fileDetailsTextArea));
        spane.add(splitPane);
        spane.validate();
//        this.panel.getParent().add(splitPane);
//        frame.add(scrollPane);

//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(640, 480);
//        frame.setVisible(true);
    }


    public void createUIComponents() {

    }
}


