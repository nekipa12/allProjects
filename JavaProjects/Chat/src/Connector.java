import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;


public class Connector extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField tfNick;
	private JRadioButton rdbtnClient;
	private JTextField tfIP;
	private JTextField tfPort;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	
	String nick;
	String ip;
	int port;
	boolean isServer;
	private JRadioButton rdbtnServer;
	private JButton okButton;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Connector dialog = new Connector();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	public int getPort() {
		return port;
	}

	public boolean isServer() {
		return isServer;
	}

	/**
	 * Create the dialog.
	 */
	public Connector() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(100, 100, 450, 419);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			rdbtnClient = new JRadioButton("Client");
			rdbtnClient.setSelected(true);
			buttonGroup_1.add(rdbtnClient);
			rdbtnClient.setBounds(143, 76, 161, 23);
			contentPanel.add(rdbtnClient);
		}
		{
			tfNick = new JTextField();
			tfNick.setText("Anton");
			tfNick.setBounds(143, 141, 142, 20);
			contentPanel.add(tfNick);
			tfNick.setColumns(10);
		}
		{
			tfIP = new JTextField();
			tfIP.setBounds(143, 172, 142, 20);
			contentPanel.add(tfIP);
			tfIP.setColumns(10);
			tfIP.setText("localhost");
		}
		{
			tfPort = new JTextField();
			tfPort.setText("6799");
			tfPort.setBounds(143, 221, 142, 20);
			contentPanel.add(tfPort);
			tfPort.setColumns(10);
		}
		
		rdbtnServer = new JRadioButton("Server");
		buttonGroup_1.add(rdbtnServer);
		rdbtnServer.setBounds(143, 0, 200, 50);
		contentPanel.add(rdbtnServer);
		
		JLabel lblNick = new JLabel("NICK");
		lblNick.setBounds(49, 144, 46, 14);
		contentPanel.add(lblNick);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setBounds(49, 175, 46, 14);
		contentPanel.add(lblIp);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(49, 224, 46, 14);
		contentPanel.add(lblPort);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this); 
					
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource().equals(okButton))
		{
			nick = tfNick.getText();
			ip = tfIP.getText();
			port = Integer.parseInt(tfPort.getText());
			isServer = rdbtnServer.isSelected();
			this.setVisible(false);
		}
	}
}
