package rk.board;

import java.util.Random;

public class Dice {
	private static final Random RANDOM_DICE = new Random(); 
	public static int roll() {
		return RANDOM_DICE.nextInt(6) + 1;
	}
}
