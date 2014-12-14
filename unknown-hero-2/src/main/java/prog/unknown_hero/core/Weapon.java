package prog.unknown_hero.core;

public class Weapon extends Card{
	int types;
	protected Weapon(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		this.types=b-9;
	}
	public void active(Player hero){
		hero.getWeapon(this);
	}
	public void effect(Player hero, int sel){
		if(sel==0)
		{
			if(this.types==0)
				hero.att+=2;
			else
				hero.def+=2;
		}
		else
		{
			if(this.types==0)
				hero.att-=2;
			else
				hero.def-=2;
		}
	}
}
