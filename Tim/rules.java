//program: Dr. Evil and Batman with Richard Dean Anderson star in: Fencing Symulator 2K18: Stabby Mc Kill Die Too: Electric Boogaloo: The Phantom Menace: Attack of the Clones: Revenge of the Sith: Wrath of Khan Part 2: Dead Man’s Chest: The third one, part 7 of 9 in the trilogy: Prequel to the Quran, by Sun Tzu and Robert Munch With Samuel L Jackson as “God” Based on a true story as told by Tommy Wiseau
package Tim;
public class rules {
	public static boolean whoP(Fencer player,Fencer ai){
		boolean point;//true player  false ai
		if(player.bladeHit()==true &&ai.bladeHit==false){
			point=true;
		}else if(player.bladeHit()==false &&ai.bladeHit==true){
			point=false;
		}else{
			if(player.getLungeCoolDown()>ai.getLungeCoolDown()){
				point=true;
			}else{
				point=false;
			}
			if(player.xSpeed()>ai.xSpeed){
				point=true;
			}else{
				point=false;
			}
			if(player.getBlockCoolDown()>ai.getBlockCoolDown()){
				point=true;
			}else{
				point=false;
			}
		}

	}
	public static int win(char gameMode,Fencer player,Fencer ai){
		int w=0;//0 no win, 1 player win, 2 ai win
		switch(gameMode){
			case 'f':if(player.getScore()=5){w=1;}else if(ai.getScore()=5){w=2;}break;
			case 'F':break;
			case 'e':if(player.getScore()=5){w=1;}else if(ai.getScore()=5){w=2;}break;
			case 'E':break;
		}
		return w;
	}
}//end class