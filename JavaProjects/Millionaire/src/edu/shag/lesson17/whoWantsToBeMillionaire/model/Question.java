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
			f0.put("голова", false);
			f0.put("плед", false);
			f0.put("хлеб", true);
			f0.put("грек", false);
			map.put("...всему голова", f0);
			iterator++;
		}else if(iterator == 1){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("без удки", false);
			f1.put("без балды", false);
			f1.put("без еды", false);
			f1.put("без труда", true);
			map.put("...не выловишь рыбку из пруда", f1);
			iterator++;
		}else if(iterator == 2){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("кислород", false);
			f1.put("ртуть", false);
			f1.put("золото", false);
			f1.put("водород", true);
			map.put("Первый элемент таблицы менделеева", f1);
			iterator++;
		}else if(iterator == 3){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("Трамп", true);
			f1.put("Обама", false);
			f1.put("Кенеди", false);
			f1.put("Линкольн", false);
			map.put("Президент США 2017", f1);
			iterator++;
		}else if(iterator == 4){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("Запорожье", false);
			f1.put("Киев", true);
			f1.put("Кобыляки", false);
			f1.put("Ужгород", false);
			map.put("Столица украины", f1);
			iterator++;
		}else if(iterator == 5){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("ОЗУ", false);
			f1.put("Процессор", true);
			f1.put("ЖД", false);
			f1.put("БП", false);
			map.put("Мозг компьютера", f1);
			iterator++;
		}else if(iterator == 6){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("Йоркшир", false);
			f1.put("Ливерпуль", false);
			f1.put("Уэльс", false);
			f1.put("Лондон", true);
			map.put("Столица Великобритании", f1);
			iterator++;
		}else if(iterator == 7){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("китайский доллар", false);
			f1.put("донг", false);
			f1.put("юань", true);
			f1.put("фунт", false);
			map.put("Национальная валюта китая", f1);
			iterator++;
		}else if(iterator == 8){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("short", true);
			f1.put("int", false);
			f1.put("byte", false);
			f1.put("long", false);
			map.put("Целочисленная переменная 2 байта", f1);
			iterator++;
		}else if(iterator == 9){
			HashMap<String, Boolean> f1 = new HashMap<>();
			f1.put("Днепр", false);
			f1.put("Нил", true);
			f1.put("Амазонка", false);
			f1.put("Днестр", false);
			map.put("Самая длинная река в мире", f1);
			iterator++;
		}
	}
}
