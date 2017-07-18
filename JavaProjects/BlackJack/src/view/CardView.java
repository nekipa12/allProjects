package view;

import model.Card;

public class CardView {
	
	public void meth(Card s ){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(s.getSuit().equals(s.getSuit().CLUBS)){
			switch (s.getPictures()){
			case TWO : 
				
				
				System.out.println(" ______________");
				System.out.println("|2             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   2  |");
				System.out.println("|______________|");
				break;
			case THREE :
				System.out.println(" ______________");
				System.out.println("|3             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   3  |");
				System.out.println("|______________|");
				break;
			case FOUR : 
				System.out.println(" ______________");
				System.out.println("|4             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   4  |");
				System.out.println("|______________|");
				break;
			case FIVE : 
				System.out.println(" ______________");
				System.out.println("|5             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   5  |");
				System.out.println("|______________|");
				break;
			case SIX : 
				System.out.println(" ______________");
				System.out.println("|6             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   6  |");
				System.out.println("|______________|");
				break;
			case SEVEN : 
				System.out.println(" ______________");
				System.out.println("|7             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   7  |");
				System.out.println("|______________|");
				break;
			case EIGHT : 
				System.out.println(" ______________");
				System.out.println("|8             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   8  |");
				System.out.println("|______________|");
				break;
			case NINE : 
				System.out.println(" ______________");
				System.out.println("|9             |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   9  |");
				System.out.println("|______________|");
				break;
			case TEN : 
				System.out.println(" ______________");
				System.out.println("|10            |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       *   10 |");
				System.out.println("|______________|");
				break;
			case JACK : 
				System.out.println(" ______________");
				System.out.println("|JACK          |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       * JACK |");
				System.out.println("|______________|");
				break;
			case QUEEN : 
				System.out.println(" ______________");
				System.out.println("|QUEEN         |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       * QUEEN|");
				System.out.println("|______________|");
				break;
			case KING : 
				System.out.println(" ______________");
				System.out.println("|KING          |");
				System.out.println("|       *      |");
				System.out.println("|       *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *      |");
				System.out.println("|       * KING |");
				System.out.println("|______________|");
				break;
			case ACE : 
				System.out.println(" ______________");
				System.out.println("|ACE           |");
				System.out.println("|       * *    |");
				System.out.println("|   *   *      |");
				System.out.println("|   * * * * *  |");
				System.out.println("|       *   *  |");
				System.out.println("|     * *  ACE |");
				System.out.println("|______________|");
				break;	
			}
		}else if(s.getSuit().equals(s.getSuit().DIAMONDS)){
			switch (s.getPictures()){
			case TWO : 
				System.out.println(" ______________");
				System.out.println("|2             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   2  |");
				System.out.println("|______________|");
				break;
			case THREE :
				System.out.println(" ______________");
				System.out.println("|3             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   3  |");
				System.out.println("|______________|");
				break;
			case FOUR : 
				System.out.println(" ______________");
				System.out.println("|4             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   4  |");
				System.out.println("|______________|");
				break;
			case FIVE : 
				System.out.println(" ______________");
				System.out.println("|5             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   5  |");
				System.out.println("|______________|");
				break;
			case SIX : 
				System.out.println(" ______________");
				System.out.println("|6             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   6  |");
				System.out.println("|______________|");
				break;
			case SEVEN : 
				System.out.println(" ______________");
				System.out.println("|7             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   7  |");
				System.out.println("|______________|");
				break;
			case EIGHT : 
				System.out.println(" ______________");
				System.out.println("|8             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   8  |");
				System.out.println("|______________|");
				break;
			case NINE : 
				System.out.println(" ______________");
				System.out.println("|9             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   9  |");
				System.out.println("|______________|");
				break;
			case TEN : 
				System.out.println(" ______________");
				System.out.println("|10            |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   10 |");
				System.out.println("|______________|");
				break;
			case JACK : 
				System.out.println(" ______________");
				System.out.println("|JACK          |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * JACK |");
				System.out.println("|______________|");
				break;
			case QUEEN : 
				System.out.println(" ______________");
				System.out.println("|QUEEN         |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * QUEEN|");
				System.out.println("|______________|");
				break;
			case KING : 
				System.out.println(" ______________");
				System.out.println("|KING          |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * KING |");
				System.out.println("|______________|");
				break;
			case ACE : 
				System.out.println(" ______________");
				System.out.println("|ACE           |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * *	* * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *  ACE |");
				System.out.println("|______________|");
				break;	
			}
		}else if(s.getSuit().equals(s.getSuit().HEARTS)){
			switch (s.getPictures()){
			case TWO : 
				System.out.println(" ______________");
				System.out.println("|2             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   2  |");
				System.out.println("|______________|");
				break;
			case THREE :
				System.out.println(" ______________");
				System.out.println("|3             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   3  |");
				System.out.println("|______________|");
				break;
			case FOUR : 
				System.out.println(" ______________");
				System.out.println("|4             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   4  |");
				System.out.println("|______________|");
				break;
			case FIVE : 
				System.out.println(" ______________");
				System.out.println("|5             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   5  |");
				System.out.println("|______________|");
				break;
			case SIX : 
				System.out.println(" ______________");
				System.out.println("|6             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   6  |");
				System.out.println("|______________|");
				break;
			case SEVEN : 
				System.out.println(" ______________");
				System.out.println("|7             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   7  |");
				System.out.println("|______________|");
				break;
			case EIGHT : 
				System.out.println(" ______________");
				System.out.println("|8             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   8  |");
				System.out.println("|______________|");
				break;
			case NINE : 
				System.out.println(" ______________");
				System.out.println("|9             |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   9  |");
				System.out.println("|______________|");
				break;
			case TEN : 
				System.out.println(" ______________");
				System.out.println("|10            |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       *   10 |");
				System.out.println("|______________|");
				break;
			case JACK : 
				System.out.println(" ______________");
				System.out.println("|JACK          |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * JACK |");
				System.out.println("|______________|");
				break;
			case QUEEN : 
				System.out.println(" ______________");
				System.out.println("|QUEEN         |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * QUEEN|");
				System.out.println("|______________|");
				break;
			case KING : 
				System.out.println(" ______________");
				System.out.println("|KING          |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * KING |");
				System.out.println("|______________|");
				break;
			case ACE : 
				System.out.println(" ______________");
				System.out.println("|ACE           |");
				System.out.println("|              |");
				System.out.println("|   , *   * ,  |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|     * * *    |");
				System.out.println("|       * ACE  |");
				System.out.println("|______________|");
				break;	
			}
		}else if(s.getSuit().equals(s.getSuit().SPADES)){
			switch (s.getPictures()){
			case TWO : 
				System.out.println(" ______________");
				System.out.println("|2             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    2 |");
				System.out.println("|______________|");
				break;
			case THREE :
				System.out.println(" ______________");
				System.out.println("|3             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    3 |");
				System.out.println("|______________|");
				break;
			case FOUR : 
				System.out.println(" ______________");
				System.out.println("|4             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    4 |");
				System.out.println("|______________|");
				break;
			case FIVE : 
				System.out.println(" ______________");
				System.out.println("|5             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    5 |");
				System.out.println("|______________|");
				break;
			case SIX : 
				System.out.println(" ______________");
				System.out.println("|6             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    6 |");
				System.out.println("|______________|");
				break;
			case SEVEN : 
				System.out.println(" ______________");
				System.out.println("|7             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    7 |");
				System.out.println("|______________|");
				break;
			case EIGHT : 
				System.out.println(" ______________");
				System.out.println("|8             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    8 |");
				System.out.println("|______________|");
				break;
			case NINE : 
				System.out.println(" ______________");
				System.out.println("|9             |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |    9 |");
				System.out.println("|______________|");
				break;
			case TEN : 
				System.out.println(" ______________");
				System.out.println("|10            |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |   10 |");
				System.out.println("|______________|");
				break;
			case JACK : 
				System.out.println(" ______________");
				System.out.println("|JACK          |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       | JACK |");
				System.out.println("|______________|");
				break;
			case QUEEN : 
				System.out.println(" ______________");
				System.out.println("|QUEEN         |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       | QUEEN|");
				System.out.println("|______________|");
				break;
			case KING : 
				System.out.println(" ______________");
				System.out.println("|KING          |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       | KING |");
				System.out.println("|______________|");
				break;
			case ACE : 
				System.out.println(" ______________");
				System.out.println("|ACE           |");
				System.out.println("|       *      |");
				System.out.println("|     * * *    |");
				System.out.println("|   * * ` * *  |");
				System.out.println("|   `* *|* *`  |");
				System.out.println("|       |  ACE |");
				System.out.println("|______________|");
				break;	
			}
			
		}
		
	}
	public void shirt(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" ______________");
		System.out.println("|XXXXXXXXXXXXXX|");
		System.out.println("|XXX BLACK XXXX|");
		System.out.println("|XXX J XXXXXXXX|");
		System.out.println("|XXXX A XXXXXXX|");
		System.out.println("|XXXXX C XXXXXX|");
		System.out.println("|XXXXXX K XXXXX|");
		System.out.println("|XXXXXXXXXXXXXX|");
		System.out.println("|______________|");
	}
}
