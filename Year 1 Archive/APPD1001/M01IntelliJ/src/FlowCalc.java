import javax.swing.*;

public class FlowCalc {
    private JTextField textField2;
    private JTextField textField1;
    private JButton addButton;
    private JPanel ree;
    private JButton suboButton;
    private JButton divButton;
    private JButton mltpyButton;
    private JButton randyLayheeButton;
    private JTextField textField3;


    public static void main(String[] args){
        JFrame frame = new JFrame("Calc");
        frame.setContentPane(new FlowCalc().ree);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50,50);  //so it isn't at very top left
        frame.setVisible(true);
    }
}
