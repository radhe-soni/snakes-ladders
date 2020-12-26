package rk.board;

import rk.board.dice.Dice;
import rk.board.dice.EvenNumberDice;
import rk.board.dice.FairDice;

public class Main {

	public static void main(String[] args) {
		System.out.println("**** Running with fair dice *****");
		runWithDice(new FairDice());
		System.out.println("**** Running with crooked dice *****");
		runWithDice(new EvenNumberDice());
		System.out.println("**** Running with fair dice and a snake *****");
		runtWithFairDiceAndASnake();
	}

	private static void runtWithFairDiceAndASnake() {
		Board board = new Board(new FairDice());
		Snake snake = new Snake(14, 7);
		board.addSnake(snake);
		run(board);
	}

	private static void runWithDice(Dice dice) {
		Board board = new Board(dice);
		run(board);
	}

	private static void run(Board board) {
		Player player = new Player();
		board.addPlayer(player);
		for (int i = 0; i < 10; i++) {
			int diceValue = board.useTurn();
			System.out.printf("Current dice value is %d **** ", diceValue);
			System.out.printf("Current position of player is %d %n", player.getPosition());
		}
	}
}
