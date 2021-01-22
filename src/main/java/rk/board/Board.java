package rk.board;

import rk.board.dice.Dice;

public class Board {
	private static final int SNAKE_FREE_POSITIONS = 2;
	public static final int MIN_POSTION = 1;
	public static final int MAX_POSTION = 100;
	private Dice dice;
	private CircularQueue<Player> players;
	private Snake[] snakes;

	public Board(Dice dice) {
		this(dice, 1);
	}

	public Board(Dice dice, int maxPlayers) {
		this.dice = dice;
		snakes = new Snake[MAX_POSTION - SNAKE_FREE_POSITIONS];
		players = new CircularQueue<>(maxPlayers);
	}

	public int rollDice() {
		return dice.roll();

	}

	public int useTurn() {
		int steps = rollDice();
		Player player = players.next();
		player.move(steps);
		if (checkTrivialPositions(player.getPosition())) {
			return steps;
		}
		checkForSnakeAndAdjustPosition(player);
		return steps;
	}

	private void checkForSnakeAndAdjustPosition(Player player) {
		int snakePosition = player.getPosition() - SNAKE_FREE_POSITIONS;
		Snake snake = snakes[snakePosition];
		if (snake != null && snake.isActive()) {
			int finalPosition = snake.getFinalPosition();
			if (finalPosition > 0)
				player.setPosition(finalPosition);
		}
	}

	private boolean checkTrivialPositions(int currentPosition) {
		return currentPosition == MAX_POSTION || currentPosition == MIN_POSTION;
	}

	public Player getPlayer(int id) {
		return players.stream().filter(player -> player.hasId(id)).findFirst()
				.orElseThrow(() -> new RuntimeException("No such player exists"));
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public void addSnake(Snake snake) {
		snakes[snake.getMouthPosition() - SNAKE_FREE_POSITIONS] = snake;
	}

	public Snake[] getSnakes() {
		return snakes;
	}

}
