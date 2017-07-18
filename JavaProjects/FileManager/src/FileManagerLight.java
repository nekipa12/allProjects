
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileManagerLight {

	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("чтобы копировать файл введите - 'copy' , директорию файла "
				+ "который нужно копировать и ввести директорию куда нужно копировать");
		System.out.println("чтобы удалить файл введите - 'delete' и введите путь и им€ файла");
		System.out.println("чтобы открыть файл введите - 'open', введите директорию и им€ файла");
		System.out.println("чтобы выйти файл введите - 'exit'");
		while (true){
			String s = sc.nextLine();
			if(s.equals("copy")){
				methCopy(filef(), filef());
			} else if(s.equals("delete")){
				methDelete(filef());
			} else if(s.equals("open")){
				methOpen(filef());
			} else if(s.equals("exit")) {
				sc.close();
				return;
			} else {
				try{
					File f = new File(s);
					File[] fil = f.listFiles();
					for(File h : fil){
						if(!h.isDirectory()){
							System.out.println(h.getAbsolutePath());
						}
					}
				}catch(NullPointerException npe){
					System.out.println("¬ведите корректный путь");
				}
					
			}
		}
		
	}
	private static File filef() {
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		String s = sc1.nextLine();
		File f = new File(s);
		return f;
	}
	private static void methOpen(File f) {
		FileInputStream fis = null;
		Scanner sc = null;
		try {
			fis = new FileInputStream(f);
			sc = new Scanner(fis);			
			StringBuilder sb = new StringBuilder();
			while(sc.hasNextLine()){
				sb.append(sc.nextLine()+ "\n");
			}
			System.out.println(sb.toString());
		} catch (IOException e) {
			System.out.println("файл не найден или неверно введен путь");
		} finally{
			try {
				fis.close();
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	private static void methDelete(File f) {
		f.delete();
		
	}

	private static void methCopy(File c, File c1) {
		InputStream is = null;
		OutputStream os = null;
		try{
			try {
				is = new FileInputStream(c);
				os = new FileOutputStream(c1);
			} catch (FileNotFoundException e) {
				System.out.println("файл не найден или неверно введен путь");
			}
			byte [] buffer = new byte [1024];
			int lenght;
			try {
			while((lenght = is.read(buffer))>0){
				os.write(buffer, 0, lenght);
				}
			} catch (IOException e) {
			}
		} finally{
			try {
				is.close();
				os.close();
				//sc.close();
			} catch (IOException e) {
			}
		}
	}
}
