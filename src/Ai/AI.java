package Ai;
import java.awt.image.BufferedImage;

import character.Fencer;
import java.awt.Point;
public class AI extends Fencer{
	public AI(int modifier,BufferedImage[] fncr,String difficulty,String Name, int Speed,int length, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge) {
		super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier, length, handle, tip, block, lunge+modifier);
	}
	private class RANDOM extends Fencer{
		public RANDOM(int modifier,BufferedImage[] fncr,String difficulty,String Name, int Speed,int length, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge) {
			super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier,length, handle, tip, block, lunge+modifier);
		}
		public void control(){
			
		}
		private Point.Double changeTip(){
			Point.Double tip=new Point.Double(Math.random()*)
		}
	}
	private class EASY extends Fencer{
		private final static int modifier=-10;
		public EASY(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier,length, handle, tip, block, lunge+modifier);
		}
	}
	private class NORMAL extends Fencer{
		public NORMAL(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed, x, y, height, width, NameB, speedB,length, handle, tip, block, lunge);
		}
	}
	private class HARD extends Fencer{
		private final static int modifier=10;
		public HARD(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge){
			super(fncr,Name, Speed+modifier, x, y, height, width, NameB, speedB+modifier, length,handle, tip, block, lunge+modifier);
		}
		
	}
	private class MIRROR extends Fencer{
		private Fencer enemy;
		private Fencer change;
		public MIRROR(String difficulty,BufferedImage[] fncr,String Name, int Speed,int length,  double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,Fencer player){
			super(fncr,Name, Speed, x, y, height, width, NameB, speedB,length, handle, tip, block, lunge);
			enemy=player;
			change=player;
		}
		public void control(){
			Sword.setTip(tipChange());
			Sword.setHandle(handleChange());
			x=xChange();
			y=yChange();
		}
		private Point.Double tipChange(){
			Point.Double e=enemy.getSword().getTip();
			Point.Double c=change.getSword().getTip();
			Point.Double move=new Point.Double(-1*(e.getX()-c.getX()),-1*(e.getY()-e.getY()));
			return move;
		}
		private Point.Double handleChange(){
			Point.Double e=enemy.getSword().getHandle();
			Point.Double c=change.getSword().getHandle();
			Point.Double move=new Point.Double(-1*(e.getX()-c.getX()),-1*(e.getY()-e.getY()));
			return move;
		}
		private double xChange(){
			double e=enemy.x;
			double c=change.x;
			double move=e-c;
			return move;
		}
		private double yChange(){
			double e=enemy.x;
			double c=change.x;
			double move=e-c;
			return move;
		}
	}
}