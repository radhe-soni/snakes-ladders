package rk.board;

public class Board {
	public static final int MIN_POSTION = 1;
	public static final int MAX_POSTION = 100;
	
	private Dice dice;
	private Player player;
	public Board(Dice dice) {
		this.dice=dice;
	}

	public int rollDice() {
		return dice.roll();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void addPlayer(Player player) {
		this.player=player;
	}
}
