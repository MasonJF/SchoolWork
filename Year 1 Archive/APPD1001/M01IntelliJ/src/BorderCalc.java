import javax.swing.*;

public class BorderCalc {
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JButton subButton;
    private JButton multiButton;
    private JButton divButton;
    private JButton randoButton;
    private JTextField textField3;
    private JPanel bordercalc;


    public static void main(String[] args){
        JFrame frame = new JFrame("Calc");
        frame.setContentPane(new BorderCalc().bordercalc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50,50);  //so it isn't at very top left
        frame.setVisible(true);
    }
}

