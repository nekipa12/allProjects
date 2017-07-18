package edu.shag.lesson17.whoWantsToBeMillionaire.model;

import java.util.HashMap;

public class Question {
	
	private HashMap<String, HashMap<String, Boolean>> map;
	private int [] money;
	private int iterator = 0;
	
	public HashMap<String, HashMap<String, Boolean>> getMap() {
		return map;
	}

	public void setMap(HashMap<String, HashMap<String, Boolean>> map) {
		this.map = map;
	}

	public int[] getMoney() {
		return money;
	}

	public Question() {
		map = new HashMap<>();
		addMap();
		money = new int[10];
		addMoney();
	}

	private void addMoney() {
		money[0] = 100;
		money[1] = 200;
		money[2] = 300;
		money[3] = 500;
		money[4] = 1000;
		money[5] = 2000;
		money[6] = 4000;
		money[7] = 8000;
		money[8] = 16000;
		money[9] = 32000;
	}

	public void addMap(){
		if(iterator == 0){
			HashMap<String, Boolean> f0 = new HashMap<>();
			f0.put("������", false);
			f0.put("����", false);
			f0.put("����", true);
			f0.put("����", false);
			map.put("...����� ������", f0);
			iterator++;
		}else if(iterator == 1){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("��� ����", false);
			f1.put("��� �����", false);
			f1.put("��� ���", false);
			f1.put("��� �����", true);
			map.put("...�� �������� ����� �� �����", f1);
			iterator++;
		}else if(iterator == 2){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("��������", false);
			f1.put("�����", false);
			f1.put("������", false);
			f1.put("�������", true);
			map.put("������ ������� ������� ����������", f1);
			iterator++;
		}else if(iterator == 3){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("�����", true);
			f1.put("�����", false);
			f1.put("������", false);
			f1.put("��������", false);
			map.put("��������� ��� 2017", f1);
			iterator++;
		}else if(iterator == 4){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("���������", false);
			f1.put("����", true);
			f1.put("��������", false);
			f1.put("�������", false);
			map.put("������� �������", f1);
			iterator++;
		}else if(iterator == 5){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("���", false);
			f1.put("���������", true);
			f1.put("��", false);
			f1.put("��", false);
			map.put("���� ����������", f1);
			iterator++;
		}else if(iterator == 6){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("�������", false);
			f1.put("���������", false);
			f1.put("�����", false);
			f1.put("������", true);
			map.put("������� ��������������", f1);
			iterator++;
		}else if(iterator == 7){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("��������� ������", false);
			f1.put("����", false);
			f1.put("����", true);
			f1.put("����", false);
			map.put("������������ ������ �����", f1);
			iterator++;
		}else if(iterator == 8){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("short", true);
			f1.put("int", false);
			f1.put("byte", false);
			f1.put("long", false);
			map.put("������������� ���������� 2 �����", f1);
			iterator++;
		}else if(iterator == 9){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("�����", false);
			f1.put("���", true);
			f1.put("��������", false);
			f1.put("������", false);
			map.put("����� ������� ���� � ����", f1);
			iterator++;
		}
	}
}
