package be.swsb.coderetreat.rover

import be.swsb.coderetreat.rover.Command.*
import be.swsb.coderetreat.rover.Direction.*
import be.swsb.coderetreat.rover.obstacledetection.RandomScanner
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments.of
import org.junit.jupiter.params.provider.MethodSource
import kotlin.random.Random

class RoverTest {

    @ParameterizedTest
    @MethodSource("forwardsCriteria")
    fun `A Rover can Move forwards`(startingPosition: Position, facing: Direction, expectedPosition: Position) {
        val initialRover = Rover(at = startingPosition, facing = facing)
        val actual = initialRover.receiveCommands(Forwards)
        val expectedRover = Rover(at = expectedPosition, facing = facing)
        assertThat(actual).isEqualTo(expectedRover)
    }

    @ParameterizedTest
    @MethodSource("backwardsCriteria")
    fun `A Rover can Move backwards`(startingPosition: Position, facing: Direction, expectedPosition: Position) {
        val initialRover = Rover(at = startingPosition, facing = facing)
        val actual = initialRover.receiveCommands(Backwards)
        val expectedRover = Rover(at = expectedPosition, facing = facing)
        assertThat(actual).isEqualTo(expectedRover)
    }

    @Test
    fun `A Rover can turn right and left`() {
        val rover = Rover(facing = North)
        rover.receiveCommands(Right)
            .also { assertThat(it).isEqualTo(Rover(facing = East)) }
            .receiveCommands(Right)
            .also { assertThat(it).isEqualTo(Rover(facing = South)) }
            .receiveCommands(Right)
            .also { assertThat(it).isEqualTo(Rover(facing = West)) }
            .receiveCommands(Right)
            .also { assertThat(it).isEqualTo(Rover(facing = North)) }
            .receiveCommands(Left)
            .also { assertThat(it).isEqualTo(Rover(facing = West)) }
            .receiveCommands(Left)
            .also { assertThat(it).isEqualTo(Rover(facing = South)) }
            .receiveCommands(Left)
            .also { assertThat(it).isEqualTo(Rover(facing = East)) }
            .receiveCommands(Left)
            .also { assertThat(it).isEqualTo(Rover(facing = North)) }
    }

    @Test
    fun `A Rover stops executing when it encountered an obstacle`() {
        val scanner = RandomScanner(Random(5))
        val initialRover = Rover(scanner = scanner) //Will scan something on the 5th move

        val actual = initialRover.receiveCommands(Forwards, Forwards, Forwards, Forwards, Forwards, Forwards, Backwards)

        assertThat(actual).isEqualTo(Rover(at = at(0, 4), scanner = scanner, ignoringCommands = true))
    }

    companion object {
        @JvmStatic
        fun forwardsCriteria() = listOf(
            of(at(10, 10), North, at(10, 11)),
            of(at(10, 10), East, at(11, 10)),
            of(at(10, 10), South, at(10, 9)),
            of(at(10, 10), West, at(9, 10)),
        )

        @JvmStatic
        fun backwardsCriteria() = listOf(
            of(at(10, 10), North, at(10, 9)),
            of(at(10, 10), East, at(9, 10)),
            of(at(10, 10), South, at(10, 11)),
            of(at(10, 10), West, at(11, 10)),
        )
    }
}