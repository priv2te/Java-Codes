//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Scanner;

public class HW4_Q2 {

	public static final String MENU = "Spare-parts database\r\n" + "1. insert\r\n" + "2. search\r\n" + "3. delete\r\n"
			+ "4. show all\r\n" + "5. exit\r\n";

	public static BST_Tree tree = new BST_Tree();

	public static void main(String[] args) {
		takeAction();
	}

	public static void takeAction() {
		System.out.println(MENU);
		System.out.print("Input your option : ");
		Scanner inp = new Scanner(System.in);
		int number = inp.nextInt();
		System.out.print("\n");
		switch (number) {
		case 1: {
			tree.insert();
			break;
		}
		case 2: {
			tree.search();
			break;
		}
		case 3: {
			tree.delete();
			break;
		}
		case 4: {
			tree.inorder();
			break;
		}
		case 5: {
			System.exit(0);
		}
		default:
			System.out.println("Wrong Input");
		}
		takeAction();
	}
}

class Node {
	int key;
	double price;
	String description;
	Node left, right;

	public Node(int item, double price, String description) {
		key = item;
		this.price = price;
		this.description = description;
		left = right = null;
	}
}

class BST_Tree {
	Node root;

	BST_Tree() {
		root = null;
	}

	Scanner kb = new Scanner(System.in);

	void search() {
		System.out.print("Enter item no. : ");
		int item = kb.nextInt();
		Node itemNode = searchRec(root, item);
		if (itemNode != null) {
			System.out.println("\nFOUND item " + item + "\n");
			System.out.println("Details: " + "\nItem no.: " + itemNode.key + "\nPrice: " + itemNode.price
					+ "\nDescription: " + itemNode.description + "\n");
		} else {
			System.out.println("\nITEM NOT FOUND\n");
		}
	}

	public Node searchRec(Node root, int key) {
		if (root == null || root.key == key)
			return root;
		if (root.key > key)
			return searchRec(root.left, key);
		return searchRec(root.right, key);
	}

	void delete() {
		System.out.print("Enter item no. : ");
		int item = kb.nextInt();
		System.out.print("\n");
		root = deleteRec(root, item);
	}

	Node deleteRec(Node root, int key) {
		if (root == null)
			return root;
		if (key < root.key)
			root.left = deleteRec(root.left, key);
		else if (key > root.key)
			root.right = deleteRec(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.key = minValue(root.right);
			root.right = deleteRec(root.right, root.key);
		}
		return root;
	}

	int minValue(Node root) {
		int minv = root.key;
		while (root.left != null) {
			minv = root.left.key;
			root = root.left;
		}
		return minv;
	}

	void insert() {
		System.out.print("Enter item no. : ");
		int item = kb.nextInt();
		System.out.print("Enter price: ");
		double price = Double.parseDouble(kb.next());
		kb.nextLine();
		System.out.print("Enter Description: ");
		String description = kb.nextLine();
		root = insertRec(root, item, price, description);
		System.out.println("\nItem " + item + " added\n");
	}

	Node insertRec(Node root, int key, double price, String description) {
		if (root == null) {
			root = new Node(key, price, description);
			return root;
		}

		if (key < root.key)
			root.left = insertRec(root.left, key, price, description);
		else if (key > root.key)
			root.right = insertRec(root.right, key, price, description);
		return root;
	}

	void inorder() {
		System.out.println("All items in database: \n");
		inorderRec(root);
	}

	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(
					"Item no.: " + root.key + "\nPrice: " + root.price + "\nDescription: " + root.description + "\n");
			inorderRec(root.right);
		}
	}
}
