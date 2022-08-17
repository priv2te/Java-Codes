//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Scanner;

class LinearProbingHashTable {
	private int currentSize, maxSize;
	private String[] keys;
	private String[] vals;

	public LinearProbingHashTable(int capacity) {
		currentSize = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	public void makeEmpty() {
		currentSize = 0;
		keys = new String[maxSize];
		vals = new String[maxSize];
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isFull() {
		return currentSize == maxSize;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	public boolean contains(String key) {
		return get(key) != null;
	}

	private int hash(String key) {
		return key.hashCode() % maxSize;
	}

	public void insert(String key, String val) {
		int tmp = hash(key);
		int i = tmp;
		do {
			if (keys[i] == null) {
				keys[i] = key;
				vals[i] = val;
				currentSize++;
				return;
			}
			if (keys[i].equals(key)) {
				vals[i] = val;
				return;
			}
			i = (i + 1) % maxSize;
		} while (i != tmp);
	}

	public String get(String key) {
		int i = hash(key);
		while (keys[i] != null) {
			if (keys[i].equals(key))
				return vals[i];
			i = (i + 1) % maxSize;
		}
		return null;
	}

	public void remove(String key) {
		if (!contains(key))
			return;

		int i = hash(key);
		while (!key.equals(keys[i]))
			i = (i + 1) % maxSize;
		keys[i] = vals[i] = null;

		for (i = (i + 1) % maxSize; keys[i] != null; i = (i + 1) % maxSize) {
			String tmp1 = keys[i], tmp2 = vals[i];
			keys[i] = vals[i] = null;
			currentSize--;
			insert(tmp1, tmp2);
		}
		currentSize--;
	}

	public void printHashTable() {
		System.out.println("\nHash Table: ");
		for (int i = 0; i < maxSize; i++)
			if (keys[i] != null)
				System.out.println(keys[i] + " " + vals[i]);
		System.out.println();
	}

}

public class MyHashTable {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Hash Table\n");
		System.out.print("Enter size: ");

		LinearProbingHashTable lpht = new LinearProbingHashTable(input.nextInt());

		char ch;
		do {
			System.out.println("\nHash Table Operations\n");
			System.out.println("1.insert ");
			System.out.println("2.Find");
			System.out.println("3.Delete");
			System.out.println("4.Show Table");
			System.out.println("5.Exit");
			System.out.print("\nPlease enter your choice: ");
			int choice = input.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter key and value:");
				lpht.insert(input.next(), input.next());
				break;
			case 2:
				System.out.println("Enter key to search for");
				System.out.println("Value = " + lpht.get(input.next()));
				break;
			case 3:
				System.out.println("Enter key to delete");
				lpht.remove(input.next());
				break;
			case 4:
				System.out.println("Showing Hash Table Contenet\n");
				lpht.printHashTable();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong Entry\n");
				break;
			}

			lpht.printHashTable();
			System.out.println("Do you want to continue (Type y or n)\n");
			ch = input.next().charAt(0);
		} while (ch == 'Y' || ch == 'y');
	}
}
