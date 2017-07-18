package edu.shag.lesson17.whoWantsToBeMillionaire.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import edu.shag.lesson17.whoWantsToBeMillionaire.model.Question;

public class Controller {
	
	private Question q = new Question();
	private int iter = 0;
	private ArrayList<JButton> al;
	
	public void incpection(String text, JLabel score, JLabel lblL, JButton btn1, JButton btn2, JButton btn3, JButton btn4, JButton btnHelp, JButton btn50, JButton btnCall, JLabel label, JLabel label1) {
		boolean s = q.getMap().values().iterator().next().get(text);
		for(JButton button : al){
			button.setVisible(true);
		}
		label.setText("");
		label1.setText("");
		if(s == true){
			if(iter > 9){
				return;
			}
			int t = q.getMoney()[iter];
			String g = Integer.toString(t);
			score.setText(g);
			if(iter == 9){
				for(JButton button : al){
					button.setVisible(false);
				}
				lblL.setVisible(false);
				btnHelp.setVisible(false);
				btn50.setVisible(false);
				btnCall.setVisible(false);
				String message = "Вы стали победителем, ваш выигрыш" + "\n" + score.getText();
				JOptionPane.showMessageDialog(null, message);
			}
			addLable(lblL);
			iter++;
			if(iter > 9)return;
			q.getMap().clear();
			q.addMap();
			addLable(lblL);
			makeButton(btn1, btn2, btn3, btn4);
		}else{
			score.setText("0");
			String message = "Вы не правильно ответили на вопрос" + "\n"+ "Ваш счёт : " + score.getText();
			for(JButton button : al){
				button.setVisible(false);
			}
			lblL.setVisible(false);
			btnHelp.setVisible(false);
			btn50.setVisible(false);
			btnCall.setVisible(false);
			JOptionPane.showMessageDialog(null, message);
		}
	}

	public void makeButton(JButton btn1, JButton btn2, JButton btn3, JButton btn4) {
		al = new ArrayList<>();
		al.add(btn1);
		al.add(btn2);
		al.add(btn3);
		al.add(btn4);
		int i = 0;
		String [] g = new String[4];
		for(HashMap<String, Boolean> pp : q.getMap().values()){
			for(String jj : pp.keySet()){
				g[i] = jj;
				i++;
			}
		}
		int j = 0;
		for(JButton b : al){
			b.setText(g[j]);
			j++;
		}
	}

	public void addLable(JLabel lblL) {
		lblL.setText(q.getMap().keySet().iterator().next().toString());
	}

	public void fiftyFifity() {
		int iterator = 0;
		boolean s;
		for(JButton but : al){
			s = q.getMap().values().iterator().next().get(but.getText());
			if(s == false){
				if(iterator == 2) break;
				but.setVisible(false);
				iterator++;
			}
		}
	}

	public void callFriend(JLabel label) {
		boolean s;
		String first = null;
		String second = null;
		for(JButton but : al){
			s = q.getMap().values().iterator().next().get(but.getText());
			if(s == false){
				second = but.getText();
			}else {
				first = but.getText();
			}
		}
		Random rnd = new Random();
		int random = rnd.nextInt(10);
		if(random <= 8){
			label.setText("Я думаю что ответ - " + first);
		}else if (random > 8){
			label.setText("Я думаю что ответ - " + second);
		}
		
	}
	public void helpPeopple(JLabel label) {
		boolean s;
		String first = null;
		String second = null;
		for(JButton but : al){
			s = q.getMap().values().iterator().next().get(but.getText());
			if(s == false){
				second = but.getText();
			}else {
				first = but.getText();
			}
		}
		Random rnd = new Random();
		int random = rnd.nextInt(10);
		if(random <= 8){
			label.setText("Зал думает что ответ - " + first);
		}else if (random > 8){
			label.setText("Зал думает что ответ - " + second);
		}
		
	}
}
