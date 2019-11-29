import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class Calc {
    private JPanel Calc;
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton randomButton;
    private JTextField textField3;

    public Calc() {
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                String answer = Double.toString(num1 + num2);
                textField3.setText(answer);
            }
        });
        subtractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                String answer = Double.toString(num1 - num2);
                textField3.setText(answer);
            }
        });
        multiplyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                String answer = Double.toString(num1 * num2);
                textField3.setText(answer);
            }
        });
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num1 = Double.parseDouble(textField1.getText());
                double num2 = Double.parseDouble(textField2.getText());
                String answer = Double.toString(num1 / num2);
                textField3.setText(answer);
            }
        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent i) {
                textField1.setText(Integer.toString(ThreadLocalRandom.current().nextInt(0, 100 + 1)));
                textField2.setText(Integer.toString(ThreadLocalRandom.current().nextInt(0, 100 + 1)));
            }
        });
    }

    public static void main(String[] args){
        JFrame frame = new JFrame("Calc");
        frame.setContentPane(new Calc().Calc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocation(50,50);  //so it isn't at very top left
        frame.setVisible(true);
    }
}

