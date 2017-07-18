package edu.shag.rmiClient;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ButtonGroup;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class Client {

	private JFrame frame;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JButton btnConvert;
	private JRadioButton rbUSD;
	private JRadioButton rbUAH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSum = new JLabel("Sum");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblChoose = new JLabel("Choose");
		
		rbUSD = new JRadioButton("USD-UAH");
		rbUSD.setSelected(true);
		buttonGroup.add(rbUSD);
		
		rbUAH = new JRadioButton("UAH-USD");
		buttonGroup.add(rbUAH);
		
		btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Calc aCalc = (Calc)Naming.lookup("rmi://127.0.0.1/CalcService");
					int amount = Integer.parseInt(textField.getText());
					int res = 0;
					if(rbUSD.isSelected()){
						res = (int) aCalc.USDtoUAH(amount);
					}else if(rbUAH.isSelected()){
						res = (int) aCalc.UAHtoUSD(amount);
					}
					JOptionPane.showMessageDialog(null,"" + res);
					JOptionPane.showMessageDialog(null, String.valueOf(res));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (NotBoundException e1) {
					e1.printStackTrace();
				}
					
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblSum)
							.addGap(28)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblChoose)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(rbUAH)
								.addComponent(rbUSD)
								.addComponent(btnConvert))))
					.addContainerGap(248, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(64)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSum)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChoose)
						.addComponent(rbUSD))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(rbUAH)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(btnConvert)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
