package PDFManager;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

/**
 *
 * @author Russ
 *
 *         Before running this GUI, make 2 folders:
 *
 *         - C:\folderA ... put some sample files here
 *
 *         - C:\folderB ... run this program and move files to here
 *
 */
public class FileChooserSample {

    private JFrame frame;

    // Create a file chooser
    final JFileChooser fc = new JFileChooser();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FileChooserSample window = new FileChooserSample();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public FileChooserSample() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // List the directory
        File[] files = new File("/GIT/w0422681/APPD1001/M05 Managment Mockup").listFiles();

        // If this pathname does not denote a directory, then listFiles() returns null.
        List<String> results = new ArrayList<String>();
        if (files == null) {
            System.out.println("No Files....di you create dir called c:\folderA  ?");
        } else {
            for (File file : files) {
                if (file.isFile()) {
                    results.add(file.getName());
                    System.out.println("File=" + file.getName());
                }
            }
        }

        // Set up Frame for file chooser
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnFileChooser = new JButton("File Chooser");
        btnFileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // In response to a button click:
                // Open chooser and get filename and path
                fc.setCurrentDirectory(new File("/GIT/w0422681/APPD1001/M05 Managment Mockup"));
                int returnVal = fc.showOpenDialog(frame);

                // hamdle to file to move
                File afile = null;

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
                    try {
                        if (afile.renameTo(new File("" + afile.getName()))) {
                            System.out.println("File is moved successful!");
                        } else {
                            System.out.println("File is failed to move!");
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        btnFileChooser.setBounds(0, 31, 176, 43);
        frame.getContentPane().add(btnFileChooser);
    }
}