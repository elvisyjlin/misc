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
	public void drawCard(){
		// TODO undone
	}
	public boolean drawHeroticCard(){
		// TODO undone
		return false;
	}
	public void drug(){
		this.att+=5;
		this.changeHealth(-1);
	}
	public void getWeapon(Weapon wp){
		if(this.wp!=null) removeWeapon();
		this.wp=wp;
		this.wp.effect(this, 0);4h
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
