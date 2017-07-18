import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAdmin {

	private JFrame frame;
	private JTextField textField;
	private JButton btnStopServer;
	private JButton btnStartServer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdmin window = new ViewAdmin();
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
	public ViewAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		btnStopServer = new JButton("Stop server");
		btnStopServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnStopServer.setEnabled(false);
				btnStartServer.setEnabled(true);
				Stop s = new Stop(textField.getText());
				Thread t = new Thread(s);
				t.start();
			}
		});
		
		textField = new JTextField();
		textField.setText("\u041D\u0430 \u0441\u0435\u0440\u0432\u0435\u0440\u0435 \u043F\u0440\u043E\u0432\u043E\u0434\u044F\u0442\u0441\u044F \u043F\u0440\u043E\u0444\u0438\u043B\u0430\u043A\u0442\u0438\u0447\u0435\u0441\u043A\u0438\u0435 \u0440\u0430\u0431\u043E\u0442\u044B!");
		textField.setColumns(10);
		
		JLabel lblMassoge = new JLabel("Massage");
		
		btnStartServer = new JButton("Start server");
		btnStartServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStopServer.setEnabled(true);
				btnStartServer.setEnabled(false);
				Start s = new Start();
				Thread t = new Thread(s);
				t.start();
			}
		});
		btnStartServer.setEnabled(false);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblMassoge))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(btnStopServer)
							.addGap(18)
							.addComponent(btnStartServer)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(73, Short.MAX_VALUE)
					.addComponent(lblMassoge)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(79)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStopServer)
						.addComponent(btnStartServer))
					.addGap(46))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
