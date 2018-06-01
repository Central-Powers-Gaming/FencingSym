package character;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Fencer extends Rectangle.Double{
	/*ADD DEFAULT VALUES JUST IN CASE
	 * 
	 */
public BufferedImage sprite;
private int Speed;
public String Name;
private Blade Sword;
public Fencer(String Name,int Speed,BufferedImage sprite,double x,double y,int height,int width,String NameB,int speedB, Point.Double handle,Point.Double tip, int block, int lunge, BufferedImage blade){
	this.Name=Name;
	this.Speed=Speed;
	this.sprite=sprite;
	this.x=x;
	this.y=y;
	this.height=height;
	this.width=width;
	this.Sword=new Blade(NameB,speedB, handle, tip, block, lunge, blade);
}
public boolean hit(Point.Double p){
	if(this.contains(p)){
		return true;
	}return false;
}
public void move(boolean forwards){
	if(forwards){
		x+=Speed;
	}else if(!forwards){
		x-=Speed;
	}
}

}
