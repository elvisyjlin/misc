 package prog.unknown_hero.core;

import java.io.IOException;

import prog.unknown_hero.utility.BaseMessage;
import prog.unknown_hero.utility.Replyer;
import prog.unknown_hero.utility.Sender;

public class UIOperation {
	public static boolean start=false;
	public static void initialized(int myOrder) {
		while(!Sender.send(new BaseMessage("INITED", Integer.toString(myOrder)))) continue;
		start=true;
	}

	public static void setPlayerHandCards(int[] cards) {
		StringBuffer s = new StringBuffer("");
		for(int c : cards) {
			s.append(c);
			s.append(",");
		}
		s.deleteCharAt(s.length()-1);
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETHAND", s.toString())));
		checkUIready();
	}
	
	public static void setPlayerHero(int player, int card) {
		//checkSenderIsReady();
		//System.out.println("SETHERO");
		while(!Sender.send(new BaseMessage("SETHERO", player+","+card)))continue;
		checkUIready();
	}
	
	public static void setPlayerHP(int player, int hp) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETHP", player+","+hp)))continue;
		checkUIready();
	}
	
	public static void setPlayerAP(int player, int ap) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETAP", player+","+ap)))continue;
		checkUIready();
	}
	
	public static void setPlayerDP(int player, int dp) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETDP", player+","+dp)))continue;
		checkUIready();
	}
	
	public static void setPlayerWeapon(int player, int card) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETWP", player+","+card)))continue;
		checkUIready();
	}
	
	public static void delPlayerWeapon(int player) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("DELWP", Integer.toString(player))))continue;
		checkUIready();
	}
	
	public static void setInformation(String info) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETINFO", info)))continue;
		checkUIready();
	}
	
	public static void setPlayerHandCardsNum(int player, int num) {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("SETHANDN", player+","+num)))continue;
		checkUIready();
	}
	
	public static void useACard() {
		//checkSenderIsReady();
		while(!Sender.send(new BaseMessage("USE", "null")))continue;
		checkUIready();
	}
	public static void checkUIready(){
		while(Replyer.messages.isEmpty()) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!Replyer.hasMessage()) {				
				continue;
			}else{
				//System.out.println("yes: "+Replyer.get().toString());
			}
		}
		Replyer.clear();
		System.out.println("UIready!");
	}
	
}
