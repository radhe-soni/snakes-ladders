package rk.board

import static org.junit.Assert.*

import org.junit.Test

import spock.lang.Specification

class SnakeSpec extends Specification {

	def "start position should be greater end position of a snake"(mouthPosition, tailPosition, message){
		when:
		Snake snake = new Snake(mouthPosition, tailPosition)
		then:
		def ex = thrown(IllegalArgumentException)
		ex.getMessage() == message
		where:
		mouthPosition 	| tailPosition	| message
		0				| 0				| "Tail can not arrive before or coincide with Mouth"
		7				| 7				| "Tail can not arrive before or coincide with Mouth"
		1				| 0				| "Tail can not be placed before minimum allowed board position"
		0				| 10			| "Tail can not arrive before or coincide with Mouth"
		100				| 2				| "Mouth can not be placed at or after maximum allowed board position"
	}
}
