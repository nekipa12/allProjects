package edu.shag.lesson11.perechislenia;

public class Game {

	public static void main(String[] args) {
		Card card1 = new Card(10, 't', Suit.DIAMONDS);
		Player p1 = new Player("Vas", card1);
		Card card2 = new Card(4, '4', Suit.SPADES);
		Player p2 = new Player("Kol", card2);
		if(p2.getaCard().getValue() > p1.getaCard().getValue())
			System.out.println(p2.getName()+" is winner");
		else System.out.println(p1.getName()+" is winner");
		System.out.println(p1.getaCard().getSuit());
		if(p1.getaCard().getSuit()==Suit.DIAMONDS){
			System.out.println("Diamonds");//из строки сделать enum
		}
		String s = "DIAMONDS";
		Suit suit = Suit.valueOf(s);
		System.out.println(suit);
		System.out.println(p1.getaCard().getSuit().ordinal());//.ordinal() позволяет вытащить порядковый номер
	}

}
