package rk.board.dice

import static org.junit.Assert.*

import org.junit.Test

import spock.lang.Specification

class FairDiceSpec extends Specification {

	def "Dice should return a number between 1 and 6"(){
		given:
		Dice dice = new FairDice()
		when:
		int result = dice.roll()
		then:
		Math.max(Dice.MIN, result) == result
		Math.min(Dice.MAX, result) == result
	}

}
