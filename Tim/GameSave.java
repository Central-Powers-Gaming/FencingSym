//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
public class GameSave {
	int score;
	String pName;
	int levelP;
	boolean[] items=new boolean[10];
	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * @return the pName
	 */
	public String getpName() {
		return pName;
	}
	/**
	 * @param pName the pName to set
	 */
	public void setpName(String pName) {
		this.pName = pName;
	}
	/**
	 * @return the levelP
	 */
	public int getLevelP() {
		return levelP;
	}
	/**
	 * @param levelP the levelP to set
	 */
	public void setLevelP(int levelP) {
		this.levelP = levelP;
	}
	/**
	 * @return the items
	 */
	public boolean[] getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(boolean[] items) {
		this.items = items;
	}
	public GameSave(){};
	public GameSave(String n,int s,int level,boolean[]i){
		pName=n;
		score= s;
		items=i;
		levelP=level;
		
	}
	public void print(){
		System.out.println(pName);
		System.out.println(score);
		System.out.println(levelP);
		for(int i=0;i<items.length;i++){
			System.out.println(items[i]);
		}
	}
}
