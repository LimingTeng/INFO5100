import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorTeng extends JFrame implements ActionListener {
  
	private JPanel panel;
	private JPanel panel2;
	private JTextField display1;
	private JTextField display2;
	private JButton[] buttons;
	private Font font;
	private String[] labels = { 
			"Backspace", "", "", "CE", "C",
			"7", "8", "9", "/", "sqrt",
			"4", "5", "6", "x", "%",
			"1", "2", "3", "-", "1/x",
			"0", "+/-", ".", "+", "=",
	};

	private double result = 0;
	private String operator = "=";
	private boolean startOfNumber = true;
	public CalculatorTeng() {
		font = new Font("TimesRoman", Font.BOLD, 30);
		display1 = new JTextField(35);
		display2 = new JTextField(35);
		panel = new JPanel();
		panel2 = new JPanel();
		display1.setText("0.0");
		display2.setText("0.0");
		panel.setLayout(new GridLayout(0, 5, 3, 3));
		panel2.setLayout(new GridLayout(0, 2));
		buttons = new JButton[25];
		int index = 0;
		panel2.add(display1);
		panel2.add(display2);
		for (int rows = 0; rows < 5; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				buttons[index] = new JButton(labels[index]);
				buttons[index].setForeground(Color.blue);
				buttons[index].setBackground(Color.yellow);
				buttons[index].setFont(font);
				panel.add(buttons[index]);
				buttons[index].addActionListener(this);
				index++;
			}
		}
		add(panel2, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		setVisible(true);
		pack();
	}
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.charAt(0) == 'C') {
			startOfNumber = true;
			result = 0;
			operator = "=";
			display1.setText("0.0");
			display2.setText("0.0");
		} else if (command.charAt(0) >= '0' && command.charAt(0) <= '9'
				|| command.equals(".")) {
			if (startOfNumber == true) {
				display1.setText(command);
				display2.setText(display2.getText() + command);
			}
			else {
				display1.setText(display1.getText() + command);
				display2.setText(display2.getText() + command);
			}
			startOfNumber = false;
		} else {
			if (startOfNumber) {
				if (command.equals("-")) {
					display1.setText(command);
					display2.setText(command);
					startOfNumber = false;
				} else 
					operator = command;
			} else {
				double x = Double.parseDouble(display1.getText());
				display2.setText(display2.getText() + command);
				calculate(x);
				operator = command;
				startOfNumber = true;
			}
		}
	}
	private void calculate(double n) { 
	if (operator.equals("+"))
		result += n;
	else if (operator.equals("-"))
		result -= n;
	else if (operator.equals("x"))
		result *= n;
	else if (operator.equals("/"))
		result /= n;
	else if (operator.equals("="))
		result = n;
	display1.setText("" + result);
	}

	public static void main(String args[]) {
	CalculatorTeng s = new CalculatorTeng();
	s.setTitle("Calculator_LimingTeng");
	}
}

