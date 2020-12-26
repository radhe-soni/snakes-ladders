package rk.board;

public class Snake {
	private final int mouthPosition;
	private final int tailPosition;

	public Snake(int mouthPosition, int tailPosition) {
		if (mouthPosition <= tailPosition)
			throw new IllegalArgumentException("Tail can not arrive before or coincide with Mouth");
		if (tailPosition < Board.MIN_POSTION)
			throw new IllegalArgumentException("Tail can not be placed before minimum allowed board position");
		if (mouthPosition >= Board.MAX_POSTION)
			throw new IllegalArgumentException("Mouth can not be placed at or after maximum allowed board position");
		this.mouthPosition = mouthPosition;
		this.tailPosition = tailPosition;
	}
	
	public int getMouthPosition() {
		return mouthPosition;
	}

	public int getTailPosition() {
		return this.tailPosition;
	}
}
