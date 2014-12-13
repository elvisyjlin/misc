package prog.unknown_hero.core;

public class Card {
	static int []status;
	static int num;
	protected Card(int a, int b)
	{
		for(int i=0; i<b; i++) status[i]=0;
		this.num= b;
	}
	
	protected void changeStatus(int num, int to)
	{
		this.status[num]=to;
	}
}
