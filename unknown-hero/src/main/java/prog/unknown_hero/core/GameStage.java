package prog.unknown_hero.core;

public class GameStage {
	
	private int stage;

	private final static int INIT = 0;
	private final static int WAIT = 1;
	private final static int PLAY = 2;
	private final static int DEAD = 3;
	private final static int WON = 4;
	private final static int LOSE = 5;

	public GameStage() {
		stage = INIT;
	}
	
	public int nextStage() {
		return ++stage;
	}
	
	public boolean isInitialling() {
		return stage == INIT;
	}
	
	public boolean isWaiting() {
		return stage == WAIT;
	}
	
	public boolean isPlaying() {
		return stage == PLAY;
	}
	
	public boolean isDead() {
		return stage == DEAD;
	}
	
	public boolean won() {
		return stage == WON;
	}
	
	public boolean lose() {
		return stage == LOSE;
	}

}
