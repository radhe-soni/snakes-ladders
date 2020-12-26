package rk.board.dice;

import java.util.Random;

public class EvenNumberDice implements Dice {

	private static final Random RANDOM_DICE = new Random();

	public int roll() {
		return (RANDOM_DICE.nextInt(MAX / 2) + 1) * 2;
	}

}
