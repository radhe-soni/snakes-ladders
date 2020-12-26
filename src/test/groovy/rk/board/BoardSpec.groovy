package rk.board

import static org.junit.Assert.*

import org.junit.Test

import spock.lang.Specification

class BoardSpec extends Specification {

	static final int DICE_MIN = 1
	static final int DICE_MAX = 6
	def "Dice should return a number between 1 and 6"(){
		when:
		int result = Dice.roll()
		then:
		Math.max(DICE_MIN, result) == result
		Math.min(DICE_MAX, result) == result
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
}
