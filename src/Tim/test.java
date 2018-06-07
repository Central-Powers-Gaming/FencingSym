//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
public class test {
	public static void fileTest(){
		System.out.println("Get high scores.");
		FileIo hi=new FileIo();
		LinkedList high=new LinkedList();
		high=hi.inScore();
		high.getElements();
		System.out.println("Get save game.");
		GameSave b=new GameSave();
		b=hi.inGame();
		b.print();
	}
	public static void musicTest(String f){
		FileIo hi=new FileIo();
		hi.music("Future Gladiator.wav");
	}
	public static void main(String[] args) {
		fileTest();
		musicTest("Future Gladiator.wav");//"Future Gladiator.wav"    "Neo Western.wav"
	}
}