
public class OneTestMain {

	static void ansver(OneEnum result){
		switch(result){
		case STARS :
			System.out.print(OneEnum.STARS.getSymbol()+"\t");
			break;
		case DOUBLE_STARS :
			System.out.print(OneEnum.DOUBLE_STARS.getSymbol()+"\t");
			break;
		case SEVEN :
			System.out.print(OneEnum.SEVEN.getSymbol()+"\t");
		}
	}
	
	public static void main(String[] args) {
		
		OneTest o = new OneTest();
		
		ansver(o.ask());
		ansver(o.ask());
		ansver(o.ask());
		
	}

}
