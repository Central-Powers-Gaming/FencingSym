package character;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public class Blade {
/* CHANGES OF HANDLE NEED TO BE ACOUNTED FOR AND COMPLETED
 * UPDATE CODE WHEN MORE INFORMATIONABOUT SPRITES ARE DECIDED
 * POSSIBLE THING TO DO
 * 		MAKE bLADE EXTEND LINE INSTEAD OF HAVE IT CONTAINED
 * 		ADD DEFAULT VALUES JUST IN CASE
 */
private boolean control;
private Line2D.Double line;
private double length;
private int Speed;
private int XSpeed;
private int YSpeed;
public Point.Double handle;
public Point.Double tip;
public int block;
public int blockCD;
public int lungeCD;
public int lunge;

private Point.Double target;
public String Name;
//constructor
public Blade(String Name,int speed,double length, Point.Double handle,Point.Double tip, int block, int lunge) {
	super();
	this.Name=Name;
	control=true;
	this.length=length;
	this.handle = handle;

	this.tip=ontoCircle(tip,handle,length);
	
	Speed = speed;
	this.block = block;
	this.lunge = lunge;
	XSpeed=0;
	YSpeed=0;
	line=new Line2D.Double(tip, handle);
}
//sets the location of target for blade movement using algorithm based upon blade length 

public void setTarget(Point.Double mouse){
	Point.Double m=new Point.Double(mouse.getX(),mouse.getY());
	double dis=Math.sqrt((tip.x-mouse.x)*(tip.x-mouse.x)+(tip.y-mouse.y)*(tip.y-mouse.y));
	if(dis==length){
		target=new Point.Double(m.getX(),m.getY());
	}else{
		target=ontoCircle(m, handle, length);
	}
}
/*p=point to convert
 * c=center of circle
 * r=radius
 * converts point to closest point on circle
 * 
 */
private Point.Double ontoCircle(Point.Double p,Point.Double c,double r){
	double vX=p.x-c.x;
	double vY=p.y-c.y;
	double magV=Math.sqrt(vX*vX+vY*vY);
	double aX=c.x+vX/magV*r;
	double aY=c.y+vY/magV*r;
	Point.Double to=new Point.Double(aX,aY);
	if(!distanceCheck(to)){
		System.out.println(checkLength(to,c));
	}
	return to;
}
public void bladeMove(double x,double y){
Point.Double xy=new Point.Double(x,y);
this.bladeMove(xy);
}
public void bladeMove(Point.Double mouse){
	if(control){
	Point.Double xy=ontoCircle(mouse,handle,length);
	move(xy);
	}else{
		if(tip.x!=target.x&&tip.y!=target.y){
		Point.Double xy=ontoCircle(target,handle,length);
		move(xy);
		}else{
			control=true;
			this.bladeMove(mouse);
		}
	}
}
public Boolean colisionBlade(Blade b1,Blade b2){
	if(b1.getTip().getX()==b2.getTip().getX()&&b1.getTip().getY()==b2.getTip().getY()){
		if(b1.getBlockCD()==0&&b2.getBlockCD()==0){
		b1.setBlockCD(b1.getBlock());
		b2.setBlockCD(b2.getBlock());
		b1.setControl(false);
		b2.setControl(false);
		b1.setTarget(new Point.Double(b1.tip.x-200,b1.tip.y+100));
		b2.setTarget(new Point.Double(b2.tip.x+200,b2.tip.y+100));
		return true;
		}else{
			return false;
		}
	}
	else if(b1.getLine().contains(b2.getTip())){
		if(b1.getBlockCD()==0){
			b1.setBlockCD(b1.getBlock());
			b2.setControl(false);
			b2.setTarget(new Point.Double(b2.tip.x+200,b2.tip.y+100));
			return true;
		}else return false;
	}else if(b2.getLine().contains(b1.getTip())){
		if(b2.getBlockCD()==0){
			b2.setBlockCD(b2.getBlock());
			b1.setControl(false);
			b1.setTarget(new Point.Double(b1.tip.x-200,b1.tip.y+100));
			return true;
		}else return false;
	}else return false;
}
void move(Point.Double xy){
	if(tip.x<xy.x){
		double Xchange=xy.x-tip.x;
		if(tip.y<xy.y){
			double Ychange=xy.y-tip.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			line.x1=tip.getX()+XSpeed;line.y1=tip.getY()+YSpeed;
			tip=new Point.Double(tip.getX()+XSpeed,tip.getY()+YSpeed);
			
			
		}else if(tip.y>xy.y){
			double Ychange=tip.y-xy.y;
			double multiple=1.0/(((double)Xchange+(double)Ychange)/(double)Xchange);
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			line.x1=tip.getX()+XSpeed;line.y1=tip.getY()-YSpeed;
			tip=new Point.Double(tip.getX()+XSpeed,tip.getY()-YSpeed);
			
		}
	}else if(tip.x>xy.x){
		double Xchange=tip.x-xy.x;
		if(tip.y<xy.y){
			double Ychange=xy.y-tip.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			line.x1=tip.getX()-XSpeed;line.y1=tip.getY()+YSpeed;
			tip=new Point.Double(tip.getX()-XSpeed,tip.getY()+YSpeed);
			
		}else if(tip.y>xy.y){
			double Ychange=tip.y-xy.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			line.x1=tip.getX()-XSpeed;line.y1=tip.getY()-YSpeed;
			tip=new Point.Double((tip.getX()-XSpeed),(tip.getY()-YSpeed));
			
		}
	}
}
//getters and setters
//5/30/18
public int getSpeed() {
	return Speed;
}
public void setSpeed(int speed) {
	Speed = speed;
}
public int getXSpeed() {
	return XSpeed;
}
public void setXSpeed(int xSpeed) {
	XSpeed = xSpeed;
}
public int getYSpeed() {
	return YSpeed;
}
public void setYSpeed(int ySpeed) {
	YSpeed = ySpeed;
}
public Point.Double getHandle() {
	return handle;
}
public void setHandle(Point.Double handle) {
	this.handle = handle;
}
public Point.Double getTip() {
	return tip;
}
public void setTip(Point.Double tip) {
	this.tip = tip;
}
public int getLunge() {
	return lunge;
}
public void setLunge(int lunge) {
	this.lunge = lunge;
}

public Point.Double getTarget() {
	return target;
}

public boolean isControl() {
	return control;
}
public Line2D.Double getLine() {
	return line;
}
public double getLength() {
	return length;
}
public int getBlock() {
	return block;
}
public int getBlockCD() {
	return blockCD;
}
public void setBlockCD(int blockCD) {
	this.blockCD = blockCD;
}
public int getLungeCD() {
	return lungeCD;
}
public void setLungeCD(int lungeCD) {
	this.lungeCD = lungeCD;
}
private void setControl(boolean control) {
	this.control = control;
}
public String getName(){
	return Name;
}
public void setName(String Name){
	this.Name=Name;
}
void printVariables(){
	System.out.println(Name+" length:"+length);
	System.out.println(Name+" speed:"+Speed);
	System.out.println(Name+" Xspeed:"+XSpeed);
	System.out.println(Name+" Yspeed:"+YSpeed);
	System.out.println(Name+" handle:"+handle.x+" "+handle.y);
	System.out.println(Name+" tip:"+tip.x+" "+tip.y);
	System.out.println(Name+" Block:"+block);
	System.out.println(Name+" lunge:"+lunge);
}
void printVariables(String name){
	System.out.println(name+" length:"+length);
	System.out.println(name+" speed:"+Speed);
	System.out.println(name+" Xspeed:"+XSpeed);
	System.out.println(name+" Yspeed:"+YSpeed);
	System.out.println(name+" handle:"+handle.x+" "+handle.y);
	System.out.println(name+" tip:"+tip.x+" "+tip.y);
	System.out.println(name+" Block:"+block);
	System.out.println(name+" lunge:"+lunge);
}
public double checkLength(){
	return Math.sqrt((this.tip.x-handle.x)*(this.tip.x-handle.x)+(this.tip.y-handle.y)*(this.tip.y-handle.y));
}
public double checkLength(Point.Double tip,Point.Double handle){
	return Math.sqrt((tip.x-handle.x)*(tip.x-handle.x)+(tip.y-handle.y)*(tip.y-handle.y));
}
private boolean distanceCheck(Point.Double tip){
	double x=Math.sqrt((tip.x-handle.x)*(tip.x-handle.x)+(tip.y-handle.y)*(tip.y-handle.y));
	return length==x;
}
}