import java.io.IOException;


public class Mian {

	public static void main(String[] args) {
		/*ProcessBuilder b = new ProcessBuilder("calc");
		try {
			Process p = b.start();//открывает файлы exe на компе... открываем калькулятор 
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		ProcessBuilder b = new ProcessBuilder("cmd.exe", "/C", "notepad");
		try {
			Process p = b.start();
			if(p.isAlive())
				try {
					p.waitFor();
					System.out.println("Done");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
