import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Cal {
	public static void main(String [] args) {
		JPanel windowContent = new JPanel();
		FlowLayout fl = new FlowLayout();
		windowContent.setLayout(fl);
		JLabel lable1 = new JLabel("Цифру 1: ");
		JTextField field1 = new JTextField(10);
		JLabel lable2 = new JLabel("Цифру 2: ");
		JTextField field2 = new JTextField(10);
		JLabel lable3 = new JLabel("сумма ");
		JTextField result = new JTextField(10);
		JButton go = new JButton("add");
		
		windowContent.add(lable1);
		windowContent.add(field1);
		windowContent.add(lable2);
		windowContent.add(field2);
		windowContent.add(lable3);
		windowContent.add(result);
		windowContent.add(go);
		
		JFrame frame = new JFrame("Calculator");
		
		frame.setContentPane(windowContent);
		frame.setSize(400, 100);
		frame.setVisible(true);
	}
}
