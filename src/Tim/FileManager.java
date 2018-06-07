package Tim;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FileManager {
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width;//width of screen
	static int l = Toolkit.getDefaultToolkit().getScreenSize().height;//height of screen
	private static JButton btnLS1  = new JButton();//each of these buttons will be used to access the 8 different save files
	private static JButton btnLS2  = new JButton();
	private static JButton btnLS3  = new JButton();
	private static JButton btnLS4  = new JButton();
	private static JButton btnLS5  = new JButton();
	private static JButton btnLS6  = new JButton();
	private static JButton btnLS7  = new JButton();
	private static JButton btnLS8  = new JButton();
	private static final String[] files={"FencingSym_1.txt","FencingSym_2.txt","FencingSym_3.txt","FencingSym_4.txt","FencingSym_5.txt","FencingSym_6.txt","FencingSym_7.txt","FencingSym_8.txt"};//this holds the file names for each save file IMPORTANT
	public static JFrame main=new JFrame("Fencing Simulator 2K18");//container for the menu
	private static JLabel back=new JLabel();//will be used for backround
	private static JLabel lblText=new JLabel();//propts user to make a selection
	private static JPanel panel=new JPanel();//panel to hold buttons
	
	
	
	//name: loadSave
	//parameters: String
	//Returns: GameSave
	//Dependencies: java.util.*; java.IO.*;
	//Last Modified: June 6, 2018
	//throws: none
	//Description: takes in information from file to set up a previously started game from where it left off
	private static GameSave loadSave(String flname){
		GameSave nm=new GameSave();
		FileInputStream FileIn; // create a file input object
		BufferedReader In; // create an Input stream object
		try {
			FileIn = new FileInputStream(flname);
			In = new BufferedReader(new FileReader(flname));
			boolean[] a=new boolean[nm.items.length];
			String hold="false";
			while (In.ready() == true){
				nm.setpName(In.readLine());
				nm.setScore(Integer.parseInt(In.readLine()));
				nm.setLevelP(Integer.parseInt(In.readLine()));
				for(int i=0;i<a.length;i++){
					if(In.ready()==true){
					hold=In.readLine();
						if(hold.equals("true")){
							a[i]=true;
						}
						else{
							a[i]=false;
						}
					}					
					hold="false";
				}
				nm.setItems(a);
			}
			In.close();
		}
		catch (FileNotFoundException e){
			JOptionPane.showMessageDialog(null, "This file is empty", "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "ERROR", JOptionPane.WARNING_MESSAGE);
		}
		return nm;
		
	}
	//name: initialize
	//parameters: none
	//Returns: none
	//Dependencies: back, main
	//Last Modified: June 6th 2018
	//throws: none
	//Description: sets up all the buttons, label, and background
	private static void initialize(){
		//creates the backround image for the frame
		back.setLayout(new BorderLayout());
		try{
	    	back.setIcon(new ImageIcon(ImageIO.read(new File("backFire.png"))));
	    	main.setContentPane(back);
	    }catch(IOException e){
	    	e.printStackTrace();
	    }		
		
		//panel.setLayout(new BorderLayout());
		
		btnLS1.setBounds(0, 0, 50, 30);//sets the sizes of the buttons
		btnLS2.setBounds(0, 0, 50, 30);
		btnLS3.setBounds(0, 0, 50, 30);
		btnLS4.setBounds(0, 0, 50, 30);
		btnLS5.setBounds(0, 0, 50, 30);
		btnLS6.setBounds(0, 0, 50, 30);
		btnLS7.setBounds(0, 0, 50, 30);
		btnLS8.setBounds(0, 0, 50, 30);
		
		lblText.setBounds(0, 0, 100, 30);//sets the lable dimensions
		
		//sets up label
		Font f=new Font("Impact", 0, 25);
		lblText.setBackground(null);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(f);
		lblText.setText("Choose save file to load.");
		
		btnLS1.setText(files[0]);//renames each button to their corrisponding file names
		btnLS2.setText(files[1]);
		btnLS3.setText(files[2]);
		btnLS4.setText(files[3]);
		btnLS5.setText(files[4]);
		btnLS6.setText(files[5]);
		btnLS7.setText(files[6]);
		btnLS8.setText(files[7]);
		
		
		btnLS1.setBackground(Color.RED);//sets button backrounds
		btnLS2.setBackground(Color.RED);
		btnLS3.setBackground(Color.RED);
		btnLS4.setBackground(Color.RED);
		btnLS5.setBackground(Color.RED);
		btnLS6.setBackground(Color.RED);
		btnLS7.setBackground(Color.RED);
		btnLS8.setBackground(Color.RED);
		
		btnLS1.setForeground(Color.BLACK);//sets button foregrounds
		btnLS2.setForeground(Color.BLACK);
		btnLS3.setForeground(Color.BLACK);
		btnLS4.setForeground(Color.BLACK);
		btnLS5.setForeground(Color.BLACK);
		btnLS6.setForeground(Color.BLACK);
		btnLS7.setForeground(Color.BLACK);
		btnLS8.setForeground(Color.BLACK);
		
		//makes panel background invisible
		panel.setOpaque(false);
		
		panel.add(btnLS1, BorderLayout.CENTER);//add buttons to panel
		panel.add(btnLS2, BorderLayout.CENTER);
		panel.add(btnLS3, BorderLayout.CENTER);
		panel.add(btnLS4, BorderLayout.CENTER);
		panel.add(btnLS5, BorderLayout.CENTER);
		panel.add(btnLS6, BorderLayout.CENTER);
		panel.add(btnLS7, BorderLayout.CENTER);
		panel.add(btnLS8, BorderLayout.CENTER);
		
		main.add(lblText, BorderLayout.SOUTH);//adds lablel to frame
		main.add(panel, BorderLayout.CENTER);//adds panel to frame
		main.setBackground(null);//makes default frame background invisible
		
		btnLS1.setVisible(true);//makes everything visible
		btnLS2.setVisible(true);
		btnLS3.setVisible(true);
		btnLS4.setVisible(true);
		btnLS5.setVisible(true);
		btnLS6.setVisible(true);
		btnLS7.setVisible(true);
		btnLS8.setVisible(true);
		
		lblText.setVisible(true);
	    
	    
	    main.setResizable(false);//user can no longer manipulate the size of the frame
	    main.pack();
	    main.setVisible(true);	    
	}
	//name: start
	//parameters: none
	//Returns: none
	//Dependencies: w, l, main, java.awt.*;
	//Last Modified: June 6th 2018
	//throws: none
	//Description: sets up and starts entire GUI
	private static void start(){
		main.setSize(w, l);
		main.setLocation(new Point(0,0));
		main.setLayout(new BorderLayout());
		main.setResizable(false);
		Dimension size = new Dimension(300, 250);
		main.setPreferredSize(size);
	    main.pack();
	    main.setVisible(true);
	    initialize();
		initEvent();	   
	}
	//name: initEvent
	//parameters: none
	//Returns: none
	//Dependencies: main, loadsave, java.awt.*;
	//Last Modified: June 6th 2018
	//throws: none
	//Description: checks for and reacts to button clicks and exiting
	private static void initEvent(){

	    main.addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e){
	       main.setVisible(false);
	      }
	    });
	    
	    btnLS1.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[0]);
		      }
		});
	    btnLS2.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[1]);
		      }
		});
	    btnLS3.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[2]);
		      }
		});
	    btnLS4.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[3]);
		      }
		});
	    btnLS5.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[4]);
		      }
		});
	    btnLS6.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[5]);
		      }
		});
	    btnLS7.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[6]);
		      }
		});
	    btnLS8.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	loadSave(files[7]);
		      }
		});
	    
	}
	//name: FileManager
	//parameters: none
	//Returns: none
	//Dependencies: start
	//Last Modified: june 6th 2018
	//throws: none
	//Description: constructor for object
	FileManager(){
		start();
	}
	
		
	
	
		
}
