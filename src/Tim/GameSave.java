//Author:Timothy barrett
//Date Created: June. 1, 2018
//Last modified: June. 3, 2018
//Fencing Simulator 2018
//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
/**
* Object that handles relavent save info
* @author Tim
 **/
public class GameSave {
	int score;
	String pName;
	int levelP;
	boolean[] items=new boolean[10];
	/**
	 * @return the score
	 */
	/**
	 * gets score
	 * @author Tim
	 * @param none
	 * @retur in score
	 **/
	public int getScore() {
		return score;
	}
	/**
	 * sets score
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * gets name
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * sets name
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * gets level
	 * @return the levelP
	 */
	public int getLevelP() {
		return levelP;
	}
	/**
	 * sets level
	 * @param levelP the levelP to set
	 */
	public void setLevelP(int levelP) {
		this.levelP = levelP;
	}
	/**
	 * gets items
	 * @return the items
	 */
	public boolean[] getItems() {
		return items;
	}
	/**
	 * sets itmes
	 * @param items the items to set
	 */
	public void setItems(boolean[] items) {
		this.items = items;
	}
	/**
	 *Constructor for class
	 * @author Tim
	 **/
	public GameSave(){};
	public GameSave(String n,int s,int level,boolean[]i){
		pName=n;
		score= s;
		items=i;
		levelP=level;
		
	}
	/**
	 * Prints save info
	 * @author Tim
	 **/
	public void print(){
		System.out.println(pName);
		System.out.println(score);
		System.out.println(levelP);
		for(int i=0;i<items.length;i++){
			System.out.println(items[i]);
		}
	}
}
