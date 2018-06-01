package character;

import java.awt.Point;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Point.Double h1=new Point.Double(50,50);
		Point.Double t1=new Point.Double(50,100);
		Point.Double h2=new Point.Double(45,45);
		Point.Double t2=new Point.Double(55,95);
		Blade b1=new Blade("",10, h1,t1, 10, 10, null);
		Blade b2=new Blade("",10, h2,t2, 10, 10, null);
		b1.bladeMove(100,50);
		b1.printVariables("b1");
		b1.setTip(b2.getTip());
		b1.colisionBlade(b1,b2);
		b1.bladeMove(100,50);
		b2.bladeMove(100,50);
		b1.printVariables("b1");
		b2.printVariables("b2");

	}

}
