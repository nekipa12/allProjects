import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;


public class MainFrame {

	private JFrame frame;
	private JTextField tFThree;
	private JTextField tFFrom;
	private JTextField tFTwo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rBPlac;
	private JRadioButton rBCoup;
	private JRadioButton rBSV;
	private JRadioButton rBInt;
	private JCheckBox cBPostel;
	private JCheckBox cBTea;
	private JButton btnPrice;
	private JLabel lB;
	private JButton btnTest;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmExit;
	private JMenu mnAbout;
	private JMenuItem mntmHelp;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//ставит наше окно в отдельном треде в очередь обработки событий
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);// если показать объект, фолс чтобы скрыть окно
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*String xy = e.getX() + ":" + e.getY();
				JOptionPane.showMessageDialog(null, xy);*/
			
			}
		});
		frame.getContentPane().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				e.getKeyChar();
			}
		});
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int H = (int) d.getHeight();
		int W = (int) d.getWidth();
		frame.setBounds(W/2-150/2, H/2-100/2, 350, 400);//задаёт позицию и размеры окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(frame.getContentPane(), popupMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		popupMenu.add(mntmNewMenuItem_2);
		
		tFFrom = new JTextField();
		tFFrom.setBounds(73, 39, 86, 20);
		frame.getContentPane().add(tFFrom);
		tFFrom.setColumns(10);
		
		JLabel lblFrom = new JLabel("from");
		lblFrom.setBounds(17, 42, 46, 14);
		frame.getContentPane().add(lblFrom);
		
		JLabel label = new JLabel("-");
		label.setBounds(164, 42, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setBounds(169, 42, 46, 14);
		frame.getContentPane().add(lblTo);
		
		tFTwo = new JTextField();
		tFTwo.setBounds(179, 39, 86, 20);
		frame.getContentPane().add(tFTwo);
		tFTwo.setColumns(10);
		
		JLabel lblData = new JLabel("data");
		lblData.setBounds(17, 67, 46, 14);
		frame.getContentPane().add(lblData);
		
		tFThree = new JTextField();
		tFThree.setBounds(73, 70, 86, 20);
		frame.getContentPane().add(tFThree);
		tFThree.setColumns(10);
		
		JLabel lblTypeOfTrain = new JLabel("type of train");
		lblTypeOfTrain.setBounds(17, 117, 70, 14);
		frame.getContentPane().add(lblTypeOfTrain);
		
		rBPlac = new JRadioButton("plac");
		buttonGroup.add(rBPlac);
		rBPlac.setBounds(102, 105, 57, 38);
		frame.getContentPane().add(rBPlac);
		
		rBCoup = new JRadioButton("Coup");
		buttonGroup.add(rBCoup);
		rBCoup.setSelected(true);
		rBCoup.setBounds(159, 99, 60, 50);
		frame.getContentPane().add(rBCoup);
		
		rBSV = new JRadioButton("SV");
		buttonGroup.add(rBSV);
		rBSV.setBounds(221, 99, 56, 50);
		frame.getContentPane().add(rBSV);
		
		rBInt = new JRadioButton("Int+");
		buttonGroup.add(rBInt);
		rBInt.setBounds(279, 105, 57, 38);
		frame.getContentPane().add(rBInt);
		
		cBTea = new JCheckBox("tea");
		cBTea.setSelected(true);
		cBTea.setBounds(150, 152, 46, 32);
		frame.getContentPane().add(cBTea);
		
		cBPostel = new JCheckBox("Postel");
		cBPostel.setSelected(true);
		cBPostel.setBounds(73, 149, 75, 38);
		frame.getContentPane().add(cBPostel);
		
		JLabel lblServis = new JLabel("Servis");
		lblServis.setBounds(17, 161, 46, 14);
		frame.getContentPane().add(lblServis);
		
		btnPrice = new JButton("Price");
		btnPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] conditions = new String [3];
				conditions[0] = tFFrom.getText();
				conditions[1] = tFTwo.getText();
				conditions[2] = tFThree.getText();
				for(int i = 0; i < conditions.length; i++){
					if(conditions[i].equals("") || conditions[i] == null){
						JOptionPane.showMessageDialog(null, "all conditions must be filed in");
						return;
					}
				}
				
				double price = 0;
				String wagon = null;
				
				if(rBPlac.isSelected()){
					wagon = "plac";
					price +=150;
				}else if(rBCoup.isSelected()){
					wagon = "coup ";
					price += 250;
				}else if(rBSV.isSelected()){
					wagon = "sv";
					price += 350;
				}else if(rBInt.isSelected()){
					wagon = "int+";
					price += 450;
				}
				String tea = null;
				if(cBTea.isSelected()){
					tea = "with tea ";
					price += 10;
				}
				String bed = null;
				if(cBPostel.isSelected()){
					bed = "with bed linen";
					price += 30;
				}
				
				String res = "<html>Your chouse is \n" + conditions[0] + " - " + conditions[1] + " on " +
						"wagon is " + wagon;
				if(tea != null){
					res += tea;
				}
				if(bed != null){
					res +=bed;
				}
				res += "<br>" + "the price is " + price + "</html>";
				
				//JOptionPane.showMessageDialog(null, res);//диалоговое окно
				lB.setText(res);
				lB.setVisible(true);
			}
		});
		btnPrice.setBounds(37, 216, 91, 23);
		frame.getContentPane().add(btnPrice);
		
		lB = new JLabel("");
		lB.setBounds(138, 196, 198, 66);
		frame.getContentPane().add(lB);
		
		btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int choose = JOptionPane.showConfirmDialog(null, "Question");
				if(choose == JOptionPane.YES_OPTION){
					JOptionPane.showMessageDialog(null, "YES");
				}*/
				String res = JOptionPane.showInputDialog(null, "Ask input some text");
				JOptionPane.showMessageDialog(null, res);
			}
		});
		btnTest.setBounds(37, 239, 91, 23);
		frame.getContentPane().add(btnTest);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Save");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();//можем показывать опен диалог или  сейв диалог
				int returnVal = chooser.showSaveDialog(null);
				String file = null;
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = chooser.getSelectedFile().getAbsolutePath();
					PrintWriter pw = null;
					try {
						pw = new PrintWriter(new FileOutputStream(file));
						pw.write(lB.getText());
						pw.flush();
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally{
						
						pw.close();
					
					}
				}
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();//можем показывать опен диалог или  сейв диалог
				int returnVal = chooser.showSaveDialog(null);
				String file = null;
				if(returnVal == JFileChooser.APPROVE_OPTION){
					file = chooser.getSelectedFile().getAbsolutePath();
					try {
						Scanner sc = new Scanner(new File(file));
						String fromFile = "";
						while(sc.hasNextLine()){
							fromFile +=sc.nextLine();
						}
						sc.close();
						lB.setText(fromFile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();//закрывает программу
			}
		});
		mnNewMenu.add(mntmExit);
		
		mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
		//JFrame.DISPOSE_ON_CLOSE// закрывать текущее окно
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
