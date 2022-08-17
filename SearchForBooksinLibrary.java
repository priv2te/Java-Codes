//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Scanner;

class Book {
	public long bookID;
	public String title;
	public String author;
	public int edition;
	public String publisher;
	public int year;
	public Book next;
	public Book(long ID, String tit, String aut, int ed, String pub, int y) {
		bookID = ID;
		title = tit;
		author = aut;
		edition = ed;
		publisher = pub;
		year = y;
	}
}

class myBookList {
	protected Book head, tail;
	public myBookList() {
		head = tail = null;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addToHead(long ID, String tit, String aut, int ed, String pub, int y) {
		Book newBook = new Book(ID, tit, aut, ed, pub, y);
		if (head == null){
			tail = head = newBook;
		}
		else{
			newBook.next = head;
			head = newBook;
		}
	}

	public boolean delete(long bookID) {
		if (head == null){
			return false;
		}
		if (head == tail && bookID == head.bookID)
		{
			head = tail = null;
		}
		else if (bookID == head.bookID){
			head = head.next;
		}
		else{
			Book prev = head, tmp = head.next;
			while (tmp != null && tmp.bookID != bookID) {
				prev = prev.next;
				tmp = tmp.next;
			}
			if (tmp != null) {
				prev.next = tmp.next;
				if (tmp == tail){
					tail = prev;
				}
			}
			else {
				return false;
			}
		}
		return true;
	}
	public void printAll() {
		for (Book tmp = head; tmp != null; tmp = tmp.next) {
			System.out.println(tmp.bookID + " " + tmp.title + " " + tmp.author + " " + tmp.edition + " " + tmp.publisher
					+ " " + tmp.year + " " + " -> ");
		}
		System.out.println("null");
	}
}

public class BooksInLibrary {
	public static void main(String[] args) {
		myBookList myStock = new myBookList();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		int i;
		
		for (i = 1; i != 0; i++) {
			System.out.println("Books  in Library\n");
			System.out.println("1.Add a book");
			System.out.println("2.Remove a book");
			System.out.println("3.Show list of book");
			System.out.println("4.Exit");
			System.out.println("Your choice? ");
			choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Add book info : ");
				System.out.println("Book ID : ");
				long id = input.nextLong();
				System.out.println("Book Edition : ");
				int edition = input.nextInt();
				System.out.println("Book Year : ");
				int year = input.nextInt();
				System.out.println("BookTitle : ");
				String title = input.nextLine();
				title = input.nextLine();
				System.out.println("Book Author : ");
				String author = input.nextLine();
				System.out.println("Book Publisher : ");
				String pub = input.nextLine();
				myStock.addToHead(id, title, pub, year, pub, year);
				break;
			case 2:
				System.out.println("Enter book ID to remove # ");
				long id1 = input.nextLong();
				if (myStock.delete(id1)) {
					System.out.println("Book is removed");
				}
				else {
					System.out.println("Book doesn't exist");
				}
				break;
			case 3:
				System.out.println("myStock = ");
				myStock.printAll();
				break;
			case 4:
				System.exit(0);
			}
		}
	}
}
