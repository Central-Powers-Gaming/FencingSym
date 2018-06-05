package MenuPak;

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
	private static JButton btnL  = new JButton("LOAD SAVE");//
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
	private static void initEvent(){

	    main.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       System.exit(1);
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
		    	  FileManager l=new FileManager();
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
	private static void help(){
		JOptionPane.showMessageDialog(null, "Actual help will be availible when game is further developed.", "HELP", JOptionPane.INFORMATION_MESSAGE);
	}
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
	}
	private static void loadSave(){
		FileIo hi=new FileIo();
		System.out.println("Get save game.");
		GameSave b=new GameSave();
		b=hi.inGame();
		b.print();
		String hold="";
		hold+=b.getpName()+"\n";
		hold+=b.getLevelP()+"\n";
		hold+=b.getScore()+"\n";
		try{
			JOptionPane.showMessageDialog(null, hold, "Save", JOptionPane.INFORMATION_MESSAGE);
		}catch (Exception e){
			System.out.print("Ooops!");
		}
		
	}
	private static void play(){
		toBattle();
		main.setVisible(false);
	}//end main
	public static void toBattle(){
		JFrame battle=new JFrame();
		JPanel pane=(JPanel)battle.getContentPane();
		pane.add(new batl());
		battle.setSize(w,l);
		battle.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		battle.setUndecorated(true);
		battle.setVisible(true);
		FileIo a=new FileIo();
		//a.music("7.wav");//"Future Gladiator.wav"    "Neo Western.wav"  "7.wav"
	}	
	public static void main(String[] args) {
		start();
	}
}