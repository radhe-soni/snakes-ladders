package rk.board

import static org.junit.Assert.*

import org.junit.Test

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

	def "for a dice throw a player should move from initial position by the number on dice throw"(diceValue){
		given:
		Player player = new Player()
		when:
		player.move(diceValue)
		then:
		player.getPosition() == diceValue
		where:
		diceValue	| _
		1			| _
		2			| _
		3			| _
		4			| _
		5			| _
		6			| _
	}
	
	def "player should have initial position as zero"(){
		when:
		Player player = new Player()
		then:
		player.getPosition() == Board.MIN_POSTION-1
	}
	def "player should have maximum position 100"(){
		given:
		Player player = new Player()
		when:
		for(int i=1;i<=20;i++)
			player.move(i*Dice.MAX)
		then:
		player.getPosition() <=Board.MAX_POSTION
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
}
