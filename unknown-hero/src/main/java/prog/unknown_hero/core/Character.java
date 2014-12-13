package prog.unknown_hero.core;

public class Character extends Card{
	static int MAX_HEALTH, MAX_HAND, att, def, health, hand;
	Character(int a, int b, int max_health, int max_hand, int att, int def) {
		super(a, b);
		// TODO Auto-generated constructor stub
		this.MAX_HEALTH=max_health;
		this.MAX_HAND=max_hand;
		this.att=att;
		this.def=def;
		this.hand=max_hand;
		this.maxHealth();
	}
	protected boolean changeHealth(int sub)
	{
		this.health+=sub;
		if(this.health>this.MAX_HEALTH) this.maxHealth();
		if(this.health>0) return false;
		else return true;
	}
	private void maxHealth() {
		this.health=this.MAX_HEALTH;
		
	}

}
