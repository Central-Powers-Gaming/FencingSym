//Author:bradly
//Date Created: June. 1, 2018
//Last modified: June. 14, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package character;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import Ai.AI;
public class Fencer extends Rectangle.Double{
	/*ADD DEFAULT VALUES JUST IN CASE
	 * 
	 */
static final int Th=Toolkit.getDefaultToolkit().getScreenSize().height;
private int Speed;
public String Name;
public int frame;
protected Blade Sword;
private int jump=0;
private int score=0;
private double ground;
/**
 * @return the score
 */
public int getScore() {
	return score;
}
/**
 * @param score the score to set
 */
public void setScore(int score) {
	this.score = score;
}

private BufferedImage[] FncP=new BufferedImage[5] ;
public Fencer(){}
public Fencer(BufferedImage[] FncP,String Name,int Speed,double x,double y,int height,int width,String NameB,int speedB,double length, Point.Double handle,Point.Double tip, int block, int lunge){
	this.Name=Name;
	this.Speed=Speed;
	this.x=x;
	this.y=y;
	ground=y;
	this.height=height;
	this.width=width;
	this.Sword=new Blade(NameB,speedB,length, handle, tip, block, lunge);
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
		Sword.setTip(new Point.Double(Sword.getTip().getX()+Speed,Sword.getTip().getY()));
		Sword.setHandle(new Point.Double(Sword.getHandle().getX()+Speed,Sword.getHandle().getY()));
	}else if(!forwards){
		x-=Speed;
		Sword.setTip(new Point.Double(Sword.getTip().getX()-Speed,Sword.getTip().getY()));
		Sword.setHandle(new Point.Double(Sword.getHandle().getX()-Speed,Sword.getHandle().getY()));
	}
}
/* jump code
 * 6/4/18
 * changes y coordinate to allow character to jump
 */
public boolean jump(){
	boolean yay=true;
	if(y>Th*(0.60185185)-120&&(jump==0||jump==1)){
		System.out.println("here");
		y-=Speed*3;
		jump=1;
	}else{
		System.out.println("here2");
		jump=2;
		y+=Speed*5;
	}
	if(y>Th*(0.60185185)){
		jump=0;
		y=Th*(0.60185185);
		yay=false;
	}
	return yay;
}
/*lunge
 * 6/4/18
 * casues fencer to lunge towords enemy and checks if blocked 
 */
public void lunge(Fencer enemy){
	if(!(Sword.lungeCD>0)){
		if(!Sword.colisionBlade(Sword, enemy.getSword())){
			Sword.tip=new Point.Double(width+x+Sword.getLength(),height/2);
			Sword.handle=new Point.Double(x+width,height/2);
		}Sword.lungeCD=Sword.getLunge();
		Sword.setLungeCD(Sword.getLunge());
	}
}
//FencerControl
//6/4/18
//returns 1=win,-1=block,0=nothing
public int FencerControl(double x,double y,Fencer enemy){
	int rtrn=0;
	
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