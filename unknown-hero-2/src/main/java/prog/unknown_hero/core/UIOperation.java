 package prog.unknown_hero.core;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Sender;

public class UIOperation {
	
	public static void initialized(int myOrder) {
		Sender.send(new BaseMessage("INITED", Integer.toString(myOrder)));
	}
	
	public static void setPlayerList(int[] playerList) {
		StringBuffer s = new StringBuffer("");
		for(int i=0; i<4; i++) {
			if(i != 0) {
				s.append(",");
			}
			s.append(playerList[i]);
		}
		Sender.send(new BaseMessage("LIST", s.toString()));
	}

	public static void setPlayerHandCards(int[] cards) {
		StringBuffer s = new StringBuffer("");
		for(int c : cards) {
			s.append(c);
			s.append(",");
		}
		s.deleteCharAt(s.length()-1);
		Sender.send(new BaseMessage("SETHAND", s.toString()));
	}
	
	public static void setPlayerHero(int player, int card) {
		Sender.send(new BaseMessage("SETHERO", player+","+card));
	}
	
	public static void setPlayerHP(int player, int hp) {
		Sender.send(new BaseMessage("SETHP", player+","+hp));
	}
	
	public static void setPlayerAP(int player, int ap) {
		Sender.send(new BaseMessage("SETAP", player+","+ap));
	}
	
	public static void setPlayerDP(int player, int dp) {
		Sender.send(new BaseMessage("SETDP", player+","+dp));
	}
	
	public static void setPlayerWeapon(int player, int card) {
		Sender.send(new BaseMessage("SETWP", player+","+card));
	}
	
	public static void delPlayerWeapon(int player) {
		Sender.send(new BaseMessage("DELWP", Integer.toString(player)));
	}
	
	public static void setInformation(String info) {
		Sender.send(new BaseMessage("SETINFO", info));
	}
	
	public static void setPlayerHandCardsNum(int player, int num) {
		Sender.send(new BaseMessage("SETHANDN", player+","+num));
	}
	
	public static void useACard(int ithCard) {
		Sender.send(new BaseMessage("USE", Integer.toString(ithCard)));
	}
	
}
