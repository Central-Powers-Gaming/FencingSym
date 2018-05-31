//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
import java.awt.FileDialog;
import java.io.*;
import javax.swing.JFrame;
import sun.audio.*;
public class FileIo {
	public FileIo(){};
	public static LinkedList inScore(){
		//name: in
		//parameters: none
		//Returns: char[][] nm
		//Dependencies: import java.io.*;
		//Last Modified: Apr 07 2018
		//throws: none
		//Description: loads array from file
		LinkedList nm=new LinkedList();
		FileInputStream FileIn; // create a file input object
		BufferedReader In; // create an Input stream object
		String flname;
		//Runtime.getRuntime().exec("explorer.exe /select," );
		FileDialog fd = new FileDialog(new JFrame());
		fd.setVisible(true);
		File[] f = fd.getFiles();
		if(f.length > 0){
		    System.out.println(fd.getFiles()[0].getAbsolutePath());
		}
		flname=String.valueOf(f[0]);//get file
		try {
			FileIn = new FileInputStream(flname);
			In = new BufferedReader(new FileReader(flname));
			while (In.ready() == true){
				nm.insert(In.readLine(),Integer.parseInt(In.readLine()));
			}
			In.close();
		}
		catch (FileNotFoundException e){
			System.out.println("Error - this file does not exist");
		}
		catch (IOException e) {
			System.out.println("error=" + e.toString());
		}
		return nm;
	}
	public void saveH(LinkedList nm){
		//name: save
		//parameters: String[] sv
		//Returns: void
		//Dependencies: import java.io.*;
		//Last Modified: Dec 20 2016
		//throws: IOException iox
		//Description: saves array to file
		String flname;
		String[] ar;
		FileDialog fd = new FileDialog(new JFrame());
		fd.setVisible(true);
		File[] f = fd.getFiles();
		if(f.length > 0){
		    System.out.println(fd.getFiles()[0].getAbsolutePath());
		}
		flname=String.valueOf(f[0]);//get file
		fd.removeAll();
		fd.dispose();

		try{
			FileOutputStream outFile;
			PrintWriter outputFile;
			outFile = new FileOutputStream(flname);
			outputFile=new PrintWriter(outFile);
			ar=nm.getElements();
			for(int i=0;i<ar.length;i++){
				outputFile.println(ar[i]);
			}

			outputFile.close();

		}
	 	catch ( IOException iox ){
			System.out.println("Problem writing " + flname);
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public GameSave inGame(){
		//name: in
		//parameters: none
		//Returns: char[][] nm
		//Dependencies: import java.io.*;
		//Last Modified: Apr 07 2018
		//throws: none
		//Description: loads array from file
		GameSave nm=new GameSave();
		FileInputStream FileIn; // create a file input object
		BufferedReader In; // create an Input stream object
		String flname;
		//Runtime.getRuntime().exec("explorer.exe /select," );
		FileDialog fd = new FileDialog(new JFrame());
		fd.setVisible(true);
		File[] f = fd.getFiles();
		if(f.length > 0){
		    System.out.println(fd.getFiles()[0].getAbsolutePath());
		}
		flname=String.valueOf(f[0]);//get file
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
			System.out.println("Error - this file does not exist");
		}
		catch (IOException e) {
			System.out.println("error=" + e.toString());
		}
		return nm;
	}
	public static void saveGame(GameSave nm){
		//name: save
		//parameters: String[] sv
		//Returns: void
		//Dependencies: import java.io.*;
		//Last Modified: Dec 20 2016
		//throws: IOException iox
		//Description: saves array to file
		String flname;
		String[] ar;
		//Runtime.getRuntime().exec("explorer.exe /select," );
		FileDialog fd = new FileDialog(new JFrame());
		fd.setVisible(true);
		File[] f = fd.getFiles();
		if(f.length > 0){
		    System.out.println(fd.getFiles()[0].getAbsolutePath());
		}
		flname=String.valueOf(f[0]);//get file
		try{
			FileOutputStream outFile;
			PrintWriter outputFile;
			boolean[] a=new boolean[nm.items.length];
			outFile = new FileOutputStream(flname);
			outputFile=new PrintWriter(outFile);
			outputFile.println(nm.getpName());
			outputFile.println(nm.getScore());
			outputFile.println(nm.getLevelP());
			a=nm.getItems();
			for(int i=0;i<nm.items.length;i++){
				if(a[i]==true){
					outputFile.println("true");
				}else{
					outputFile.println("false");
				}
			}
			outputFile.close();
		}
	 	catch ( IOException iox ){
			System.out.println("Problem writing " + flname);
		}
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	public void music(String title) {       
        AudioPlayer MGP = AudioPlayer.player;
        AudioStream BGM;
        AudioData MD;
        ContinuousAudioDataStream loop = null;
        try
        {
            InputStream test = new FileInputStream(title);
            BGM = new AudioStream(test);
            AudioPlayer.player.start(BGM);
        }
        catch(FileNotFoundException e){
            System.out.print(e.toString());
        }
        catch(IOException error)
        {
            System.out.print(error.toString());
        }
        MGP.start(loop);
    }
}