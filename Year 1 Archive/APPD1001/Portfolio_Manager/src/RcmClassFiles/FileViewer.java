package RcmClassFiles;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class FileViewer {
    private JButton backButton;
    private JEditorPane fileEdit;
    private JButton saveButton;

    public FileViewer() {
        fileEdit.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
            }
        });
    }
}
