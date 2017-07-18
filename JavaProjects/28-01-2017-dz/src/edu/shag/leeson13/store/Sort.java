package edu.shag.leeson13.store;

import java.util.Comparator;

public class Sort {

	public class SortByManufacturer implements Comparator<PhoneTabletParent> {
		@Override
		public int compare(PhoneTabletParent arg0, PhoneTabletParent arg1) {
			String price1 = arg0.getManufacturer();
			String price2 = arg1.getManufacturer();
			if(price1.compareTo(price2) <0)return -1; 
			else if(price1.compareTo(price2) > 0)return 1; 
			else return 0;
		}
	}
	public class SortByPrice implements Comparator<PhoneTabletParent> {
		@Override
		public int compare(PhoneTabletParent arg0, PhoneTabletParent arg1) {
			double price1 = arg0.getPrice();
			double price2 = arg1.getPrice();
			if(price1<price2)return -1; 
			else if(price1>price2)return 1; 
			else return 0;
		}
	}
}
