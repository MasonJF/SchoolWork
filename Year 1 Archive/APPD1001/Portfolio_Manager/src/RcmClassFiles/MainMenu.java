package RcmClassFiles;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class MainMenu implements TreeSelectionListener {
    JPanel menuPanel;
    private JButton browseButton;
    private JTextField selectADirectoryTextField;
    private JTree tree1;
    private JButton viewButton;
    private JButton exitButton;
    private JButton addButton;
    private JButton attachButton;
    private JFrame frame;
//    String browsePath = "/git/";

    // Create a file chooser
    private final JFileChooser fileChooser = new JFileChooser();

    private void createUIComponents() {
        // Top root of tree
        Path topDir = FileSystems.getDefault().getPath("/GIT/w0422681/APPD1001/Portfolio_Manager/Portfolio_Files");

        //Create the nodes.
        DefaultMutableTreeNode top =
                new DefaultMutableTreeNode("Root: " + topDir.toString());
        createNodes(top, topDir);

        //Create a tree that allows one selection at a time.
        this.tree1 = new JTree(top);

        // one selection at a time
        tree1.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);

        //Listen for when the selection changes.
        tree1.addTreeSelectionListener(this);
    }

    private void updateUIComponents(final String newPath) {
        Path topDir = FileSystems.getDefault().getPath(newPath);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root: " + topDir.toString());
        createNodes(top, topDir);
        tree1.setModel(new DefaultTreeModel(top));
    }


    /**
     * Called recursively to populate the tree
     * @param nextTop The root node of this particular branch
     * @param nextDir The root directory of this particular branch
     */
    private void createNodes(DefaultMutableTreeNode nextTop, Path nextDir) {
//        OpenFileFilter isJava = new OpenFileFilter("java");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(nextDir)) {
            for (Path file: stream) {
                FileInfo fileInfo = new FileInfo(file);
                DefaultMutableTreeNode aNode = new DefaultMutableTreeNode(fileInfo );
                if(fileInfo.isDirectory){
                    nextTop.add(aNode);
                    createNodes(aNode, file);  // Recursively build the tree...a new folder here
                } if (aNode.toString().toLowerCase().endsWith(".txt")){
                    nextTop.add(aNode);
                }

            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }





    /**
     *
     * Contain file stuff (full path, filename, ...)
     * Use public to allow this class direct access
     *
     * Design choice: Use this class, and keep
     * whatever you want for every node, or don't
     * use this class at all, and keep the "Path" object
     * for each node, which can be used to derive the
     * filenames when needed.
     *
     */
    private class FileInfo {
        public Path file;
        public String filename;
        public String fullFilename;
        public boolean isDirectory;

        public FileInfo(Path file) {
            this.file = file;
            this.filename = file.getName(file.getNameCount()-1).toString();
            this.fullFilename = file.toString();    // file.getFileName().toString();
            this.isDirectory = Files.isDirectory(file);
        }

        public String toString() {
            return filename;
        }

    }




    MainMenu() {
        // Change this path to something on your C drive.
        Path dir = FileSystems.getDefault().getPath("/");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file: stream) {
                System.out.println(file.getFileName() +" ... is it a Directory?   ..."+ Files.isDirectory(file) );
                System.out.println("Name="+file.getName(file.getNameCount()-1) );
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//        browseButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fileChooser.setCurrentDirectory(new File("/"));
//                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//                int returnVal = fileChooser.showOpenDialog(frame);
//
//                // handle to file to move
//                File afile = null;
//
//                // open file chooser
//                if (returnVal == JFileChooser.APPROVE_OPTION) {
//                    afile = fileChooser.getSelectedFile();
//                    // This is where a real application would open the file.
//                    System.out.println("File Name=" + afile.getName());
//                    System.out.println("File Path=" + afile.getAbsoluteFile());
//                } else {
//                    System.out.println("Open command cancelled by user.");
//                }
//
//                if (afile != null) {
//                    selectADirectoryTextField.setText(afile.getPath());
//                    String newPath = afile.getPath();
//                    updateUIComponents(newPath);
//                }
//            }
//        });
//        attachButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tree1.getTreeSelectionListeners();

            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menuPanel.addComponentListener(new ComponentAdapter() {
        });

//        tree1.addTreeSelectionListener(new TreeSelectionListener() {
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
//                Path file = (Path) tree1.getLastSelectedPathComponent();
//                tree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
//                if (node == null) {
//                    JOptionPane.showMessageDialog(frame, "You must select a review file to open.");
//                }
//                if(file.endsWith(".java")) {
//
//                }
//            }
//        });
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        // Get the selected tree node (either file or folder)
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree1.getLastSelectedPathComponent();

        if (node == null) return;

        Object nodeInfo = node.getUserObject();
        boolean DEBUG = true;
        if (node.isLeaf()) {
            if (DEBUG) {
                System.out.println("isLeaf = " + node.toString());
            }
        } else {
            System.out.println("node = " + node.toString());
        }
        if (DEBUG) {
            // cast the node's Object to "FileInfo" to get data
            // This cast raises an exception if the top-most-node is selected....why?
            FileInfo info = (FileInfo)nodeInfo;
            System.out.println("Selected info=" + info.fullFilename + "  Dir: " +info.isDirectory);
        }
    }
}