
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

public class ViewClient {

	private JFrame frame;
	private Registrator reg;
	private String name;
	private String lastName;
	private String phoneNumber;
	private String city;
	private String email;
	private Client c;
	private JComboBox comboBox;
	private Socket s;
	private int idx;
	private JButton btnNewButton;
	private JButton btAddToCart;
	private JLabel lbPizza;
	private Basket b;
	private ArrayList<String []> alsa;
	private JButton btnOpenCart;
	
	
	
	public ArrayList<String[]> getAlsa() {
		return alsa;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewClient window = new ViewClient();
					window.frame.setVisible(true);
					 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ViewClient() {
		initialize();
	}
	private void initialize() {
		reg = new Registrator();
		alsa = new ArrayList<>();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				reg.dispose();
				PrintWriter pw;
				try {
					pw = new PrintWriter(Client.s.getOutputStream());
					pw.write("end" + "\n");
					pw.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		mnMenu.add(mntmExit);
		JMenu mnNewMenu = new JMenu("Registr");
		menuBar.add(mnNewMenu);
		comboBox = new JComboBox();
		comboBox.setBounds(66, 40, 229, 20);
		frame.getContentPane().add(comboBox);
		JMenuItem mntmRegistration = new JMenuItem("Registration");
		mntmRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reg.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				reg.setVisible(true);
				name = reg.getName();
				lastName = reg.getLastName();
				phoneNumber = reg.getPhoneNumber();
				email = reg.getEmail();
				city = reg.getCity();
				ArrayList<String> g = new ArrayList<>();
				g.add(name);
				g.add(lastName);
				g.add(phoneNumber);
				g.add(city);
				g.add(email);
				c = new Client(g, frame);
				c.start();
				c.addName(comboBox);
				lbPizza.setVisible(true);
				comboBox.setVisible(true);
				btAddToCart.setVisible(true);
				btnNewButton.setVisible(true);
				btnOpenCart.setVisible(true);
				b = new Basket(g);
			}
		});
		mnNewMenu.add(mntmRegistration);
		frame.getContentPane().setLayout(null);
		comboBox.setVisible(false);	
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idx = comboBox.getSelectedIndex();
			}
		});
		btAddToCart = new JButton("Add to cart");
		btAddToCart.setVisible(false);
		btAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name = comboBox.getItemAt(idx).toString();
				String [] values = name.split(" ");
				b.addArray(values);
			}
		});
		btAddToCart.setBounds(186, 70, 110, 23);
		frame.getContentPane().add(btAddToCart);
		btnNewButton = new JButton("Learn More");
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s = c.getS();
				RequestForHTML rfhtml = new RequestForHTML(s, idx);
				Thread t = new Thread(rfhtml);
				t.start();
				
			}
		});
		btnNewButton.setBounds(66, 70, 110, 23);
		frame.getContentPane().add(btnNewButton);
		
		lbPizza = new JLabel("Pizza");
		lbPizza.setVisible(false);
		lbPizza.setBounds(22, 43, 34, 14);
		frame.getContentPane().add(lbPizza);
		
		btnOpenCart = new JButton("Open cart");
		btnOpenCart.setVisible(false);
		
		btnOpenCart.addActionListener(new ActionListener() {
			int count = 0;
			public void actionPerformed(ActionEvent e) {
				if(count == 0){
					b.basket(s);
					count++;
				}
				b.addIn();
				b.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				b.setVisible(true);
				alsa.clear();
			}
		});
		btnOpenCart.setBounds(66, 167, 110, 23);
		frame.getContentPane().add(btnOpenCart);
	}
}
