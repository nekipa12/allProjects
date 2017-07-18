package edu.shag.lesson13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Collectionss {

	public static void main(String[] args) {
		
		//non generic collections
		/*ArrayList myList = new ArrayList();
		myList.add(20);
		myList.add("200");
		myList.add(2.5);
		
		for(int i = 0; i<myList.size();i++){
			
			//System.out.println(myList.get(i));
		}
		//generic  collections
		
		ArrayList<Integer /*любой тип но не обджект*///> aL = new ArrayList<>(10); //если использовать списочный массив без 
																				//аргументов то по умолчанию он будет равен 4 €чейки
		/*aL.add(5); aL.add(-5); aL.add(55);
		aL.set(1, -555);
		aL.add(2, 300);
		for(Integer i : aL){
			
			System.out.println(i);
		}
		
		System.out.println();
		Collections.sort(aL);
		for(Integer i : aL){
			
			System.out.println(i);
		}
		
		/*System.out.println();
		Collections.shuffle(aL);
		for(Integer i : aL){
			
			System.out.println(i);
		}*/
		/*
		System.out.println();
		Collections.swap(aL, 0, 2);
		for(Integer i : aL){
			
			System.out.println(i);
		}*/
		
		/*System.out.println();
		Collections.reverse(aL);
		for(Integer i : aL){
			
			System.out.println(i);
		}
		
		System.out.println();
		aL.remove(1);
		for(Integer i : aL){
			
			System.out.println(i);
		}
		
		if(aL.contains(300)) System.out.println("+");
		
		System.out.println(aL.indexOf(300));
		System.out.println();
		Integer[] myArr = aL.toArray(new Integer[0]);//передать пустой массив того же типа который в коллекции
		for(int i =0; i<myArr.length; i++) System.out.println(myArr[i]);
		*/
		
		//Vector v = new Vector();//безопасна€ коллекци€= €дра не лезут одновременно в коллекцию
		/*v.add(20);
		v.add(300);
		System.out.println(v.get(0)); System.out.println(v.get(1));
		
		ArrayList<?> aL2;
		aL2 = new ArrayList<Integer>(10);*/
		
		
		
		
		
		/*LinkedList<String> ll = new LinkedList<>();
		ll.add("Hello");
		ll.add("Hello");
		ll.add("Hello");
		ll.addFirst("1");
		ll.addLast("!");
		ll.addFirst("123");
		
		ListIterator<String> it = ll.listIterator();
		//ll.add("fsd"); нужно создавать итератор только перед его использованием!!!
		while(it.hasNext()){
			String s = it.next();
			if(s.equals("Hello")) it.set("No hello");
		}
		
		while(it.hasPrevious()){
			System.out.println(it.previous());
		}
		
		for(String s : ll){
			System.out.println(s);
		}
		while(it.hasNext()){
			String s = it.next();
			if(s.equals("No hello")) it.remove();
		}
		for(String s : ll){
			System.out.println(s);
		}*/
		
		
		
		//STACK
		
		Stack<Double> stk = new Stack<>();
		stk.push(2.5);
		stk.push(-2.5);
		stk.push(12.5);
		//Iterator<Double> it = stk.iterator();
		//while(it.hasNext()){
		//	System.out.println(it.next());
		//}
		
	//	System.out.println();
		
		while(stk.size()!=0){
			System.out.println(stk.pop());
		}
		
		
		
		//ќ„≈–≈ƒ№
		
		/*PriorityQueue<Integer> pQ = new PriorityQueue<>();
		pQ.offer(10);
		pQ.offer(5);
		pQ.offer(15);
		pQ.offer(-7);
		//System.out.println(pQ);
		
		while(!pQ.isEmpty()){
			System.out.println(pQ.poll());
		}*/
		//peek() посмотреть в голове но не вытаскивать. если зациклить то он будет бесконечным
		
		//ћножество
		
		
		/*HashMap<String, Double> m = new HashMap<>();
		m.put("ZP", 334.1);
		m.put("Kyiv", 838.9);
		m.put("Lviv", 182.0);*/
		
		//System.out.println(m.get("Kyiv"));//показывает площадь киева
		//поиск в хэш мапе выполн€етс€ за логарифмическое врем€!
		//ищет по хэш коду!
		
		
		
		/*HashMap<String, String> dic = new HashMap<>();
		HashMap<String, String> dic1 = new HashMap<>();
		dic.put("dog", "пЄс");
		dic1.put("пЄс", "dog");// TODO
		dic.put("ass", "жопа");
		dic.put("opa", "опа");
		String res = dic.get("ass");
		if(res!= null) System.out.println(res);//нужно провер€ть на нуллл!
		else System.out.println("not found");
		
		for(Map.Entry<String, String> e : dic.entrySet()) {
			if(e.getValue().equals("пЄс")) System.out.println(e.getKey());//такой подход плохой т.к. ему нужно 
																		//сортировать весь список а это много времени и тормоза!
		}*/
		
		HashMap<Student, Integer> debts = new HashMap<>();
		Student Vas = new Student("Gomer", "Povar", 95);
		Student AnorherVas = new Student("Gomer", "Pov", 50);
		Student Kol = new Student("Kol", "Povar", 95);
		debts.put(Vas, 0);
		debts.put(AnorherVas, 2);
		debts.put(Kol, 3);
		
		Integer res = debts.get(Kol);
		if(res!=null) System.out.println(res);
		
		
		
		
		
		
	}

}
