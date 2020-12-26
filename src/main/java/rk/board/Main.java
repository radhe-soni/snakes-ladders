package rk.board;

public class Main {

	public static void main(String[] args) {
		Board board = new Board(new Dice());
		Player player = new Player();
		board.addPlayer(player);
		for (int i = 0; i < 10; i++) {
			int diceValue = board.useTurn();
			System.out.printf("Current dice value is %d %n", diceValue);
			System.out.printf("Current position of player is %d %n", player.getPosition());
		}
	}
}
