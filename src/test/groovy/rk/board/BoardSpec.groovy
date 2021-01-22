package rk.board

import rk.board.dice.Dice
import rk.board.dice.FairDice
import spock.lang.Specification

class BoardSpec extends Specification {
	
	def "board should allow to add a player"(){
		given:
		Board board = new Board(new FairDice())
		when:
		board.addPlayer(new Player(1))
		then:
		board.getPlayer(1)
	}
	
	def "board should allow to add multiple players"(){
		given:
		Board board = new Board(new FairDice(), 2)
		when:
		board.addPlayer(new Player(1))
		board.addPlayer(new Player(2))
		then:
		board.getPlayer(1).id == 1
		board.getPlayer(2).id == 2
	}
	
	def "when a turn is used player must move"(){
		given:
		Board board = new Board(new FairDice())
		Player player = new Player(1)
		board.addPlayer(player)
		when:
		int steps = board.useTurn()
		then:
		player.getPosition() == steps
	}
	
	def "board should allow to add a snake"(){
		given:
		Board board = new Board(new FairDice())
		Snake snake = new Snake(14, 7)
		when:
		board.addSnake(snake)
		then:
		def snakes = board.getSnakes()
		snakes[14-Board.SNAKE_FREE_POSITIONS] == snake
	}
	
	def "player should return to tail if a mouth of snake is encountered"(){
		given:
		Dice mockedDice = Mock()
		mockedDice.roll() >>> [6,6,2]
		Board board = new Board(mockedDice)
		Snake snake = new Snake(14, 7)
		Player player = new Player(1)
		board.addPlayer(player)
		board.addSnake(snake)
		when:
		useTurn(3, board)
		then:
		player.getPosition() == 7
	}
	// 14 => 7, +6=13 +1=14 => 7, +1=8
	def "player should not be affected by dead snake"(){
		given:
		Dice mockedDice = Mock()
		mockedDice.roll() >>> [6,6,2,6,1,1]
		Board board = new Board(mockedDice)
		Snake snake = new Snake(14, 7)
		snake.setGreen(true)
		Player player = new Player(1)
		board.addPlayer(player)
		board.addSnake(snake)
		
		snake = new Snake(15, 8)
		board.addSnake(snake)
		when:
		useTurn(6, board)
		then:
		player.getPosition() == 8
	}
	def useTurn(noOfTurns, Board board) {
		while(noOfTurns--) {
			board.useTurn();
		}
	}
}