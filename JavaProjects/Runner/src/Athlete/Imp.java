package Athlete;

import java.util.Comparator;

public class Imp implements Comparator<Athlete> {

	@Override
	public int compare(Athlete arg0, Athlete arg1) {
		double price1 = arg0.getTime();
		double price2 = arg1.getTime();
		if(price1 > price2) {
			return 1;
		}
		else if(price1 < price2) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
