 package prog.unknown_hero.core;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Sender;

public class UIOperation {

	public static void setPlayerHandCards() {
		
	}
	
	public static void setPlayerHero() {
		
	}
	
	public static void setPlayerHP() {
		
	}
	
	public static void setPlayerAP() {
		
	}
	
	public static void setPlayerDP() {
		
	}
	
	public static void setPlayerWeapon() {
		
	}
	
	public static void setInformation(String info) {
		Sender.send(new BaseMessage("INFO", info));
	}
	
	public static void setPlayerHandCardsNum() {
		Sender.send();
	}
	
	
	
}
