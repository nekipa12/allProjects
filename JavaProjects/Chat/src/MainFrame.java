import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import java.awt.FlowLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.Socket;
import java.util.Calendar;


public class MainFrame {

	private JFrame frame;
	private JTextField textField;
	private JMenuItem mntmConnect;
	private Connector connector;
	String nick;
	String ip;
	int port;
	boolean isServer;
	Server server;
	Client client;
	public static JTextArea textArea;
	private JButton btnSend;
	private Calendar calendar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
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
	public MainFrame() {
		initialize();
		calendar = Calendar.getInstance();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 686, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnConnection = new JMenu("Connection");
		menuBar.add(mnConnection);
		
		mntmConnect = new JMenuItem("Connect");
		mntmConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				connector = new Connector();
				connector.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				connector.setVisible(true); // висит здесь
				nick = connector.getNick();
				ip = connector.getIp();
				port = connector.getPort();
				isServer = connector.isServer();
//				JOptionPane.showMessageDialog(null, ip + " " + port);
				if(isServer) 
				{
					server = new Server(port);
					server.start();
					btnSend.setEnabled(false);
				}
				else
				{
					client = new Client(port, ip, nick);
					client.start();
				}
				
			}
		});
		mnConnection.add(mntmConnect);
		
		textArea = new JTextArea();
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Socket s = client.getSocket();
				int H = calendar.get(calendar.HOUR_OF_DAY);
				int M = calendar.get(calendar.MINUTE);
				String str = nick + " > " + H + ":" + M + " > " + textField.getText();
				//JOptionPane.showMessageDialog(null, str);
				SendThread st = new SendThread(s, str);
				Thread t = new Thread(st);
				t.start();
				textField.setText("");
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(249, Short.MAX_VALUE)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addGap(244))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(50)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE))
					.addGap(39))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(31)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(30))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
