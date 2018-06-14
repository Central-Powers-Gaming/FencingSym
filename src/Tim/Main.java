package Tim;
//Author: Isaac
//Date Created: June. 1, 2018
//Last modified: June. 14, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.*;
import javax.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;

public class Main {
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width;//width of screen
	static int l = Toolkit.getDefaultToolkit().getScreenSize().height;//height of screen
	public static JFrame main=new JFrame("Fencing Simulator 2K18");//container for the menu
	private static JLabel back=new JLabel();//will be used for backround
	private static JPanel panel=new JPanel();//panel to hold buttons
	private static JButton btnP  = new JButton("PLAY");//button options
	private static JButton btnL  = new JButton("CREDITS");//
	private static JButton btnH  = new JButton("HELP");//
	private static JButton btnE  = new JButton("EXIT");//
	private static JButton btnS  = new JButton("SCORES");//
	private static void initialize(){
		back.setLayout(new BorderLayout());
		try{
	    	back.setIcon(new ImageIcon(ImageIO.read(new File("mainscreen.png"))));
	    	main.setContentPane(back);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }		
		
		btnP.setBounds(0, 0, 50, 30);
		btnE.setBounds(0, 0, 50, 30);
		btnH.setBounds(0, 0, 50, 30);
		btnL.setBounds(0, 0, 50, 30);
		btnS.setBounds(0, 0, 50, 30);
		
		
		btnP.setBackground(Color.RED);
		btnE.setBackground(Color.RED);
		btnH.setBackground(Color.RED);
		btnL.setBackground(Color.RED);
		btnS.setBackground(Color.RED);
		
		btnP.setForeground(Color.BLACK);
		btnE.setForeground(Color.BLACK);
		btnH.setForeground(Color.BLACK);
		btnL.setForeground(Color.BLACK);
		btnS.setForeground(Color.BLACK);
		
		
		panel.setOpaque(false);
		
		panel.add(btnP, BorderLayout.SOUTH);
		panel.add(btnE, BorderLayout.SOUTH);
		panel.add(btnH, BorderLayout.SOUTH);
		panel.add(btnL, BorderLayout.SOUTH);
		panel.add(btnS, BorderLayout.SOUTH);
		
		main.add(panel, BorderLayout.SOUTH);
		main.setBackground(null);
		
	    
	    btnP.setVisible(true);
	    btnH.setVisible(true);
	    btnL.setVisible(true);
	    btnE.setVisible(true);
	    btnS.setVisible(true);
	    
	    
	    main.setResizable(false);
	    main.pack();
	    main.setVisible(true);	    
	}
	/*name: start() 
	parameters:nonne
	returns: none
	dependencies: java.awt.*, javax.swing.*
	Last Modified:June 5, 2018
	throws: none
	description: shows menu
	*/
	private static void start(){
		main.setSize(w, l);
		main.setLocation(new Point(0,0));
		main.setLayout(new BorderLayout());
		main.setResizable(false);
		Dimension size = new Dimension(565, 555);
		main.setPreferredSize(size);
	    main.pack();
	    main.setVisible(true);
	    initialize();
		initEvent();	   
	}
	/*name: initEvent 
	parameters:nonne
	returns: none
	dependencies: java.awt.*, javax.swing.*
	Last Modified:June 5, 2018
	throws: none
	description: button fuctionality
	*/
	private static void initEvent(){
	    main.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       System.exit(0);
	      }
	    });
	    btnE.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	System.exit(0);
		      }
		});
	    btnH.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  help();
		      }
		});
	    btnL.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  loadSave();
		      }
		});
	    btnS.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  readScores();
		      }
		});
	    btnP.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  play();
		      }
		 });
	}
	//help button
	private static void help(){
		JOptionPane.showMessageDialog(null, "Move: ad\nJump: w\nAim: Mouse\nLunge: Left Click ", "HELP", JOptionPane.INFORMATION_MESSAGE);
	}
	//high score button
	private static void readScores(){
		String end="", hold="";
		System.out.println("Get high scores.");
		FileIo hi=new FileIo();
		LinkedList high=new LinkedList();
		high=hi.inScore();
		String[]a= high.getElements();
		for(int i=0;i<a.length;i++){
			hold+=a[i]+"\n";
		}
		try{
			JOptionPane.showMessageDialog(null, hold, "HIGH SCORES", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e){
			System.out.print("Ooops!");
		}		
	}//load save button
	private static void loadSave(){
		FileIo hi=new FileIo();
		//System.out.println("Credits.");
		try{
			int ans=JOptionPane.showOptionDialog(null,"Fencing Simulator 2K18\n   Programed:\nTimothy Barrett\nIsaac Dunn\nBradley Palmer\n   Fencer Sprites:\nAiden Roseborough\n   Art:\nTimothyBarrett\n   UI:\nTimothy Barrett\nIsaac Dunn\n   AI:\nBradley Palmer\n   Software Used:\nEclipse\nPaint\nGimp\nGitHub\nPhotoShop", "Credits", 0, 1,null,null,null);
		}catch (Exception e){
			System.out.print("Ooops!");
		}		
	}
	//play game
	private static void play(){
		JFrame battle=new JFrame();
		JPanel pane=(JPanel)battle.getContentPane();
		pane.add(new batl(1));
		battle.setSize(w,l);
		battle.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		battle.setUndecorated(true);
		battle.setVisible(true);
		main.setVisible(false);
	}//end main
	public static void main(String[] args) {
		FileIo a=new FileIo();
		a.music("Future Gladiator.wav");//"Future Gladiator.wav"    "Neo Western.wav"  "7.wav"
		start();
	}
}