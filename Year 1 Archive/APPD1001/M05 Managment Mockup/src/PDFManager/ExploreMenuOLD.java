package PDFManager;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.File;
import java.net.URL;

public class ExploreMenuOLD implements TreeSelectionListener {
    DefaultMutableTreeNode root, parent, child, node;
    JPanel panel;

    private final JFileChooser fc = new JFileChooser();
    private JButton back;
    private JTree genreTree;
    private JScrollPane scrollPane;
    private JButton addButton;
    TreePath treePath;
    private JButton removeButton;
    int index;
//    public void treeFunctions() {


    public ExploreMenuOLD(WindowManager win) {
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                win.frame.dispose();
                WindowManager myApp = new WindowManager();
                myApp.initFrame("Test", new MainMenu(myApp).panel);
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() == addButton) {
                    int rt = fc.showOpenDialog(win.frame);
                    File afile = null;
                    if (rt == JFileChooser.APPROVE_OPTION) {
                        afile = fc.getSelectedFile();
                    }

                    if (afile != null) {
                        try {
                            if (afile.renameTo(new File("/" + afile.getName()))) {
                                System.out.println("File is moved successful!");
                            } else {
                                System.out.println("File is failed to move!");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    DefaultMutableTreeNode SelectedNode;

                    treePath = genreTree.getSelectionPath();
                    SelectedNode = (DefaultMutableTreeNode) treePath
                            .getLastPathComponent();

                    index = SelectedNode.getIndex(SelectedNode) + 1;

//                    String NodeStr = JOptionPane.showInputDialog(null,
//                            "Enter the node value", "New Tree Node",
//                            JOptionPane.QUESTION_MESSAGE);
//
//                    node = new DefaultMutableTreeNode(NodeStr);
                    SelectedNode.insert(node, index);
                    genreTree.updateUI();
                } else if (ae.getSource() == removeButton) {
                    int val = JOptionPane.showConfirmDialog(panel,
                            "Please confirm to delete ?");
                    if (val == 0) {
                        DefaultMutableTreeNode SelectedNode;

                        treePath = genreTree.getSelectionPath();
                        SelectedNode = (DefaultMutableTreeNode) treePath
                                .getLastPathComponent();
                        if (SelectedNode.isLeaf()) {
                            parent = (DefaultMutableTreeNode) SelectedNode.getParent();
                            parent.remove(SelectedNode);
                            genreTree.updateUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Unable to Remove");
                        }
                    }
                }

            }
        });
    }

    private void createUIComponents() {
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("PDFs");
        createNodes(top);
        this.genreTree = new JTree(top);
        JScrollPane scrollPane = new JScrollPane(genreTree);
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("Java");
        top.add(category);

//        //original Tutorial
//        book = new DefaultMutableTreeNode(new BookInfo
//                ("The Java Tutorial: A Short Course on the Basics",
//                        "test.html"));
//        category.add(book);
//
//        //Tutorial Continued
//        book = new DefaultMutableTreeNode(new BookInfo
//                ("The Java Tutorial Continued: The Rest of the JDK",
//                        "tutorialcont.html"));
//        category.add(book);
//
//        //Swing Tutorial
//        book = new DefaultMutableTreeNode(new BookInfo
//                ("The Swing Tutorial: A Guide to Constructing GUIs",
//                        "swingtutorial.html"));
//        category.add(book);
//
//        //...add more books for programmers...
//
//        category = new DefaultMutableTreeNode("C.Sh");
//        top.add(category);
//
//        //VM
//        book = new DefaultMutableTreeNode(new BookInfo
//                ("The Java Virtual Machine Specification",
//                        "vm.html"));
//        category.add(book);
//
//        //Language Spec
//        book = new DefaultMutableTreeNode(new BookInfo
//                ("The Java Language Specification",
//                        "jls.html"));
//        category.add(book);
//
//        //Where the tree is initialized:
////        genreTree.getSelectionModel().setSelectionMode
////                (TreeSelectionModel.SINGLE_TREE_SELECTION);
//
////        Listen for when the selection changes.
////        genreTree.addTreeSelectionListener(this);
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
//which node was selected
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                genreTree.getLastSelectedPathComponent();
        if (node == null) return;
        Object nodeInfo = node.getUserObject();

        //if node is a leaf
        if (node.isLeaf()) {
            //do something with the above object
        }
    }

    private class BookInfo {
        public String bookName;
        public URL bookURL;

        public BookInfo(String book, String filename) {
            bookName = book;
            bookURL = getClass().getResource(filename);
            if (bookURL == null) {
                System.err.println("Couldn't find file: "
                        + filename);
            }
        }

        public String toString() {
            return bookName;
        }
    }


//    public void valueChanged(TreeSelectionEvent e) {
////Returns the last path element of the selection.
////This method is useful only when the selection model allows a single selection.
//        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
//                genreTree.getLastSelectedPathComponent();
//
//        if (node == null)
//            //Nothing is selected.
//            return;
//
//        Object nodeInfo = node.getUserObject();
//        if (node.isLeaf()) {
//            BookInfo book = (BookInfo)nodeInfo;
//            displayURL(book.bookURL);
//        } else {
//            displayURL(helpURL);
//        }
//    }
}
