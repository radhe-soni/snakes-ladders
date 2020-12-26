package rk.board;

public class Player {
	private int position;
	
	public void move(int steps) {
		position += steps;
	}
	
	public int getPosition() {
		return position;
	}
}
