//Author:bradly
//Date Created: June. 1, 2018
//Last modified: June. 14, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Ai;
import java.awt.image.BufferedImage;

import character.Fencer;
import java.awt.Point;
import java.awt.Toolkit;
/**
* the AI object
* @author Brad
**/
public class AI extends Fencer{
	private Fencer enemy;
	/**
	 * Constructor to create AI
	 * @author Brad
	 * @param int modifier,BufferedImage[] fncr,String difficulty,String Name, int Speed,int length, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,Fencer enemy
	 **/
	public AI(int modifier,BufferedImage[] fncr,String difficulty,String Name, int Speed,int length, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,Fencer enemy) {
		super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier, length, handle, tip, block, lunge+modifier);
	}
}	
	/**
	* easy mode
	* @author Brad
	**/
	 class EASY extends Fencer{
		private final static int modifier=-10;
		 /**
		* easy construcor
		* @author Brad
		* @param String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge
		**/
		public EASY(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier,length, handle, tip, block, lunge+modifier);
		}
	}
	/**
	* normal mode
	* @author Brad
	**/
	 class NORMAL extends Fencer{
		  /**
		* normal construcor
		* @author Brad
		* @param String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge
		**/
		public NORMAL(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed, x, y, height, width, NameB, speedB,length, handle, tip, block, lunge);
		}
	}
	/**
	* hard mode
	* @author Brad
	**/
	 class HARD extends Fencer{
		private final static int modifier=10;
		 /**
		* hard constructor
		* @author Brad
		* @param String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge
		**/
		public HARD(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier, length,handle, tip, block, lunge+modifier);
		}
		
	}
	/**
	* MIRROR object that makes the ai face the player
	* @author Brad
	**/
	 class MIRROR extends Fencer{
		private Fencer enemy;
		private Fencer change;
		 	/**
			* MIRROR constructor
			* @author Brad
			* @param String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,Fencer player
			**/
		public MIRROR(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,Fencer player){
			super(fncr,Name, Speed, x, y, height, width, NameB, speedB,length, handle, tip, block, lunge);
			enemy=player;
			change=player;
		}
		 /**
		* control method for ai
		* @author Brad
		**/
		public void control(){
			Sword.setTip(tipChange());
			Sword.setHandle(handleChange());
			x=xChange();
			y=yChange();
		}
		 /**
		* changes the position of the tip
		* @author Brad
		* @return Point.Double
		**/
		private Point.Double tipChange(){
			Point.Double e=enemy.getSword().getTip();
			Point.Double c=change.getSword().getTip();
			Point.Double move=new Point.Double(-1*(e.getX()-c.getX()),-1*(e.getY()-e.getY()));
			return move;
		}
		 /**
		* changes the handle's position
		* @author Brad
		* @return Point.Double
		**/
		private Point.Double handleChange(){
			Point.Double e=enemy.getSword().getHandle();
			Point.Double c=change.getSword().getHandle();
			Point.Double move=new Point.Double(-1*(e.getX()-c.getX()),-1*(e.getY()-e.getY()));
			return move;
		}
		 /**
		* changes x position
		* @author Brad
		* @return double
		**/
		private double xChange(){
			double e=enemy.x;
			double c=change.x;
			double move=e-c;
			return move;
		}
		/**
		* changes y position
		* @author Brad
		* @return double
		**/
		private double yChange(){
			double e=enemy.x;
			double c=change.x;
			double move=e-c;
			return move;
		}
	}
