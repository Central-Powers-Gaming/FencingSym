package Ai;
//Author:bradly
//Date Created: June. 1, 2018
//Last modified: June. 14, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
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
		if(frame<4){
			frame++;
		}else{
			frame=0;
		}
		
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
