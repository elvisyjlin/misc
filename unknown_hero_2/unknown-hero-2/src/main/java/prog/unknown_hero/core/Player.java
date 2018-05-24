package prog.unknown_hero.core;

import java.util.ArrayList;
import java.util.List;

import prog.unknown_hero.utility.Replyer;

public class Player extends Character{
	int health, hand;
	Weapon wp=null;
	public boolean poi=false;
	List<Card> handcards= new ArrayList<Card>(); 
	Player(int a, int b) {
		super(a, b);
		this.maxHealth();
		this.hand=0;
		handcards.clear();
		//UIOperation.checkUIready();
		System.out.println("UI___SETTING_HERO");
		UIOperation.setPlayerHero(this.status, this.types);
		System.out.println("ply Health: "+this.health);
		UIOperation.setPlayerAP(this.status, this.att);
		UIOperation.setPlayerDP(this.status, this.def);
		UIOperation.setPlayerHandCardsNum(this.status, 0);
		UIOperation.setPlayerHP(this.status, this.health);
		System.out.println("Done!");
	}
	
	public void changeHealth(int sub)
	{
		this.health+=sub;
		if(this.health>this.MAX_HEALTH) this.maxHealth();
	}
	public void maxHealth() {
		this.health=this.MAX_HEALTH;
		
	}
	public int drawCard(List<Card> gameCard, boolean me){
		System.out.println("Now has "+this.hand+" cards.");
		System.out.println("Now has "+this.handcards.size()+" cards.");
		if(this.hand<4)
		{
		boolean no=true;
		int tmpCdNum=0;
		while(no){
			tmpCdNum=(int) (Math.random()*28);
			System.out.print("ram: "+tmpCdNum+", ");
			gameCard.get(tmpCdNum).showStatus();
			if(gameCard.get(tmpCdNum).showStatus()==4){
				no=false;
			}
		}
		gameCard.get(tmpCdNum).changeStatus(this.showStatus());
		this.hand++;
		this.handcards.add(gameCard.get(tmpCdNum));
		int[] sent_out_card=new int[this.hand];
		for(int i=0; i<this.hand; i++){
			sent_out_card[i]=this.handcards.get(i).num;
			System.out.print(sent_out_card[i]+",");
		}
		System.out.println();
		Replyer.clear();
		if(me)
			UIOperation.setPlayerHandCards(sent_out_card);
		else
			UIOperation.setPlayerHandCardsNum(this.status, this.hand);
		return tmpCdNum;
		}
		return -1;
	}
	public int drawHeroticCard(List<Card> gameCard, boolean me){
		if(this.hand<4&&this.health>0)
		{
			this.health--;
			int ct=0;
			for(int i=0; i<gameCard.size(); i++)
				if(gameCard.get(i) instanceof EffectCards) ct++;
			if(ct>0) {
				boolean no=true;
				int tmpCdNum = 0;
				while(no){
					tmpCdNum=(int) (Math.random()*28);
					if(gameCard.get(tmpCdNum).showStatus()==4&&gameCard.get(tmpCdNum).
							num>2&&(gameCard.get(tmpCdNum).num-3)%2==this.types){
						no=false;
					}
				}
				gameCard.get(tmpCdNum).changeStatus(this.showStatus());
				this.hand++;
				this.handcards.add(gameCard.get(tmpCdNum));
				int[] sent_out_card=new int[this.hand];
				for(int i=0; i<this.hand; i++){
					sent_out_card[i]=this.handcards.get(i).num;
				}
				UIOperation.setPlayerHP(status, this.health);
				if(me)
					UIOperation.setPlayerHandCards(sent_out_card);
				else
					UIOperation.setPlayerHandCardsNum(this.status, this.hand);
				return tmpCdNum;
				}
		}
		return -1;
	}
	public void drug(){
		this.att+=5;
		this.changeHealth(-1);
		this.poi=true;
		UIOperation.setPlayerAP(this.status, this.att);
	}
	public void getWeapon(Weapon wp){
		if(this.wp!=null) removeWeapon();
		this.wp=wp;
		this.wp.effect(this, 0);
		UIOperation.setPlayerWeapon(status, this.wp.num-9);
	}
	private void removeWeapon() {
		this.wp.effect(this, 1);
		UIOperation.delPlayerWeapon(status);
	}

	//after att stage
	public void checkPoi(){
		if(poi) this.att-=5;
		this.poi=false;	
	}
	public boolean checkDeath(){
		if(this.health<=0)return true;
		return false;
	}
	public int removeHand(int num, boolean me){
		int ans=-1;
		if(this.hand>0)
		{
			ans=this.handcards.get(num).num;
			this.handcards.remove(num);
			this.hand--;
		}
		int[] sent_out_card=new int[this.hand];
		for(int i=0; i<this.hand; i++){
			sent_out_card[i]=this.handcards.get(i).num;
			System.out.print(sent_out_card[i]+", ");
		}
		System.out.println();
		Replyer.clear();
		if(me)
			UIOperation.setPlayerHandCards(sent_out_card);
		else
			UIOperation.setPlayerHandCardsNum(this.status, this.hand);
		return ans;
	}

	public void setHand(List<Card> gameCards, int cardNum, boolean me) {
		this.hand++;
		if(cardNum<6){
			if(gameCards.get(cardNum*2) instanceof Character)
			{
				this.handcards.add(gameCards.get(cardNum*2));
				gameCards.get(cardNum*2).changeStatus(this.types);
			}
			else if(gameCards.get(cardNum*2+1) instanceof Character)
			{
				this.handcards.add(gameCards.get(cardNum*2+1));
				gameCards.get(cardNum*2+1).changeStatus(this.types);
			}
			else System.out.println("Add_handcard_Wrong!");
		}
		else if(cardNum<24){
			if(gameCards.get((cardNum-1)*3) instanceof EffectCards&&gameCards.get((cardNum-1)*3).status==4)
			{
				this.handcards.add(gameCards.get((cardNum-1)*3));
				gameCards.get((cardNum-1)*3).changeStatus(this.types);
			}
			else if(gameCards.get((cardNum-1)*3+1) instanceof EffectCards&&gameCards.get((cardNum-1)*3+1).status==4)
			{
				this.handcards.add(gameCards.get((cardNum-1)*3+1));
				gameCards.get((cardNum-1)*3+1).changeStatus(this.types);
			}
			else if(gameCards.get((cardNum-1)*3+2) instanceof EffectCards&&gameCards.get((cardNum-1)*3+2).status==4)
			{
				this.handcards.add(gameCards.get((cardNum-1)*3+2));
				gameCards.get((cardNum-1)*3+2).changeStatus(this.types);
			}
			else System.out.println("Add_handcard_Wrong!");
		}
		else{

			if(gameCards.get(cardNum*2+6) instanceof Weapon&&gameCards.get(cardNum*2+6).status==4)
			{
				this.handcards.add(gameCards.get(cardNum*2+6));
				gameCards.get(cardNum*2+6).changeStatus(this.types);
			}
			else if(gameCards.get(cardNum*2+6+1) instanceof Weapon&&gameCards.get(cardNum*2+6+1).status==4)
			{
				this.handcards.add(gameCards.get(cardNum*2+6+1));
				gameCards.get(cardNum*2+6+1).changeStatus(this.types);
			}
			else System.out.println("Add_handcard_Wrong!");
			
		}
		int[] sent_out_card=new int[this.hand];
		for(int i=0; i<this.hand; i++){
			sent_out_card[i]=this.handcards.get(i).num;
		}
		if(me)
			UIOperation.setPlayerHandCards(sent_out_card);
		else
			UIOperation.setPlayerHandCardsNum(this.status, this.hand);
	}

	public void showHand() {
		for(int i=0; i<this.hand; i++)
			System.out.println("card# "+i+": "+this.handcards.get(i).num);
		
	}

}
