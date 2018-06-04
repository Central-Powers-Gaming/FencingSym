//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
import javax.imageio.ImageIO;
import javax.swing.*;

import character.Fencer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
class batl extends JPanel implements KeyListener{
	static final int Tw=Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int Th=Toolkit.getDefaultToolkit().getScreenSize().height;
	static Fencer[] grand;
	public batl(){
		repaint();
		setFocusable( true );
		this.addKeyListener(this);	
		grand=itz();
	}	
	public void keyPressed (KeyEvent event) {
		System.out.println("Hi Key");
	    if (event.getKeyCode() == KeyEvent.VK_D) {
	    	grand[0].x+=grand[0].getSpeed();
	    }
	    if (event.getKeyCode() == KeyEvent.VK_A) {
	    	grand[0].x-=grand[0].getSpeed();
	    }
	}
	public void keyReleased(KeyEvent e){}
	public void keyTyped(KeyEvent e){}
	
	public void paint(Graphics g){ 
		System.out.println("Hi");
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Tw,Th);
		int a=cal();
		BufferedImage back=null;
		BufferedImage Star=null;
		BufferedImage StarFill=null;
		BufferedImage cross=null;
		try{//pics in
			back = ImageIO.read(new File("backOlimp.png"));//backOlimp.png   backFire.png   endor.png
			Star = ImageIO.read(new File("Star.png"));
			StarFill = ImageIO.read(new File("StarFill.png"));
			cross=ImageIO.read(new File("target.png"));
		} catch(Exception e){e.printStackTrace();}
		
		g.drawImage(back, 0,(Th-a)/2, Tw, a, null);
		g.setColor(Color.BLUE);
		//Score board
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).95)), Tw-(int)(2*(Tw-(Tw*(double).9))), Th/20);
		//player timers
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.fillRect((int)(Tw-(Tw*(double).9))+200, (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		//ai timers
		g.fillRect((int)(Tw-(Tw-(Tw*(double).9))), (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.fillRect((int)(Tw-(Tw-(Tw*(double).9))-200), (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		for(int i=0;i<10;i++){
			if(i<5){
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}else{
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-500+(100*(i-5)), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}
		}
		//points
		for(int i=/*player.getScore()*/5;i>0;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+(500)-(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		for(int i=/*ai.getScore()*/4+5;i>5;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-500+(100*(i-5))-100, (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 0, 70));
		g.drawString(/*player.getName()*/"Player42",(int)(Tw-(Tw*(double).9)) , (int)(Th-(Th*(double).95)+Th/20+70));
		int l=/*ai.getName().length*/6;
		g.drawString(/*ai.getName()*/"Skynet",(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-41*l, (int)(Th-(Th*(double).95)+Th/20+70));
		
		//~~~~~~~~~~~~~~~~~~~~~~~~Fencer Rendering~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		g.drawImage(grand[0].getPic(0),(int)grand[0].x,(int)grand[0].y,150,155, null);
		//g.drawImage(FncA[0]/*ai.getFrame()*/0],/*ai.x()*/800,/*ai.Y*/480,100,100, null);
		//g.fillRect(x, 470, 100, 100);
		g.drawImage(grand[1].getPic(0),(int)grand[1].x,(int)grand[1].y,150,155, null);
		g.drawImage(cross,(int)Math.round(MouseInfo.getPointerInfo().getLocation().getX())-25,(int)Math.round(MouseInfo.getPointerInfo().getLocation().getY())-25,50,50, null);
		repaint();
	}
	//to maintain an 16:9 aspect ratio on all screens
	private int cal(){
		int a;
		double ratioW;
		ratioW=((double)1600/(double)Tw);
		System.out.println(ratioW);
		System.out.println(Th);
		a=(int)(Math.round(900/ratioW));
		return a;
	}
	private static Fencer[] itz(){
		BufferedImage[] FncP=new BufferedImage[5] ;
		for(int i=0;i<5;i++){
			try {
				FncP[i] = ImageIO.read(new File("f"+(i+1)+".png"));
			}catch (IOException e) {e.printStackTrace();}
		}
		Fencer player=new Fencer(FncP,"Player",2,Tw/3,Th*(0.60185185),155,150,"A",3,new java.awt.geom.Point2D.Double(Tw/3/2,410+150) , new java.awt.geom.Point2D.Double(Tw/3/2+100,410+150), 5, 10,null);
		//ai
		BufferedImage[] FncA=new BufferedImage[5] ;
		for(int i=0;i<5;i++){
			try {
				FncA[i] = ImageIO.read(new File("a"+(i+1)+".png"));
			}catch (IOException e) {e.printStackTrace();}
		}
		Fencer ai=new Fencer(FncA,"AI",2,Tw*2/3,Th*(0.60185185),155,150,"A",3,new java.awt.geom.Point2D.Double(Tw/3,410+150) , new java.awt.geom.Point2D.Double(Tw/3+100,410+150), 5, 10,null);
		Fencer[] m=new Fencer[2];
		m[0]=player;
		m[1]=ai;
		return m;
	}
}//end class
public class battleScreen {		
	public static void toBattle(){
		JFrame battle=new JFrame();
		JPanel pane=(JPanel)battle.getContentPane();
		pane.add(new batl());
		battle.setSize(batl.Tw,batl.Th);
		battle.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		battle.setUndecorated(true);
		battle.setVisible(true);
	
	}
}//end class