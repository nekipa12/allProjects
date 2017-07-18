import java.util.Random;

public class OneTest {

	Random rnd = new Random();
	OneEnum ask(){
		
		int prob = (int)(100*rnd.nextDouble());
		
		if(prob < 40)
			return OneEnum.STARS;
		else if(prob < 80)
			return OneEnum.DOUBLE_STARS;
		else
			return OneEnum.SEVEN;
		
	}
	
	

}
