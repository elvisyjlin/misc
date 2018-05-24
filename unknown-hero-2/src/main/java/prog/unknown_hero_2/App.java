package prog.unknown_hero_2;

import prog.unknown_hero.ui.MainPage;

/**
 * Hello world!
 *
 */
public class App 
{
	static final String DEFAULT_WINDOW_TITLE = "變身英雄";
	static final int DEFAULT_WINDOW_WIDTH = 805;
	static final int DEFAULT_WINDOW_HEIGHT = 635;
    public static void main( String[] args )
    {
    	new MainPage(DEFAULT_WINDOW_TITLE, DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
    }
}
