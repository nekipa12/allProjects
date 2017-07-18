package edu.shag.lesson15.view.client;

public class ViewClient {

	public void methArray(int it, String str) {
		System.out.println(it + " " +str + "\t");
		
	}

	public String end() {
		String g = "end";
		return g;
	}

	public void use() {
		System.out.println("ПРАВИЛА ПОЛЬЗОВАНИЯ");
		System.out.println("'dir' чтобы посмотреть каталог сервера");
		System.out.println("'end' для разъеденения с сервером");
		System.out.println("'copy' для копирования файлов");
		System.out.println("чтобы копировать файлы осуществляется ввод по типу '12 D:/'");
		System.out.println("где '12' - порядковый номер файла в каталоге");
		System.out.println("'D:/' путь к месту сохранения информации");
		System.out.println("'nuf' для выхода из режима копирования");
	}
}
