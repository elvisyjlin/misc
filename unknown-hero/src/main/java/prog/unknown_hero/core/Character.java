package prog.unknown_hero.core;

public class Character extends Card{
	static int MAX_HEALTH, MAX_HAND, att, def;
	static int types;// 0: mag, 1: sci, 2: wor
	Character(int a, int b, int types) {
		super(a, b);
		// TODO Auto-generated constructor stub
		this.set(types);
		this.types=types;
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
