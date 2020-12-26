package rk.board

import spock.lang.Specification

class BoardSpec extends Specification {

	def "Dice should return a number between 1 and 6"(){
		given:
		Board board = new Board(new Dice())
		when:
		int result = board.rollDice()
		then:
		Math.max(Dice.MIN, result) == result
		Math.min(Dice.MAX, result) == result
	}
	
	def "board should allow to add a player"(){
		given:
		Board board = new Board(new Dice())
		when:
		board.addPlayer(new Player())
		then:
		board.getPlayer()
	}
	
	def "when a turn is used player must move"(){
		given:
		Board board = new Board(new Dice())
		Player player = new Player()
		board.addPlayer(player)
		when:
		int steps = board.useTurn()
		then:
		player.getPosition() == steps
	}
	
	def "board should allow to add a snake"(){
		given:
		Board board = new Board(new Dice())
		Snake snake = new Snake(14, 7)
		when:
		board.addSnake(snake)
		then:
		def snakes = board.getSnakes()
		snakes[14-1] == snake
	}
}
