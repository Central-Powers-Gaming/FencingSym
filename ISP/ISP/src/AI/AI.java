package AI;
import java.awt.image.BufferedImage;

import character.Fencer;
import java.awt.Point;
public class AI extends Fencer{
	public AI(String difficulty,String Name, int Speed, BufferedImage sprite, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,BufferedImage blade) {
		super(Name, Speed, sprite, x, y, height, width, NameB, speedB, handle, tip, block, lunge, blade);
		
	}
	private class EASY extends Fencer{
		final int modifier=-10;
		public EASY(String difficulty,String Name, int Speed, BufferedImage sprite, double x, double y, int height, int width, String NameB,int speedB, Point.Double handle, Point.Double tip, int block, int lunge,BufferedImage blade){
			super(Name, Speed, sprite, x, y, height, width, NameB, speedB, handle, tip, block, lunge, blade)
		}
	}
	private class MEDIUM{
		
	}
	private class HARD{
		
	}
	private class MIRROR{
		
	}
}
