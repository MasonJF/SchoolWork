package PDFManager;

import sun.tools.jconsole.VariableGridLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class ExploreMenu extends JFrame {

    private JTree fileTree;
    private FileSystemModel fileSystemModel;
    private JTextArea fileDetailsTextArea = new JTextArea();
    private JButton backButton;
    private JPanel panel;

    public ExploreMenu(String directory) {
        super("Hi Russ");
        fileDetailsTextArea.setEditable(false);
        fileSystemModel = new FileSystemModel(new File(directory));
        fileTree = new JTree(fileSystemModel);
        fileTree.setEditable(true);
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent event) {
                //TODO: Create deletion event on leaf
            }
        });
        getContentPane().setLayout(new BorderLayout());
        panel = new JPanel();
        getContentPane().add(panel);
//        panel.setLayout(new BorderLayout(2, 1));

        JScrollPane sPane = new JScrollPane(fileTree);
        panel.add(sPane); // important adds jtree
        backButton = new JButton(); //instanciates the button
        panel.add(backButton);
        backButton.setMaximumSize(new Dimension(30, 30));
        backButton.setText("Back");

//        backButton.setText("Back");
//        backButton.setHorizontalAlignment(SwingConstants.RIGHT);
//        backButton.setVerticalAlignment(SwingConstants.BOTTOM);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ExploreMenu.this.dispose();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new MainMenu(myApp).panel);
            }
        });
    }
}

class FileSystemModel implements TreeModel {
    private File root;

    private Vector listeners = new Vector();

    public FileSystemModel(File rootDirectory) {
        root = rootDirectory;
    }

    public Object getRoot() {
        return root;
    }

    public Object getChild(Object parent, int index) {
        File directory = (File) parent;
        String[] children = directory.list();
        return new TreeFile(directory, children[index]);
    }

    public int getChildCount(Object parent) {
        File file = (File) parent;
        if (file.isDirectory()) {
            String[] fileList = file.list();
            if (fileList != null)
                return file.list().length;
        }
        return 0;
    }

    public boolean isLeaf(Object node) {
        File file = (File) node;
        return file.isFile();
    }

    public int getIndexOfChild(Object parent, Object child) {
        File directory = (File) parent;
        File file = (File) child;
        String[] children = directory.list();
        for (int i = 0; i < children.length; i++) {
            if (file.getName().equals(children[i])) {
                return i;
            }
        }
        return -1;

    }

    public void valueForPathChanged(TreePath path, Object value) {
        File oldFile = (File) path.getLastPathComponent();
        String fileParentPath = oldFile.getParent();
        String newFileName = (String) value;
        File targetFile = new File(fileParentPath, newFileName);
        oldFile.renameTo(targetFile);
        File parent = new File(fileParentPath);
        int[] changedChildrenIndices = { getIndexOfChild(parent, targetFile) };
        Object[] changedChildren = { targetFile };
        fireTreeNodesChanged(path.getParentPath(), changedChildrenIndices, changedChildren);

    }

    private void fireTreeNodesChanged(TreePath parentPath, int[] indices, Object[] children) {
        TreeModelEvent event = new TreeModelEvent(this, parentPath, indices, children);
        Iterator iterator = listeners.iterator();
        TreeModelListener listener = null;
        while (iterator.hasNext()) {
            listener = (TreeModelListener) iterator.next();
            listener.treeNodesChanged(event);
        }
    }

    public void addTreeModelListener(TreeModelListener listener) {
        listeners.add(listener);
    }

    public void removeTreeModelListener(TreeModelListener listener) {
        listeners.remove(listener);
    }

    private class TreeFile extends File {
        public TreeFile(File parent, String child) {
            super(parent, child);
        }

        public String toString() {
            return getName();
        }
    }
}
