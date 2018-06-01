package character;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

public class Blade {
private boolean control;
private Line2D.Double line;
private int length;
private int Speed;
private int XSpeed;
private int YSpeed;
public Point.Double handle;
public Point.Double tip;
public int block;
public int blockCD;
public int lungeCD;
public int lunge;
public BufferedImage pic;
private Point.Double target;
//constructor
public Blade(int length, int speed, Point.Double handle,Point.Double tip, int block, int lunge, BufferedImage pic) {
	super();
	control=true;
	this.length = length;
	Speed = speed;
	this.handle = handle;
	this.block = block;
	this.lunge = lunge;
	this.pic = pic;
	XSpeed=0;
	YSpeed=0;
	this.tip=ontoCircle(tip,handle,length);
	line=new Line2D.Double(tip, handle);
}
//sets the location of target for balde movement using algorithm based upon blade length 

public void setTarget(Point.Double mouse){
	Point.Double m=new Point.Double(mouse.getX(),mouse.getY());
	double dis=Math.sqrt((tip.x-mouse.x)*(tip.x-mouse.x)+(tip.y-mouse.y)*(tip.y-mouse.y));
	if(dis<length){
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
private Point.Double ontoCircle(Point.Double p,Point.Double c,int r){
	double vX=p.x-c.x;
	double vY=p.y-c.y;
	double magV=Math.sqrt(vX*vX+vY*vY);
	double aX=c.x+vX/magV*r;
	double aY=c.y+vY/magV*r;
	Point.Double to=new Point.Double((int)aX,(int)aY);
	return to;
}
public void bladeMove(int x,int y){
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
		if(b1.getBlock()==0&&b2.getBlock()==0){
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
			tip=new Point.Double((int)(tip.getX()+XSpeed),(int)(tip.getY()+YSpeed));
		}else if(tip.y>xy.y){
			double Ychange=tip.y-xy.y;
			double multiple=1.0/(((double)Xchange+(double)Ychange)/(double)Xchange);
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			tip=new Point.Double((int)(tip.getX()+XSpeed),(int)(tip.getY()-YSpeed));
			System.out.println();
		}
	}else if(tip.x>xy.x){
		double Xchange=tip.x-xy.x;
		if(tip.y<xy.y){
			double Ychange=xy.y-tip.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			tip=new Point.Double((int)(tip.getX()-XSpeed),(int)(tip.getY()+YSpeed));
		}else if(tip.y>xy.y){
			double Ychange=tip.y-xy.y;
			double multiple=1/(Xchange+Ychange)/Xchange;
			XSpeed=(int) (Speed*multiple);
			YSpeed=Speed-XSpeed;
			tip=new Point.Double((int)(tip.getX()-XSpeed),(int)(tip.getY()-YSpeed));
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
public BufferedImage getPic() {
	return pic;
}
public void setPic(BufferedImage pic) {
	this.pic = pic;
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
public int getLength() {
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
void printVariables(String name){
	System.out.println(name+"length:"+length);
	System.out.println(name+"speed:"+Speed);
	System.out.println(name+"Xspeed:"+XSpeed);
	System.out.println(name+"Yspeed:"+YSpeed);
	System.out.println(name+"handle:"+handle.x+" "+handle.y);
	System.out.println(name+"tip"+tip.x+" "+tip.y);
	System.out.println(name+"Block:"+block);
	System.out.println(name+"lunge:"+lunge);
}

}
