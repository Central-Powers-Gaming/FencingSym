package character;

import java.awt.Point;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Point.Double h1=new Point.Double(50,50);
		Point.Double t1=new Point.Double(50,100);
		Point.Double h2=new Point.Double(45,45);
		Point.Double t2=new Point.Double(55,95);
		Blade b1=new Blade("",10,50, h1,t1, 10, 10);
		Blade b2=new Blade("",10,50, h2,t2, 10, 10);
		System.out.println(b1.getLength());
		System.out.println(b1.checkLength());
		b1.bladeMove(100, 100);
		System.out.println(b1.checkLength());
		System.out.println(b1.getLength());
		b1.bladeMove(100, 100);
		System.out.println(b1.checkLength());
		System.out.println(b1.getLength());
		b1.bladeMove(100, 100);
		System.out.println(b1.checkLength());
		System.out.println(b1.getLength());
		b1.bladeMove(000, 00);
		System.out.println(b1.checkLength());
		System.out.println(b1.getLength());
		b1.bladeMove(7, 28);
	}

}
