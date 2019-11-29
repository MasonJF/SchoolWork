package PDFManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenu {
    JPanel panel;
    private JButton backButton;
    private JButton exitButton;

    public ExitMenu(WindowManager win) {
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new MainMenu(myApp).panel);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

}
