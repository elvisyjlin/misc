package prog.unknown_hero.core;

import java.util.List;

import prog.unknown_hero.utility.Replyer;

public class EffectCards extends Card{
	int types, color;
	protected EffectCards(int a, int b) {
		super(a, b);
		this.types=this.num-3;
		this.color=this.types/2;
	}
	public int effect(Player hero, int sel, List<Card> gameCards)
	{
		switch(this.types)
		{
		case 0://盜墓
			return hero.drawHeroticCard(gameCards, hero.status==this.status);
		case 1://交換
			changeCardTwoHero();
			break;
		case 2://仿製
			int copy_sel=4;
			while(copy_sel>=4||copy_sel==status)
			{
				while(!Replyer.hasMessage()) continue;
					copy_sel=Integer.parseInt(Replyer.get().content()[0]);
				Replyer.clear();
			}
			copy(copy_sel, gameCards);
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
	private void copy(int sel, List<Card> gameCards) {
		Player chosen=new GameController.CardSet().PLAYER.get(sel);
		chosen.showHand();
		
	}
	private void changeCardTwoHero() {
		// TODO Auto-generated method stub
		
	}
}
