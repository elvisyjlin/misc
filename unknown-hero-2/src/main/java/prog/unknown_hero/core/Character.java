package prog.unknown_hero.core;

public class Character extends Card{
	int MAX_HEALTH, MAX_HAND, att, def;
	int types;// 0: mag, 1: sci, 2: wor
	int left;
	Character(int a, int b) {
		super(a, b);
		// TODO Auto-generated constructor stub
		this.set(b);
		this.types=b;
		this.left=2;
	}
	private void set(int types) {
		switch(types)
		{
		case 0 : //magician
			this.att=0;
			this.def=1;
			this.MAX_HAND=3;
			this.MAX_HEALTH=3;
			break;
		case 1: //scientist
			this.att=0;
			this.def=0;
			this.MAX_HAND=2;
			this.MAX_HEALTH=3;
			break;
		case 2: //worker
			this.att=1;
			this.def=1;
			this.MAX_HAND=3;
			this.MAX_HEALTH=2;
			break;
		}
		
	}
	

}
