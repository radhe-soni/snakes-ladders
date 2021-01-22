package rk.board;

public class Player {
	private int position;
	private int id;
	
	public int getId() {
		return id;
	}
	public Player(int id) {
		this.id=id;
	}
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

	public void setPosition(int position) {
		this.position=position;
	}
	
	public boolean hasId(int id) {
		return this.getId() == id;
	}

}
