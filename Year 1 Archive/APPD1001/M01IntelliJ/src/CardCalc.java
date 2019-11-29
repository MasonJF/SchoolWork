import javax.swing.*;

public class CardCalc {
    private JPanel REEEEEE;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JButton divButton;
    private JButton subButton;
    private JButton mltiButton;
    private JButton THISISTHECARDButton;
    private JTextField textField3;


    public static void main(String[] args){
        JFrame frame = new JFrame("Calc");
        frame.setContentPane(new CardCalc().REEEEEE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50,50);  //so it isn't at very top left
        frame.setVisible(true);
    }
}
