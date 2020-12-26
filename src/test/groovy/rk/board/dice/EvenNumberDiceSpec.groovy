package rk.board.dice

import static org.junit.Assert.*

import org.junit.Test

import spock.lang.Specification

class EvenNumberDiceSpec extends Specification {

	def "Dice should return a number in [2, 4, 6]"(){
		given:
		Dice dice = new EvenNumberDice()
		when:
		int result = dice.roll()
		then:
		[2, 4, 6].contains(result)
	}

}
