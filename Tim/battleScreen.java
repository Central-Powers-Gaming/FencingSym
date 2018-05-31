//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
class batl extends JComponent{
	static final int Tw=Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int Th=Toolkit.getDefaultToolkit().getScreenSize().height;
	public batl(){
		repaint();
	}
	public void paint(Graphics g){
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Tw,Th);
		int a=cal();
		BufferedImage back=null;
		BufferedImage Star=null;
		BufferedImage StarFill=null;
		BufferedImage[] FncP=null;
		BufferedImage[] FncA=null;
		try{//pics in
			back = ImageIO.read(new File("backOlimp.png"));//backOlimp.png   backFire.png   endor.png
			Star = ImageIO.read(new File("Star.png"));
			StarFill = ImageIO.read(new File("StarFill.png"));
			//FncP[0] = ImageIO.read(new File("Star.png"));
			//FncA[0] = ImageIO.read(new File("Star.png"));
		} catch(Exception e){e.printStackTrace();}
		g.drawImage(back, 0,(Th-a)/2, Tw, a, null);
		g.setColor(Color.BLUE);
		//Score board
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).95)), Tw-(int)(2*(Tw-(Tw*(double).9))), Th/20);
		for(int i=0;i<10;i++){
			if(i<5){
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}else{
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+(100*i)+100, (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}
		}
		//points
		for(int i=/*player.getScore()*/1;i>0;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+(500)-(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		for(int i=/*ai.getScore()*/0+5;i>5;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 0, 70));
		g.drawString(/*player.getName()*/"Player42",(int)(Tw-(Tw*(double).9)) , (int)(Th-(Th*(double).95)+Th/20+70));
		int l=/*ai.getName().length*/6;
		g.drawString(/*ai.getName()*/"Skynet",(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-41*l, (int)(Th-(Th*(double).95)+Th/20+70));
		//~~~~~~~~~~~~~~~~~~~~~~~~Fencer Rendering~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		//g.drawImage(FncP[0]/*player.getFrame()*/0],/*player.x()*/400,/*player.Y*/480,100,100, null);
		//g.drawImage(FncA[0]/*ai.getFrame()*/0],/*ai.x()*/800,/*ai.Y*/480,100,100, null);
		g.fillRect(400, 470, 100, 100);
		g.fillRect(800, 470, 100, 100);
	}
	//to maintain an 16:9 aspect ratio on all screens
	private int cal(){
		int a;
		double ratioW;
		ratioW=((double)1600/(double)Tw);
		System.out.println(ratioW);
		a=(int)(Math.round(900/ratioW));
		return a;
	}
}
public class battleScreen {
	static final int Tw=Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int Th=Toolkit.getDefaultToolkit().getScreenSize().height;
	public static void main(String[] args) {
		JFrame battle=new JFrame();
		JPanel pane=(JPanel)battle.getContentPane();
		pane.add(new batl());
		battle.setSize(Tw,Th);
		battle.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		battle.setUndecorated(true);
		battle.setVisible(true);
	}//end main
}