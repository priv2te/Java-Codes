//////////////////////////////
//	*************************
//	* Auth:twitter.com/l79l *
//	*************************
//////////////////////////////

import java.util.Scanner;

class Cube extends Shape {
	private double len, volume;

	public Cube(String n, double s) {
		super(n);
		len = s;
	}

	public double volume() {
		volume = (len * len * len);
		return volume;
	}
}

class Square extends Shape {
	private double len, area;

	public Square(String n, double s) {
		super(n);
		len = s;
	}

	public double area() {
		area = len * len;
		return area;
	}
}

class Shape {
	String shapeName;

	public Shape(String n) {
		shapeName = n;
	}

	public String getShapeName() {
		return shapeName;
	}
}

public class Count {
	public static void main(String[] args) {

		Scanner cc = new Scanner(System.in);
		int op = 0;

		do {
			System.out.println("Option to Calculate:");
			System.out.println("1. Area of Square");
			System.out.println("2. Voulme of cube");
			System.out.println("3. Exit");

			System.out.println("Enter your option (1-3)?...");
			op = cc.nextInt();

			if (op == 1) {
				System.out.println("Enter length of shape :");
				double length = cc.nextDouble();
				System.out.println("Enter name of shape :");

				String n = cc.next();

				Square s = new Square(n, length);

				System.out.println("Area of Square " + s.getShapeName() + "=" + s.area());
			} else if (op == 2) {
				System.out.println("Enter length of shape :");
				double length = cc.nextDouble();
				System.out.println("Enter name of shape :");
				String n = cc.next();
				Cube c = new Cube(n, length);

				System.out.println("Volume of Cube " + c.getShapeName() + " = " + c.volume());
			} else if (op == 3) {
				System.out.println("Program terminated...");
			} else {
				System.out.println("Error: Wrong input...");

			}
		} while (op != 3);
	}
}
