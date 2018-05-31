package MenuPak;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class batl extends JComponent{
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

