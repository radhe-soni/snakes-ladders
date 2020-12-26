package rk.board;

import java.util.Random;

public class Dice {
	public static final int MIN = 1;
	public static final int MAX = 6;
	private static final Random RANDOM_DICE = new Random(); 
	public static int roll() {
		return RANDOM_DICE.nextInt(6) + 1;
	}
}
