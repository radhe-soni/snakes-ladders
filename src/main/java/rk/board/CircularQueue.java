package rk.board;

import java.util.AbstractList;

public class CircularQueue<T> extends AbstractList<T> {
	private Object[] players;
	private int index;
	private int next;
	private int capacity;

	public CircularQueue(int capacity) {
		players = new Object[capacity];
		this.capacity=capacity;
	}

	@SuppressWarnings("unchecked")
	public T next() {
		if (next == capacity)
			next = 0;
		return (T) players[next++];
	}

	@Override
	public boolean add(T player) {
		if (index == capacity)
			return false;
		players[index++] = player;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		return (T)players[index];
	}

	@Override
	public int size() {
		return capacity;
	}
}
