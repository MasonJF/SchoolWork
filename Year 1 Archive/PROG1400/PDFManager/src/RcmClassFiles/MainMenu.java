package RcmClassFiles;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MainMenu implements TreeSelectionListener {
    JPanel menuPanel;
    private JButton searchButton;
    JTree tree1;
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
    private Path topDir = FileSystems.getDefault().getPath(FileIO.fileRead("selectedRoot.rotxt"));
    private DefaultMutableTreeNode top = new DefaultMutableTreeNode(topDir.getFileName().toString());
    private String query = ".pdf";

    private boolean isNotDirectoryCheck;
//    String browsePath = "/git/";

    // Create a file chooser
    private final JFileChooser fileChooser = new JFileChooser();
    //    private String workingFile;

    private void createUIComponents() {
        // Top root of tree
        Path topDir = FileSystems.getDefault().getPath(FileIO.fileRead("selectedRoot.rotxt"));
        //Create the nodes.
        DefaultMutableTreeNode top = new DefaultMutableTreeNode(topDir.getFileName().toString());
        createNodes(top, topDir, query);

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
        JLabel fileCommentList = new JLabel();
        JLabel fileNA = new JLabel();
        JLabel fileNew = new JLabel();
        JLabel fileFixed = new JLabel();
        previewPanel.add(fileString).setBounds(8, 8, 400,15);
        previewPanel.add(fileAuthor).setBounds(8, 25, 400, 15);
        previewPanel.add(fileDateFixLast).setBounds(8, 42, 400, 15);
        previewPanel.add(fileDateRevLast).setBounds(8, 59, 400, 15);
        previewPanel.add(fileWNumber).setBounds(8, 76, 400, 15);
        previewPanel.add(fileCommentList).setBounds(8, 93, 400, 15);
        previewPanel.add(fileNew).setBounds(300, 42, 400, 15);
        previewPanel.add(fileFixed).setBounds(300, 59, 400, 15);
        previewPanel.add(fileNA).setBounds(300, 76, 400, 15);

    }

    private String currentPath = FileIO.fileRead("selectedRoot.rotxt");
    private void updateUIComponents(final String newPath) {

        //Updates the tree within the panel.

        Path topDir = FileSystems.getDefault().getPath(newPath);
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Root: " + topDir.toString());
        createNodes(top, topDir, query);
        tree1.setModel(new DefaultTreeModel(top));
        currentPath = newPath;
    }

    void refreshFileStructure(){
        updateUIComponents(currentPath);
    }


    /**
     * Called recursively to populate the tree
     * @param nextTop The root node of this particular branch
     * @param nextDir The root directory of this particular branch
     * @param query The search parameter for the user.
     */
    private void createNodes(DefaultMutableTreeNode nextTop, Path nextDir, String query) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(nextDir)) {
            for (Path file: stream) {
                FileInfo fileInfo = new FileInfo(file);
                DefaultMutableTreeNode aNode = new DefaultMutableTreeNode(fileInfo );
                if(fileInfo.isDirectory){
                    nextTop.add(aNode);
                    createNodes(aNode, file, query);  // Recursively build the tree...a new folder here
                }
                if (aNode.toString().toLowerCase().endsWith(".pdf")) {
                    if (query != null){
                        if (aNode.toString().toLowerCase().contains(query)){
                            nextTop.add(aNode);
                        }
                    }else{
                            nextTop.add(aNode);
                    }
                }


            }
        } catch (IOException | DirectoryIteratorException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }


    private class FileInfo {

        Path file;
        String filename;
        String fullFilename;
        boolean isDirectory;



        FileInfo(Path file) {
            this.file = file;
            this.filename = file.getName(file.getNameCount()-1).toString();
            this.fullFilename = file.toString();    // file.getFileName().toString();
            this.isDirectory = Files.isDirectory(file);
        }

        public String toString() {
            return filename;
        }

    }

    private void searchQuery() {
        query = selectADirectoryTextField.getText();
        createNodes(top, topDir, query);
        updateUIComponents(currentPath);
    }

    MainMenu() {
        // Change this path to something on your C drive.
        Path dir = FileSystems.getDefault().getPath("/");
        System.out.println(dir);
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


        addButton.addActionListener(e -> Main.addFiles());


        searchButton.addActionListener(e -> {
            searchQuery();

//            JFrame frame = new JFrame();
//            fileChooser.setCurrentDirectory(new File("~/home/"));
//            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//            int returnVal = fileChooser.showOpenDialog(frame);
//
//            // handle to file to move
//            File afile = null;
//
//            // open file chooser
//            if (returnVal == JFileChooser.APPROVE_OPTION) {
//                afile = fileChooser.getSelectedFile();
//                // This is where a real application would open the file.
//                System.out.println("File Name=" + afile.getName());
//                System.out.println("File Path=" + afile.getAbsoluteFile());
//                FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
//                selectADirectoryTextField.setText(FileIO.fileRead("selectedRoot.rotxt"));
//            } else {
//                System.out.println("Open command cancelled by user.");
//            }
//
//            if (afile != null) {
//                FileIO.fileWrite(afile.getPath(), "selectedRoot.rotxt");
//                String newPath = afile.getPath();
//                updateUIComponents(newPath);
//            }
        });
        attachButton.addActionListener(e -> {

        });
        viewButton.addActionListener(e -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                    tree1.getLastSelectedPathComponent();

            if (node == null) return;

            Object nodeInfo = node.getUserObject();
            FileInfo info = (FileInfo)nodeInfo;
            if(isNotDirectoryCheck){
//                FileViewer.viewerRun(info.fullFilename);
                if(Desktop.isDesktopSupported()) {
                    File afile = new File(info.fullFilename);
                    try {
                        Desktop.getDesktop().open(afile);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }else{
                System.out.println("gfk");
            }

        });

        exitButton.addActionListener(e -> System.exit(0));

        menuPanel.addComponentListener(new ComponentAdapter() {
        });
        selectADirectoryTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                searchQuery();
            }
        });
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        int sizeModifier = 1024;
        // Get the selected tree node (either file or folder)
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                tree1.getLastSelectedPathComponent();

        if (node == null) return;
        Object nodeInfo = node.getUserObject();
        boolean DEBUG = true;
        FileInfo info = (FileInfo) nodeInfo;
        if (node.isLeaf()) {
            Path nodeMetaData = Paths.get(info.fullFilename);
            try {
                BasicFileAttributes leafInfo = Files.readAttributes(nodeMetaData, BasicFileAttributes.class);
                PDDocument document;
                document = PDDocument.load(new File(nodeMetaData.toString()), "");
                PDDocumentInformation pdfInfo = document.getDocumentInformation();
                fileDateRevLast.setText("Created on: "+leafInfo.creationTime().toString());
                fileDateFixLast.setText("Last Modified: "+leafInfo.lastModifiedTime().toString());
                fileString.setText("File Name: "+ info.filename);
                fileAuthor.setText("Author: "+ pdfInfo.getAuthor());
                fileWNumber.setText("File Size: "+leafInfo.size()/sizeModifier +"KB");
                if (pdfInfo.getAuthor() == null) {
                    fileAuthor.setText("Author: Unknown");
                }
                } catch (IOException ex) {
                    ex.printStackTrace();
                if (DEBUG) {
                    System.out.println("isLeaf = " + node.toString());
                }
            }
        } else {
            System.out.println("node = " + node.toString());
        }
        if (DEBUG) {
            // cast the node's Object to "FileInfo" to get data
            // This cast raises an exception if the top-most-node is selected....why?
//            workingFile = info.fullFilename;
            System.out.println("Selected info=" + info.fullFilename + "  Dir: " + info.isDirectory);
            if (!info.isDirectory) {
                isNotDirectoryCheck = true;
            }
        }
    }
    public JSplitPane getSplitPane1() {
        return splitPane1;
    }

    public void setSplitPane1(JSplitPane splitPane1) {
        this.splitPane1 = splitPane1;
    }

}