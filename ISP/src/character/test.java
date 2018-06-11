package character;

import java.awt.Point;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Point.Double h1=new Point.Double(50,50);
		Point.Double t1=new Point.Double(50,100);
		Point.Double h2=new Point.Double(50,150);
		Point.Double t2=new Point.Double(50,100);
		Blade b1=new Blade("",10,50, h1,t1, 10, 10);
		Blade b2=new Blade("",10,50, h2,t2, 10, 10);
		System.out.println(b1.getTip());
		System.out.println(b2.getTip());
		System.out.println(b1.colisionBlade(b1, b2));
		System.out.println(b1.getTip());
		System.out.println(b2.getTip());
		b1.bladeMove(100, 100);
		b2.bladeMove(700,700);
		System.out.println(b1.getTip());
		System.out.println(b2.getTip());
		b1.bladeMove(100, 100);
		b2.bladeMove(700,700);
		System.out.println(b1.getTip());
		System.out.println(b2.getTip());
		b1.bladeMove(000, 00);
		b2.bladeMove(700,700);
		System.out.println(b1.getTip());
		System.out.println(b2.getTip());
		b1.bladeMove(7, 28);
	}

}
