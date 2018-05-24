package prog.unknown_hero.core;

public class EffectCards extends Card{
	int types, color;
	protected EffectCards(int a) {
		super(a, 3);
		// TODO Auto-generated constructor stub
	}
	public boolean effect(Player hero, int sel)
	{
		switch(this.types)
		{
		case 0://盜墓
			return hero.drawHeroticCard();
		case 1://交換
			changeCardTwoHero();
			break;
		case 2://仿製
			copy();
			break;
		case 3://禁藥
			hero.drug();
			break;
		case 4://回復
			hero.changeHealth(1);
			break;
		case 5://反擊
			hero.changeHealth(-sel);
			break;
		}
		return true;
	}
	private void copy() {
		// TODO Auto-generated method stub
		
	}
	private void changeCardTwoHero() {
		// TODO Auto-generated method stub
		
	}
}
