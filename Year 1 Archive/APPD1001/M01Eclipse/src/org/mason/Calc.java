package org.mason;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.JToggleButton;
import java.util.concurrent.ThreadLocalRandom;

public class Calc extends JFrame {

	private JPanel contentPane;
	private JTextField textField_num1;
	private JTextField textField_num2;
	private JTextField textField_ans;
	private JButton btnMultiply;
	private JButton btnDivide;
	private JButton btnRand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc frame = new Calc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_num1 = new JTextField();
		textField_num1.setBounds(24, 55, 124, 19);
		contentPane.add(textField_num1);
		textField_num1.setColumns(10);
		
		textField_num2 = new JTextField();
		textField_num2.setBounds(304, 55, 124, 19);
		contentPane.add(textField_num2);
		textField_num2.setColumns(10);
		
		textField_ans = new JTextField();
		textField_ans.setBounds(88, 193, 216, 25);
		contentPane.add(textField_ans);
		textField_ans.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double num1=  Double.parseDouble(textField_num1.getText());
				double num2=  Double.parseDouble(textField_num2.getText());
				String answer = Double.toString(num1 + num2);
				textField_ans.setText(answer);
			}
		});
		btnAdd.setBounds(168, 12, 114, 25);
		contentPane.add(btnAdd);
		
		JButton btnSubtract = new JButton("SUBTRACT");
		btnSubtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent j) {
				double num1=  Double.parseDouble(textField_num1.getText());
				double num2=  Double.parseDouble(textField_num2.getText());
				String answer = Double.toString(num1 - num2);
				textField_ans.setText(answer);
			}
		});
		btnSubtract.setBounds(168, 49, 114, 25);
		contentPane.add(btnSubtract);
		
		btnMultiply = new JButton("MULTIPLY");
		btnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent g) {
				double num1=  Double.parseDouble(textField_num1.getText());
				double num2=  Double.parseDouble(textField_num2.getText());
				String answer = Double.toString(num1 * num2);
				textField_ans.setText(answer);
			}
		});
		btnMultiply.setBounds(168, 86, 114, 25);
		contentPane.add(btnMultiply);
		
		btnDivide = new JButton("DIVIDE");
		btnDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent h) {
				double num1=  Double.parseDouble(textField_num1.getText());
				double num2=  Double.parseDouble(textField_num2.getText());
				String answer = Double.toString(num1 / num2);
				textField_ans.setText(answer);
			}
		});
		btnDivide.setBounds(168, 123, 114, 25);
		contentPane.add(btnDivide);
		
		btnRand = new JButton("RANDOM");
		btnRand.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent i) {
				textField_num1.setText(Double.toString(ThreadLocalRandom.current().nextDouble(0, 100 + 1)));
				textField_num2.setText(Double.toString(ThreadLocalRandom.current().nextDouble(0, 100 + 1)));
			}
		});
		btnRand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRand.setBounds(168, 156, 114, 25);
		contentPane.add(btnRand);
	}
}
