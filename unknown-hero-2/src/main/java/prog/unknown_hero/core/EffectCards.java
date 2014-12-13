package prog.unknown_hero.core;

import java.util.List;

public class EffectCards extends Card{
	int types, color;
	protected EffectCards(int a) {
		super(a, 3);
		this.types=this.num-3;
		this.color=this.types/2;
	}
	public int effect(Player hero, int sel, List<Card> gameCards)
	{
		switch(this.types)
		{
		case 0://盜墓
			return hero.drawHeroticCard(gameCards);
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
		return 0;
	}
	private void copy() {
		// TODO Auto-generated method stub
		
	}
	private void changeCardTwoHero() {
		// TODO Auto-generated method stub
		
	}
}
