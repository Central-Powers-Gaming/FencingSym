//Author: Timothy Barrett
//Date Created: June. 1, 2018
//Last modified: June. 14, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
import javax.imageio.ImageIO;
import javax.swing.*;
import Ai.*;
import character.Fencer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
class batl extends JPanel implements KeyListener, MouseListener{
	static final int Tw=Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int Th=Toolkit.getDefaultToolkit().getScreenSize().height;
	static Fencer player;
	static RANDOM ai;
	static double frames=0;	
	static double time=System.currentTimeMillis();
	static int level;
	static Boolean toJump=false;
	static Boolean AitoJump=false;
	public batl(int level){
		setFocusable( true );
		this.addKeyListener(this);	
		this.addMouseListener(this);
		this.level=level;
		player=itz(0);
		ai=itz2(0,level);
		repaint();
	}
	/*name: mouseClicked 
	parameters:MouseEvent arg0
	returns: none
	dependencies: fencer, java.java.awt.event.*;
	Last Modified:June 5, 2018
	throws: none
	description: lunges if mouse clicked
	*/
	public void mouseClicked(MouseEvent arg0){		
		if(player.getSword().getLungeCD()<=0){
			if(player.x+150+100<Tw){
				player.x+=100;
			}
			player.lunge(ai);
			player.frame=4;
			player.getSword().setLungeCD(player.getSword().getLunge());
		}
	}
	/*not used*/public void keyReleased(KeyEvent e){}public void keyTyped(KeyEvent e){}public void mousePressed(MouseEvent event){}public void mouseEntered(MouseEvent arg0) {}public void mouseExited(MouseEvent arg0){}public void mouseReleased(MouseEvent arg0) {}
	/*name: keyPressed 
	parameters:KeyEvent event
	returns: none
	dependencies: fencer, java.java.awt.event.*;
	Last Modified:June 5, 2018
	throws: none
	description: mover player with wasd
	*/
	public void keyPressed (KeyEvent event) {
		//System.out.println("Hi Key");
	    if (event.getKeyCode() == KeyEvent.VK_D) {
	    	if(player.x+150<Tw){
	    		player.move(true);
	    		if(toJump==true){
	    			player.x+=2;
	    		}
	    	}else{
	    		ai.setScore(ai.getScore()+1);
	    		player=itz(player.getScore());
	    		ai=itz2(ai.getScore(),level);
	    	}
	    	if(player.frame<4){
	    		player.frame++;
	    	}else{
	    		player.frame=0;	
	    	}
	    }
	    if (event.getKeyCode() == KeyEvent.VK_A) {
	    	if(player.x>0){
	    		player.move(false);
	    		if(toJump==true){
	    			player.x-=2;
	    		}
	    	}else{
	    		ai.setScore(ai.getScore()+1);
	    		player=itz(player.getScore());
	    		ai=itz2(ai.getScore(),level);
	    	}
	    	if(player.frame>0){
	    		player.frame--;
	    	}else{
	    		player.frame=4;	
	    	}
	    }
	    if (event.getKeyCode() == KeyEvent.VK_W){
	    	toJump=true;
	    	player.jump();	
	    }
	    if (event.getKeyCode() == KeyEvent.VK_ESCAPE){
	    	int ans=JOptionPane.showOptionDialog(this, "Do you whish to return to the menu? Any progress will be lost.", "Confirmation", 0, 1,null,null,null);
	    	//System.out.println("ans~~~~~~~~~~~~~~~~~~~ "+ans);
	    	if(ans==0){
	    		Main.main.setAlwaysOnTop(true);
	    		Main.main.setVisible(true);
	    		this.setSize(0, 0);
	    		this.setOpaque(false);
	    		this.setVisible(false);
	    	}
	    }
	}
	/*name: whoP
	parameters:Fencer player,Ai ai
	returns: boolean point
	dependencies: fencer,AI 
	Last Modified:June 10, 2018
	throws: none
	description: uses rules of fencing priority to determine who gets the point
	*/
	public static boolean whoP(Fencer player,RANDOM ai){
		boolean point;//true player  false ai
		if(ai.hit(player.getSword().tip)==true &&player.hit(ai.getSword().tip)==false){
			point=true;
		}else if(ai.hit(player.getSword().tip)==false &&player.hit(ai.getSword().tip)==true){
			point=false;
		}else{
			if(player.getSword().getLungeCD()<ai.getSword().getLungeCD()){
				point=true;
			}else{
				point=false;
			}
			if(player.getSpeed()>ai.getSpeed()){
				point=true;
			}else{
				point=false;
			}
			if(player.getSword().getBlockCD()>ai.getSword().getBlockCD()){
				point=true;
			}else{
				point=false;
			}
		}
		return point;
	}
	/*name: paint
	parameters:Graphics g
	returns: none
	dependencies: fencer,AI ,java.io,javax.swing,java.awt
	Last Modified:June 13, 2018
	throws: none
	description: all graphics and interactions
	*/
	public void paint(Graphics g){ 
		frames++;
		//System.out.println("Hi");
		g.setColor(Color.BLACK);
		g.fillRect(0,0,Tw,Th);
		g.setPaintMode();
		int a=cal();
		boolean go=false;
		int hit=0;
		BufferedImage back=null;
		BufferedImage Star=null;
		BufferedImage StarFill=null;
		BufferedImage cross=null;
		//System.out.println("Lunge~~~~~~~~~~~: " +player.getSword().getLungeCD());
		if(player.getSword().getLungeCD()>0){
			player.getSword().setLungeCD(player.getSword().getLungeCD()-1);
		}
		if(go==false){
			try{//pics in
				switch(level){
					case 1: back = ImageIO.read(new File("backFire.png"));break;//backOlimp.png   backFire.png   endor.png
					case 2: back = ImageIO.read(new File("endor.png"));break;//backOlimp.png   backFire.png   endor.png
					case 3: back = ImageIO.read(new File("backOlimp.png"));break;//backOlimp.png   backFire.png   endor.png
				}
				Star = ImageIO.read(new File("Star.png"));
				StarFill = ImageIO.read(new File("StarFill.png"));
				cross=ImageIO.read(new File("target.png"));
				go=true;
			} catch(Exception e){e.printStackTrace();go=false;}
		}
		g.drawImage(back, 0,(Th-a)/2, Tw, a, null);
		g.setColor(Color.BLUE);
		//Score board~~~~~~~~~~~~~~~~~~~~~
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).95)), Tw-(int)(2*(Tw-(Tw*(double).9))), Th/20);
		//player timers~~~~~~~~~~~~~~~~~~
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.fillRect((int)(Tw-(Tw*(double).9))+200, (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.setColor(Color.RED);
		g.fillRect((int)(Tw-(Tw*(double).9)), (int)(Th-(Th*(double).1)), (int)((Tw-(2*(Tw-(Tw*(double).9))))/10)-player.getSword().getLungeCD()*(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)/player.getSword().getLunge(), Th/20);
		g.fillRect((int)(Tw-(Tw*(double).9))+200, (int)(Th-(Th*(double).1)),(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)-player.getSword().getBlockCD()*(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)/player.getSword().getBlock(), Th/20);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 0, 30));
		g.drawString("Lunge",(int)(Tw-(Tw*(double).9)), (int)((Th-(Th*(double).1))+(Th/20)*1.7));
		g.drawString("Block",(int)(Tw-(Tw*(double).9))+200, (int)((Th-(Th*(double).1))+(Th/20)*1.7));
		//ai timers~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		g.setColor(Color.BLUE);
		g.fillRect((int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10, (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.fillRect((int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10-200, (int)(Th-(Th*(double).1)), (Tw-(int)(2*(Tw-(Tw*(double).9))))/10, Th/20);
		g.setColor(Color.RED);
		g.fillRect((int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10, (int)(Th-(Th*(double).1)), (int)((Tw-(2*(Tw-(Tw*(double).9))))/10)-ai.getSword().getLungeCD()*(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)/ai.getSword().getLunge(), Th/20);
		g.fillRect((int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10-200, (int)(Th-(Th*(double).1)),(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)-ai.getSword().getBlockCD()*(int)((Tw-(2*(Tw-(Tw*(double).9))))/10)/ai.getSword().getBlock(), Th/20);
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 0, 30));
		g.drawString("Lunge",(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10-200, (int)((Th-(Th*(double).1))+(Th/20)*1.7));
		g.drawString("Block",(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-(Tw-(int)(2*(Tw-(Tw*(double).9))))/10, (int)((Th-(Th*(double).1))+(Th/20)*1.7));
		for(int i=0;i<10;i++){
			if(i<5){
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}else{
				g.drawImage(Star,(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-500+(100*(i-5)), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
			}
		}
		//points~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		for(int i=player.getScore();i>0;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+(500)-(100*i), (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		for(int i=ai.getScore()+5;i>5;i--){
			g.drawImage(StarFill,(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-500+(100*(i-5))-100, (int)(Th-(Th*(double).95))-(int)(Th-(Th*(double).95))-Th/100, 100, 100, null);
		}
		g.setColor(Color.WHITE);
		g.setFont(new Font("Courier New", 0, 70));
		g.drawString(player.getName(),(int)(Tw-(Tw*(double).9)) , (int)(Th-(Th*(double).95)+Th/20+70));
		int l=ai.getName().length();
		g.drawString(ai.getName(),(int)(Tw-(Tw*(double).9))+Tw-(int)(2*(Tw-(Tw*(double).9)))-41*l, (int)(Th-(Th*(double).95)+Th/20+70));
		//~~~~~~~~~~~~~~~~~~~~~~~~Blade Rendering~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		g.setColor(Color.GRAY);
		player.getSword().length=100;
		ai.getSword().length=100;
		//player
		if(player.getSword().isControl()==true){
			if(player.getSword().getTip().x<player.x-155){
				player.getSword().setTip(new Point.Double(player.getSword().getTip().x+100,player.getSword().getTip().y));
			}
		}
		player.getSword().setHandle(new Point.Double(player.x+148,player.y+45));
		player.getSword().bladeMove((int)Math.round(MouseInfo.getPointerInfo().getLocation().getX())-25,(int)Math.round(MouseInfo.getPointerInfo().getLocation().getY())-25);
		g.drawLine((int)player.getSword().getHandle().x, (int)player.getSword().getHandle().y, (int)player.getSword().getTip().x,(int) player.getSword().getTip().y);
		//ai
		ai.getSword().setHandle(new Point.Double(ai.x,ai.y+43));
		if(ai.getSword().getTip().x>ai.x){
			ai.getSword().setTip(new Point.Double(ai.getSword().getTip().x-100,ai.getSword().getTip().y));
		}
		//System.out.println(player.getSword().getHandle().x+" "+player.getSword().getHandle().y+" "+player.getSword().getTip().x+" "+player.getSword().getTip().y);
		g.drawLine((int)ai.getSword().getHandle().x, (int)ai.getSword().getHandle().y, (int)ai.getSword().getTip().x,(int) ai.getSword().getTip().y);
		//~~~~~~~~~~~~~~~~~~~~~~~~Fencer Rendering~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		if(toJump==true){
			toJump=player.jump();
		}
		g.drawImage(player.getPic(player.frame),(int)player.x,(int)player.y,150,155, null);
		g.drawImage(ai.getPic(ai.frame),(int)ai.x,(int)ai.y,150,155, null);
		g.drawImage(cross,(int)Math.round(MouseInfo.getPointerInfo().getLocation().getX())-25,(int)Math.round(MouseInfo.getPointerInfo().getLocation().getY())-25,50,50, null);
		//
		//ai move
		AitoJump=ai.control(player);
		if(AitoJump==true){
			AitoJump=ai.jump();
		}
		//~~~~~~~~~~~~~~~~~~~~~~~~Colisions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		player.getSword().colisionBlade(player.getSword(),ai.getSword());
		ai.getSword().colisionBlade(ai.getSword(),player.getSword());
		player.hit(ai.getSword().tip);
		if(ai.hit(player.getSword().tip)==true||player.hit(ai.getSword().tip)==true){
			boolean q=whoP(player,ai);
			if(q==true){
				player.setScore(player.getScore()+1);
			}else{
				ai.setScore(ai.getScore()+1);
			}
			player=itz(player.getScore());
			ai=itz2(ai.getScore(),level);
			toJump=false;
			AitoJump=false;
		}
		//end check
		if(player.getScore()>=5){
			go=true;
			level++;
			player=itz(0);
			ai=itz2(0,level);
		}
		else if(ai.getScore()>=5){
			go=false;
    		Main.main.setAlwaysOnTop(true);
    		Main.main.setVisible(true);
    		this.setSize(0, 0);
    		this.setOpaque(false);
    		this.setVisible(false);
		}
		if(go==true){
			repaint();
		}else{
			go=true;
			level++;
			player=itz(0);
			ai=itz2(0,level);			
		}	
		//fps
		frames++;
		if((System.currentTimeMillis()-time)/1000>=1){
			System.out.println("Frames per sec: "+frames);
			frames=0;
			time=System.currentTimeMillis();
		}		
	}
	/*name: paint
	parameters:none
	returns: int a
	dependencies: Tw, Th
	Last Modified:June 1, 2018
	throws: none
	description: to maintain an 16:9 aspect ratio on all screens
	*/
	private int cal(){
		int a;
		double ratioW;
		ratioW=((double)1600/(double)Tw);
		//System.out.println(ratioW);
		//System.out.println(Th);
		a=(int)(Math.round(900/ratioW));
		return a;
	}
	/*name: itz
	parameters:int hold
	returns: Fencer player
	dependencies: Fencer
	Last Modified:June 3, 2018
	throws: none
	description: initializes player
	*/
	private static Fencer itz(int hold){
		BufferedImage[] FncP=new BufferedImage[5] ;
		for(int i=0;i<5;i++){
			try {
				FncP[i] = ImageIO.read(new File("f"+(i+1)+".png"));
			}catch (IOException e) {e.printStackTrace();}
		}
		Fencer player=new Fencer(FncP, "Player", 3, Tw/3,Th*(0.60185185), 155,150,"A",10, 100, new Point.Double(Tw/3+155-5,Th*(0.60185185)+43) , new Point.Double(Tw/3+155+100-5,Th*(0.60185185)+43), 10, 10);
		player.frame=0;
		player.setGround(Th*(0.743537037));
		player.setScore(hold);
		return player;
	}
	/*name: itz2
	parameters:int hold, int level
	returns: AI ai
	dependencies: AI
	Last Modified:June 3, 2018
	throws: none
	description: initializes ai
	*/
	public static RANDOM itz2(int hold,int level){
		//ai
		BufferedImage[] FncA=new BufferedImage[5] ;
		for(int i=0;i<5;i++){
			try {
				FncA[i] = ImageIO.read(new File("a"+(i+1)+".png"));
			}catch (IOException e) {e.printStackTrace();}
		}
		//System.out.println("level                "+level);
			RANDOM ai=new RANDOM(3,FncA,"RANDOM","AI",2,100,Tw*2/3,Th*(0.60185185),155,150,"A",100,new Point.Double(Tw*2/3,Th*(0.60185185)+43) , new Point.Double(Tw*2/3-100,Th*(0.60185185)+43), 5, 10);
			//case 2:ai=new AI(3,FncA,"EASY","AI",2,100,Tw*2/3,Th*(0.60185185),155,150,"A",100,new Point.Double(Tw*2/3,Th*(0.60185185)+43) , new Point.Double(Tw*2/3-100,Th*(0.60185185)+43), 5, 10);break;
			//default: ai=new AI(3,FncA,"MIRROR","AI",2,100,Tw*2/3,Th*(0.60185185),155,150,"A",100,new Point.Double(Tw*2/3,Th*(0.60185185)+43) , new Point.Double(Tw*2/3-100,Th*(0.60185185)+43), 5, 10);break;
			
		
		ai.frame=0;
		ai.setGround(Th*(0.743537037));
		ai.setScore(hold);
		return ai;
	}
}//end class
public class battleScreen {	
	/*name: toBattle()
	parameters:none
	returns: none
	dependencies: javax.swing,java.awt
	Last Modified:June 3, 2018
	throws: none
	description: initializes game
	*/
	public static void toBattle(){
		JFrame battle=new JFrame();
		JPanel pane=(JPanel)battle.getContentPane();
		pane.add(new batl(0));
		battle.setSize(batl.Tw,batl.Th);
		battle.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		battle.setUndecorated(true);
		battle.setVisible(true);
	}
}//end class