package RcmClassFiles;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ComponentAdapter;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class MainMenu implements TreeSelectionListener {
    JPanel menuPanel;
    private JButton browseButton;
    private JTree tree1;
    private JButton viewButton;
    private JButton exitButton;
    private JButton addButton;
    private JButton attachButton;
    private JTextField selectADirectoryTextField;
    private JSplitPane splitPane1; //This is actually being used, dunno why its being a cuck.
    private JButton commentsButton; //To be implemented Later. Needs to be here, since the button is there.
    private JLabel fileString;
    private JLabel fileAuthor;
    private JLabel fileWNumber;
    private JLabel fileDateRevLast;
    private JLabel fileDateFixLast;
    private JLabel fileCommentList;
    private JLabel fileNew;
    private JLabel fileFixed;
    private JLabel fileNA;

    private boolean isNotDirectoryCheck;
//    String browsePath = "/git/";

    // Create a file chooser
    private final JFileChooser fileChooser = new JFileChooser();
    private String workingFile;

    private void createUIComponents() {
        // Top root of tree
        Path topDir = FileSystems.getDefault().getPath(FileIO.fileRead("selectedRoot.rotxt"));

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

        //Building a new JFrame for file preview data
        JPanel previewPanel = new JPanel();
        previewPanel.setLayout(null);
        splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, menuPanel, previewPanel);
        fileString = new JLabel("Created by: Mason Fraser");
        fileAuthor = new JLabel("Hi Russ!");
        fileDateFixLast = new JLabel();
        fileDateRevLast = new JLabel();
        fileWNumber = new JLabel();
        fileCommentList = new JLabel();
        fileNA = new JLabel();
        fileNew = new JLabel();
        fileFixed = new JLabel();
        previewPanel.add(fileString).setBounds(8, 8, 200, 12);
        previewPanel.add(fileAuthor).setBounds(8, 25, 200, 12);
        previewPanel.add(fileDateFixLast).setBounds(8, 42, 200, 12);
        previewPanel.add(fileDateRevLast).setBounds(8, 59, 200, 12);
        previewPanel.add(fileWNumber).setBounds(8, 76, 200, 12);
        previewPanel.add(fileCommentList).setBounds(8, 93, 200, 12);
        previewPanel.add(fileNew).setBounds(300, 42, 200, 12);
        previewPanel.add(fileFixed).setBounds(300, 59, 200, 12);
        previewPanel.add(fileNA).setBounds(300, 76, 200, 12);

    }

    private void updateUIComponents(final String newPath) {

        //Updates the tree within the panel.

        Path topDir = FileSystems.getDefault().getPath(newPath);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root: " + topDir.toString());
        createNodes(top, topDir);
        tree1.setModel(new DefaultTreeModel(top));
    }


    /**
     * Called recursively to populate the tree
     *
     * @param nextTop The root node of this particular branch
     * @param nextDir The root directory of this particular branch
     */
    private void createNodes(DefaultMutableTreeNode nextTop, Path nextDir) {
//        OpenFileFilter isJava = new OpenFileFilter("java");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(nextDir)) {
            for (Path file : stream) {
                FileInfo fileInfo = new FileInfo(file);
                DefaultMutableTreeNode aNode = new DefaultMutableTreeNode(fileInfo);
                if (fileInfo.isDirectory) {
                    nextTop.add(aNode);
                    createNodes(aNode, file);  // Recursively build the tree...a new folder here
                }
                if (aNode.toString().toLowerCase().endsWith(".java") || aNode.toString().toLowerCase().endsWith(".review")) {
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
     * Contain file stuff (full path, filename, ...)
     * Use public to allow this class direct access
     * <p>
     * Design choice: Use this class, and keep
     * whatever you want for every node, or don't
     * use this class at all, and keep the "Path" object
     * for each node, which can be used to derive the
     * filenames when needed.
     */
    private class FileInfo {

        Path file;
        String filename;
        String fullFilename;
        boolean isDirectory;


        FileInfo(Path file) {
            this.file = file;
            this.filename = file.getName(file.getNameCount() - 1).toString();
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
        System.out.println(dir);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
            for (Path file : stream) {
                System.out.println(file.getFileName() + " ... is it a Directory?   ..." + Files.isDirectory(file));
                System.out.println("Name=" + file.getName(file.getNameCount() - 1));
            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
        addButton.addActionListener(e -> {

        });
        browseButton.addActionListener(e -> {
            JFrame frame = new JFrame();
            fileChooser.setCurrentDirectory(new File("/"));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            int returnVal = fileChooser.showOpenDialog(frame);

            // handle to file to move
            File afile = null;

            // open file chooser
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                afile = fileChooser.getSelectedFile();
                // This is where a real application would open the file.
                System.out.println("File Name=" + afile.getName());
                System.out.println("File Path=" + afile.getAbsoluteFile());
                FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
                selectADirectoryTextField.setText(FileIO.fileRead("selectedRoot.rotxt"));
            } else {
                System.out.println("Open command cancelled by user.");
            }

            if (afile != null) {
                FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
                String newPath = afile.getPath();
                updateUIComponents(newPath);
            }
        });
        attachButton.addActionListener(e -> {

        });
        viewButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    tree1.getLastSelectedPathComponent();

            if (node == null) return;

            Object nodeInfo = node.getUserObject();
            FileInfo info = (FileInfo) nodeInfo;
            if (isNotDirectoryCheck) {
                FileViewer.viewerRun(info.fullFilename);
            } else {
                System.out.println("gfk");
            }

        });
        exitButton.addActionListener(e -> System.exit(0));
        menuPanel.addComponentListener(new ComponentAdapter() {
        });
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        // Get the selected tree node (either file or folder)
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree1.getLastSelectedPathComponent();

        if (node == null) return;
        int commentCounter = 0;
        int fileNACount = 0;
        int fileFixedCount = 0;
        int fileNewCount = 0;

        Object nodeInfo = node.getUserObject();
        boolean DEBUG = true;
        FileInfo info = (FileInfo) nodeInfo;
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
            workingFile = info.fullFilename;
            System.out.println("Selected info=" + info.fullFilename + "  Dir: " + info.isDirectory);
            if (!info.isDirectory) {
                isNotDirectoryCheck = true;
            }
        }
        if (isNotDirectoryCheck) {
            String[] data = FileIO.fileRead(workingFile).split("\n");
            for (String line : data) {
                if (line.toLowerCase().startsWith("file:")) {
                    fileString.setText(line);
                    System.out.println("True");
                }
                if (line.toLowerCase().startsWith("author")) {
                    System.out.println("Author = True");
                    fileAuthor.setText(line);
                }
                if (line.toLowerCase().startsWith("w-number")) {
                    System.out.println("wNum = True");
                    fileWNumber.setText(line);
                }
                if (line.toLowerCase().startsWith("date reviewed last")) {
                    System.out.println("Last Date = True");
                    fileDateRevLast.setText(line);
                }
                if (line.toLowerCase().startsWith("date fixed last")) {
                    System.out.println("Last Fixed = True");
                    fileDateFixLast.setText(line);
                }
                if (line.endsWith("NEW")) {
                    fileNewCount = fileNewCount + 1;
                    commentCounter = commentCounter + 1;
                    fileNew.setText("Total NEW Comments: " + fileNewCount);

                }
                if (line.endsWith("F") || line.endsWith("FIXED")) {
                    fileFixedCount = fileFixedCount + 1;
                    commentCounter = commentCounter + 1;
                    fileFixed.setText("Total FIXED Comments: " + fileFixedCount);

                }
                if (line.endsWith("NA")) {
                    fileNACount = fileNACount + 1;
                    commentCounter = commentCounter + 1;
                    fileNA.setText("Total NA Comments: " + fileNACount);

                }
                if (line.endsWith("NEW") || line.endsWith("FIXED") || line.endsWith("F") || line.endsWith("NA")) {
//                    commentCounter = commentCounter + 1;
                    fileCommentList.setText("Total Comments: " + commentCounter);
                    if (fileNACount == 0) {
                        fileNA.setText("Total NA Comments: 0");
                    }
                    if (fileFixedCount == 0) {
                        fileFixed.setText("Total FIXED Comments: 0");
                    }
                    if (fileNewCount == 0) {
                        fileNew.setText("Total NEW Comments: 0");
                    }
                }
            }
        }
        if (node.toString().endsWith(".java") || !isNotDirectoryCheck) {
            fileString.setText("");
            fileAuthor.setText("");
            fileDateFixLast.setText("");
            fileDateRevLast.setText("");
            fileWNumber.setText("");
            fileCommentList.setText("");
            fileNA.setText("");
            fileNew.setText("");
            fileFixed.setText("");
        }
    }


    //The Following Commented out code is for parser testing.
//    public void valueChanged2() {
//        // Get the selected tree node (either file or folder)
//        int commentCounter = 0;
//        int fileNACount = 0;
//        int fileFixedCount = 0;
//        int fileNewCount = 0;
//            String[] data = FileIO.fileRead(workingFile).split("\n");
//            for (String line : data) {
//                if (line.toLowerCase().startsWith("file:")) {
//                    fileString.setText(line);
//                    System.out.println("True");
//                }
//                if (line.toLowerCase().startsWith("author")) {
//                    System.out.println("Author = True");
//                    fileAuthor.setText(line);
//                }
//                if (line.toLowerCase().startsWith("w-number")) {
//                    System.out.println("wNum = True");
//                    fileWNumber.setText(line);
//                }
//                if (line.toLowerCase().startsWith("date reviewed last")) {
//                    System.out.println("Last Date = True");
//                    fileDateRevLast.setText(line);
//                }
//                if (line.toLowerCase().startsWith("date fixed last")) {
//                    System.out.println("Last Fixed = True");
//                    fileDateFixLast.setText(line);
//                }
//                if (line.endsWith("NEW")) {
//                    fileNewCount = fileNewCount + 1;
//                    commentCounter = commentCounter + 1;
//                    fileNew.setText("Total NEW Comments: " + fileNewCount);
//
//                }
//                if (line.endsWith("F") || line.endsWith("FIXED")) {
//                    fileFixedCount = fileFixedCount + 1;
//                    commentCounter = commentCounter + 1;
//                    fileFixed.setText("Total FIXED Comments: " + fileFixedCount);
//
//                }
//                if (line.endsWith("NA")) {
//                    fileNACount = fileNACount + 1;
//                    commentCounter = commentCounter + 1;
//                    fileNA.setText("Total NA Comments: " + fileNACount);
//
//                }
//                if (line.endsWith("NEW") || line.endsWith("FIXED") || line.endsWith("F") || line.endsWith("NA")) {
////                    commentCounter = commentCounter + 1;
//                    fileCommentList.setText("Total Comments: "+ commentCounter);
//                    if (fileNACount == 0) {
//                        fileNA.setText("Total NA Comments: 0");
//                    }
//                    if (fileFixedCount == 0) {
//                        fileFixed.setText("Total FIXED Comments: 0");
//                    }
//                    if (fileNewCount == 0){
//                        fileNew.setText("Total NEW Comments: 0");
//                    }
//                }
//            }
//}

    public JLabel getFileString() {
        return fileString;
    }

    public JLabel getFileAuthor() {
        return fileAuthor;
    }

    public JLabel getFileWNumber() {
        return fileWNumber;
    }

    public JLabel getFileDateRevLast() {
        return fileDateRevLast;
    }

    public JLabel getFileDateFixLast() {
        return fileDateFixLast;
    }

    public JLabel getFileCommentList() {
        return fileCommentList;
    }

    public JLabel getFileNew() {
        return fileNew;
    }

    public JLabel getFileFixed() {
        return fileFixed;
    }

    public JLabel getFileNA() {
        return fileNA;
    }
}