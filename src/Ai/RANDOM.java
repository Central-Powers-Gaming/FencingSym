package Ai;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import character.Fencer;

public class RANDOM extends Fencer{
	private int SCREENX=Toolkit.getDefaultToolkit().getScreenSize().width;
	private int SCREENY=Toolkit.getDefaultToolkit().getScreenSize().height;
	public RANDOM(int modifier,BufferedImage[] fncr,String difficulty,String Name, int Speed,int length, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge) {
		super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier,length, handle, tip, block, lunge+modifier);
	}
	public boolean control(Fencer enemy){
		changeTip();
		lungeChoice(enemy);
		return changeLoc();
	}
	private void changeTip(){
		Point.Double tip=new Point.Double(Math.random()*SCREENX-500,Math.random()*SCREENY-500);
		Sword.bladeMove(tip);
	}
	//returns true if jumping
	private boolean changeLoc(){
		int ran=(int)(Math.random()*2+1);
		if(ran>1){
			move(true);
		}else{
			move(false);
		}
		ran=(int)(Math.random()*5000+1);
		if(ran==1){
			return jump();
		}return false;
	}
	private void lungeChoice(Fencer enemy){
		int ran=(int)(Math.random()*10000+1);
		if(ran==1)
			lunge(enemy);
	}
}
