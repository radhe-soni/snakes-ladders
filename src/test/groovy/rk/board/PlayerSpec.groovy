package rk.board

import static org.junit.Assert.*

import org.junit.Test

import rk.board.dice.Dice
import spock.lang.Specification

class PlayerSpec extends Specification {

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
}
