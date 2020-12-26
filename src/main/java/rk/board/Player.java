package rk.board;

public class Player {
	private int position;
	/**
	 * Player is not allowed to move if number of steps
	 * surpasses 100
	 * @param steps
	 */
	public void move(int steps) {
		if(position + steps <= Board.MAX_POSTION)
			position += steps;
	}
	
	public int getPosition() {
		return position;
	}
}
