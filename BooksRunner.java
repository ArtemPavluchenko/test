

import java.util.ArrayList;

class GenBooks extends BookGernerator {
	
	public void greateDataBase(ArrayList<Book> dataBase, int number) {
		for (int i=0; i <= number; i++) {
			Book obj = new Book();
			obj.setName(generateName());
			obj.setAutor(generateAutor());
			obj.setPublishing(generatePublishing());
			obj.setPublishingYear(generatePublishingYear());
			obj.setNumOfPages(generateNumOfPages());
			obj.setPrise(generatePrice());
			obj.setTypeOfBinding(generateTypeOfBinding());
			dataBase.add(i,obj);
		}
	}
}

abstract class OperationOnBooksObjects {

	public static void showAllBooksOneAutor(ArrayList<Book> dataBase, String autor) {
		System.out.println("Список книг автора(ов) "+autor);
		int i = 0;
		for (; i < dataBase.size(); i++) {
			if (dataBase.get(i).getAutor().equals(autor)) {
				System.out.println(dataBase.get(i).getName());
			}
		}
		if (i == 0) {
			System.out.println("В базе данных нет книг этого автора");
		}
		System.out.println();
	}

	public static void showAllBookOnePublishing(ArrayList<Book> dataBase, String publishing) {
		System.out.println("Список книг издательства "+publishing);
		int i = 0;
		for (; i < dataBase.size(); i++) {
			if (dataBase.get(i).getPublishing().equals(publishing)) {
				System.out.println(dataBase.get(i).getName());
			}
		}
		if (i == 0) {
			System.out.println("В базе данных нет книг этого издательства");
		}
		System.out.println();
	}

	public static void showAllBookAfterYear(ArrayList<Book> dataBase, int year) {
		System.out.println("Список книг изданных после "+year+" года");
		int i=0;
		for (; i < dataBase.size(); i++) {
			if (dataBase.get(i).getPublishingYear() > year) {
				System.out.println(dataBase.get(i).getName());
			}
		}
		if (i == 0) {
			System.out.println("В базе данных нет книг изданых раньше "+year+" года");
		}
		System.out.println();
	}

	public static void print (ArrayList<Book> dataBase) {
		for (int i=0; i < dataBase.size(); i++) {
			System.out.println(dataBase.get(i).toString());
		}
	}
}

public class BooksRunner {
	public static void main(String[] args) {
		ArrayList<Book> dataBase = new ArrayList<>();
		GenBooks obj = new GenBooks();
		obj.greateDataBase(dataBase, 100);
		OperationOnBooksObjects.print(dataBase);

		OperationOnBooksObjects.showAllBooksOneAutor(dataBase, "Владислав Крапивин");

		OperationOnBooksObjects.showAllBookOnePublishing(dataBase, "Аванта +");

		OperationOnBooksObjects.showAllBookAfterYear(dataBase, 1980);
	}
}
