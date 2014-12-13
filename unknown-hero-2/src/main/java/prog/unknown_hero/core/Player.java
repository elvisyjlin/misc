package prog.unknown_hero.core;

import java.util.ArrayList;
import java.util.List;

public class Player extends Character{
	int health, hand;
	Weapon wp=null;
	public boolean poi=false;
	List<Card> handcards= new ArrayList(); 
	Player(int a, int types) {
		super(a, 2, types);
		this.maxHealth();
		this.hand=0;
		handcards.clear();
	}
	
	public void changeHealth(int sub)
	{
		this.health+=sub;
		if(this.health>this.MAX_HEALTH) this.maxHealth();
	}
	public void maxHealth() {
		this.health=this.MAX_HEALTH;
		
	}
	public int drawCard(List<Card> gameCard){
		boolean no=true;
		int tmpCdNum=0;
		while(no){
			tmpCdNum=(int) Math.abs(Math.random())%28;
			if(gameCard.get(tmpCdNum).showStatus()==4){
				no=false;
			}
		gameCard.get(tmpCdNum).changeStatus(this.showStatus());
		this.hand++;
		}
		return tmpCdNum;
	}
	public int drawHeroticCard(List<Card> gameCard){
		if(this.hand<4)
		{
			int ct=0;
			for(int i=0; i<gameCard.size(); i++)
				if(gameCard.get(i) instanceof EffectCards) ct++;
			if(ct>0) {
				boolean no=true;
				int tmpCdNum = 0;
				while(no){
					tmpCdNum=(int) Math.abs(Math.random())%28;
					if(gameCard.get(tmpCdNum).showStatus()==4&&gameCard.get(tmpCdNum).
							num>2&&(gameCard.get(tmpCdNum).num-3)%2==this.types){
						no=false;
					}
				}
				gameCard.get(tmpCdNum).changeStatus(this.showStatus());
				this.hand++;
				return tmpCdNum;
				}
		}
		return -1;
	}
	public void drug(){
		this.att+=5;
		this.changeHealth(-1);
	}
	public void getWeapon(Weapon wp){
		if(this.wp!=null) removeWeapon();
		this.wp=wp;
		this.wp.effect(this, 0);
	}
	private void removeWeapon() {
		this.wp.effect(this, 1);
	}

	//after att stage
	public void checkPoi(){
		if(poi) this.att-=5;
	}
	public boolean checkDeath(){
		if(this.health<=0)return true;
		return false;
	}
}
