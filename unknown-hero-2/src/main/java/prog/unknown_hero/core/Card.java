package prog.unknown_hero.core;

public class Card {
	static int status;// 0~3 p1~4, 4: deck
	static int num;//0:mag, 1:sci, 2:wor, 3:grav, 4:exg, 5:copy, 6:drug, 7:recov, 8:hback, 9:spear, 10: sheild
	protected Card(int a, int b)
	{
		status=a;
		this.num= b;
	}
	
	protected void changeStatus(int to)
	{
		this.status=to;
	}
	
	protected int showStatus(){
		return this.status;
	}
}
