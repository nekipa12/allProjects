package edu.shag.lesson17.whoWantsToBeMillionaire.view;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import edu.shag.lesson17.whoWantsToBeMillionaire.controller.Controller;
import edu.shag.lesson17.whoWantsToBeMillionaire.model.Question;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WhoWants {

	private JFrame frame;
	private JButton btn1;
	private JButton btn2;
	private JButton btn4;
	private JButton btn3;
	private Controller c;
	private Question q;
	private JLabel lblL;
	private JLabel score;
	private JButton btnHelp;
	private JButton btnCall;
	private JButton btn50;
	private JLabel label;
	private JLabel label1;

	
	public JLabel getScore() {
		return score;
	}

	public void setScore(JLabel score) {
		this.score = score;
	}

	public void start(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhoWants window = new WhoWants();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public WhoWants() {
		c = new Controller();
		q = new Question();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int H = (int) d.getHeight();
		int W = (int) d.getWidth();
		int width = 450;
		int height = 300;
		frame = new JFrame();
		frame.setBounds(W/2-(width/2), H/2-(height/2), width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblL = new JLabel("");
		lblL.setBounds(10, 11, 414, 38);
		frame.getContentPane().add(lblL);
		c.addLable(lblL);
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(281, 60, 46, 14);
		frame.getContentPane().add(lblScore);
		
		score = new JLabel("");
		score.setBounds(333, 60, 91, 14);
		frame.getContentPane().add(score);
		btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.incpection(btn1.getText(), score, lblL,btn1, btn2, btn3, btn4, btnHelp, btn50, btnCall, label, label1);
				//label.setText("");
				//label1.setText("");
			}
		});
		btn1.setBounds(10, 84, 120, 23);
		frame.getContentPane().add(btn1);
		
		btn2 = new JButton("");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.incpection(btn2.getText(), score, lblL,btn1, btn2, btn3, btn4, btnHelp, btn50, btnCall, label, label1);
				//label.setText("");
				//label1.setText("");
			}
		});
		btn2.setBounds(10, 118, 120, 23);
		frame.getContentPane().add(btn2);
		
		btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.incpection(btn4.getText(), score, lblL,btn1, btn2, btn3, btn4, btnHelp, btn50, btnCall, label, label1);
				//label.setText("");
				//label1.setText("");
			}
		});
		btn4.setBounds(150, 118, 120, 23);
		frame.getContentPane().add(btn4);
		
		btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.incpection(btn3.getText(), score, lblL,btn1, btn2, btn3, btn4, btnHelp, btn50, btnCall, label, label1);
				//label.setText("");
				//label1.setText("");
			}
		});
		btn3.setBounds(150, 84, 120, 23);
		frame.getContentPane().add(btn3);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		c.makeButton(btn1, btn2, btn3, btn4);
		
		btn50 = new JButton("50/50");
		btn50.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				c.fiftyFifity();
				btn50.setVisible(false);
			}
		});
		btn50.setBounds(260, 200, 65, 15);
		frame.getContentPane().add(btn50);
		label = new JLabel("");
		btnCall = new JButton("Call");
		btnCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label.setBounds(185, 172, 237, 16);
				frame.getContentPane().add(label);
				c.callFriend(label);
				btnCall.setVisible(false);
			}
		});
		btnCall.setBounds(185, 200, 65, 15);
		frame.getContentPane().add(btnCall);
		label1 = new JLabel("");
		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				label1.setBounds(15, 172, 237, 16);
				frame.getContentPane().add(label1);
				c.helpPeopple(label1);
				btnHelp.setVisible(false);
			}
		});
		btnHelp.setBounds(110, 200, 65, 15);
		frame.getContentPane().add(btnHelp);
		
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Exit");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		mnMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Help");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Привила игры на сайте " + "https://ru.wikipedia.org/ \n" + "Кто хочет стать миллионером " );
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Developer");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Разработчик: Андрей Валерьевич");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
	}
}
