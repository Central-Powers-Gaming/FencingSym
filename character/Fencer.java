package character;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Fencer extends Rectangle.Double{
	/*ADD DEFAULT VALUES JUST IN CASE
	 * 
	 */
private int Speed;
public String Name;
private Blade Sword;
private int jump=0;
private double ground;
private BufferedImage[] FncP=new BufferedImage[5] ;
public Fencer(BufferedImage[] FncP,String Name,int Speed,double x,double y,int height,int width,String NameB,int speedB, Point.Double handle,Point.Double tip, int block, int lunge, BufferedImage blade){
	this.Name=Name;
	this.Speed=Speed;
	this.x=x;
	this.y=y;
	ground=y;
	this.height=height;
	this.width=width;
	this.Sword=new Blade(NameB,speedB, handle, tip, block, lunge, blade);
	this.FncP= FncP;
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
/* jump code
 * 6/4/18
 * changes y coordinate to allow character to jump
 */
public void jump(){
	if(jump==0){
	y+=Speed/3;
	jump=1;
	}
}
private void jumpContinue(){
	if(jump!=0)
	if(jump==2){
		if(y==ground){
			jump=0;
		}else{
			y-=Speed/3;
		}
	}
	else if(jump==1){
		if(y==ground+Speed){
			jump=2;
		}
	}
}
//FencerControl
//6/4/18
//returns 1=win,-1=block,0=nothing
public int FencerControl(double x,double y,Fencer enemy){
	int rtrn=0;
	jumpContinue();
	boolean answer=moveBlade(x,y,enemy);
	if(answer){
		rtrn=1;
	}
	if(Sword.colisionBlade(Sword, enemy.getSword())){
		rtrn=-1;
	}return rtrn;
}
public boolean moveBlade(double x,double y,Fencer enemy){
	Sword.bladeMove(x,y);
	return enemy.hit(Sword.tip);
}
//getters and setters
public int getSpeed() {
	return Speed;
}
public BufferedImage getPic(int i) {
	return FncP[i];
}
public void setSpeed(int speed) {
	Speed = speed;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Blade getSword() {
	return Sword;
}
public void setSword(Blade sword) {
	Sword = sword;
}

public void setGround(double g){
	ground=g;
}
}
