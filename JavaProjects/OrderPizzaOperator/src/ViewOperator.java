import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipFile;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JLabel;

public class ViewOperator {

	private JFrame frame;
	private JMenuItem mntmConnect;
	private Operator op;
	public static DefaultListModel dlm;
	private JList list;
	private JLabel lblOrders;
	private ArrayList<String> al;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewOperator window = new ViewOperator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewOperator() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					PrintWriter pw = new PrintWriter(op.getS().getOutputStream());
					pw.write("end" + "\n");
					pw.flush();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				/*try {
					op.getS().close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
				frame.dispose();
				//return;
			}
		});
		mntmExit.setHorizontalAlignment(SwingConstants.CENTER);
		mnNewMenu.add(mntmExit);
		
		JMenu mnConnnect = new JMenu("Connnection");
		
		menuBar.add(mnConnnect);
		
		mntmConnect = new JMenuItem("Connect");
		mntmConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				op = new Operator();
				op.start();
				for(String str : op.getGson()){
					Gson json = new Gson();
					Type type = new TypeToken<ArrayList<String>>(){}.getType();
					al = new ArrayList<>();
					al = json.fromJson(str, type);
					dlm.addElement(al.get(1));
				}
				list.setVisible(true);
				lblOrders.setVisible(true);
				
			}
		});
		mnConnnect.add(mntmConnect);
		dlm = new DefaultListModel();
		list = new JList(dlm);
		list.setVisible(false);
		lblOrders = new JLabel("Orders");
		lblOrders.setVisible(false);
		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(list.getSelectedIndex() >= 0){
					Socket s = op.getS();
					String h = Integer.toString(list.getSelectedIndex());
					SendThread st = new SendThread(s, h);
					Thread t = new Thread(st);
					t.start();
					ValidationDialog vd = new ValidationDialog(op.getGson().get(Integer.parseInt(h)));
					vd.start();
					vd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					vd.setVisible(true);
					vd.dispose();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOrders)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(293, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(lblOrders)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		
	}
}
