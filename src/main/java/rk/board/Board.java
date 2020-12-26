package rk.board;

public class Board {
	private static final int SNAKE_FREE_POSITIONS = 2;
	public static final int MIN_POSTION = 1;
	public static final int MAX_POSTION = 100;

	private Dice dice;
	private Player player;
	public Snake[] snakes;
	
	public Board(Dice dice) {
		this.dice = dice;
		snakes = new Snake[MAX_POSTION - SNAKE_FREE_POSITIONS];
	}

	public int rollDice() {
		return dice.roll();

	}

	public int useTurn() {
		int steps = rollDice();
		player.move(steps);
		return steps;
	}

	public Player getPlayer() {
		return player;
	}

	public void addPlayer(Player player) {
		this.player = player;
	}
	
	public void addSnake(Snake snake) {
		snakes[snake.getMouthPosition()-1]= snake;
	}
	public Snake[] getSnakes(){
		return snakes;
	}
}
