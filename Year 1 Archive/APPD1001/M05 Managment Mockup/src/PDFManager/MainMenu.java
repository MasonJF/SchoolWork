package PDFManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JButton addButton;
    private JButton exploreFilesButton;
    private JButton exitButton;
    JPanel panel;


    public MainMenu(WindowManager win) {
        addButton.addActionListener(e -> {
            win.frame.dispose();
            WindowManager myApp = new WindowManager();
            myApp.initFrame("Test", new AddMenu(myApp).panel);
        });
        exploreFilesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
                new ExploreMenu("/GIT/w0422681/APPD1001/M05 Managment Mockup/PDFs/");
//                WindowManager myApp = new WindowManager();
//                myApp.initFrame("Test", new ExploreMenu("/GIT/w0422681/APPD1001/M05 Managment Mockup/PDFs/"));
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new ExitMenu(myApp).panel);
            }
        });
    }

    //    public void runFrame() {
//        JFrame frame = new JFrame("GUI");
//        frame.setContentPane(new MainMenu().panel);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.pack();
//        frame.setLocation(50, 50);  //so it isn't at very top left
//        frame.setVisible(true);
//    }
}
