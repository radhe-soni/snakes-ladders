package rk.board;

public class Snake {
	private final int mouthPosition;
	private final int tailPosition;
	private boolean isGreen;
	private boolean isActive = true;

	public boolean isGreen() {
		return isGreen;
	}

	public void setGreen(boolean isGreen) {
		this.isGreen = isGreen;
	}

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

	public void setActive(boolean isActive) {

		this.isActive = isActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public int getFinalPosition() {
		int finalPosition = 0;
		System.out.printf("<;==== Snake encountered at %d ==== %n", this.getMouthPosition());
		finalPosition = this.getTailPosition();
		if (this.isGreen())
			this.setActive(false);
		return finalPosition;
	}
}
