package RcmClassFiles;

import javax.swing.*;


public class FirstBoot {
    JPanel panel1;
    private JLabel hiWelcome;
    private JLabel withThisApp;
    private JButton browseButton;

    FirstBoot() {
        browseButton.addActionListener(e -> {
                FileIO.fileWrite(FileBrowser.browse(), "selectedRoot.rotxt");
                Main.mainProg();
        });
    }
}
