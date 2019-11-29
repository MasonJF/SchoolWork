package PDFManager;

import javax.swing.*;

public class WindowManager {

    public JFrame frame;

    public void initFrame(String Title, JPanel Pane){
        frame = new JFrame(Title);
        frame.setContentPane(Pane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 400);
        frame.setLocation(50, 50); //so it isn't at very top left
        frame.setVisible(true);

    }
}
