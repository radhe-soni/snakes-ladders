package rk.board;

import java.util.Scanner;
import java.util.function.Consumer;

import rk.board.dice.Dice;
import rk.board.dice.EvenNumberDice;
import rk.board.dice.FairDice;

public class Main {
	private static final Scanner INPUT = new Scanner(System.in);
	public static void main(String[] args) {
		int choice = getChoice();
		switch (choice) {
		case 1:
			System.out.println("**** Running with fair dice *****");
			runWithDice(new FairDice(), Main::autoMode);
			break;
		case 2:
			System.out.println("**** Running with crooked dice *****");
			runWithDice(new EvenNumberDice(), Main::autoMode);
			break;
		case 3:
			runWithDice(new FairDice(), Main::interactiveMode);
			break;
		default:
			runBoth();
			break;
		}
	}

	private static int getChoice() {
		System.out.println("How do you want to play? Enter your choice...");
		System.out.println("1. With a Fair dice.");
		System.out.println("2. With a Crooked dice.");
		System.out.println("3. With a Fair dice in interactive mode.");
		System.out.println("4. Run all scenarios:");
		int choice = INPUT.nextInt();
		return choice;
	}

	private static void runBoth() {
		System.out.println("**** Running with fair dice *****");
		runWithDice(new FairDice(), Main::autoMode);
		System.out.println();
		System.out.println("**** Running with crooked dice *****");
		runWithDice(new EvenNumberDice(), Main::autoMode);
	}

	private static void runWithDice(Dice dice, Consumer<Board> runMode) {
		Board board = new Board(dice);
		Snake snake = new Snake(14, 7);
		board.addSnake(snake);
		runMode.accept(board);
	}
	
	private static void runWithGreenSnakeDice(Dice dice, Consumer<Board> runMode) {
		Board board = new Board(dice);
		Snake snake = new Snake(14, 7);
		snake.setGreen(true);
		board.addSnake(snake);
		runMode.accept(board);
	}

	private static void autoMode(Board board) {
		Player player = new Player(1);
		board.addPlayer(player);
		for (int i = 0; i < 10; i++) {
			int diceValue = board.useTurn();
			System.out.printf("Current dice value is %d **** ", diceValue);
			System.out.printf("Current position of player is %d %n", player.getPosition());
		}
	}

	private static void interactiveMode(Board board) {
		Player player = new Player(1);
		board.addPlayer(player);
		INPUT.nextLine();
		while (true) {
			System.out.println("Press enter to play your turn.");
			INPUT.nextLine();
			int diceValue = board.useTurn();
			System.out.printf("Current dice value is %d **** ", diceValue);
			System.out.printf("Current position of player is %d %n", player.getPosition());
			if(player.getPosition() ==100) {
				System.out.println("******* You Won! ******");
				break;
			}
		}
	}
}
