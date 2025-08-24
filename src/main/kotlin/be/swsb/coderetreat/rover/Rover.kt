package be.swsb.coderetreat.rover

import be.swsb.coderetreat.rover.Command.*
import be.swsb.coderetreat.rover.obstacledetection.Scanner

data class Rover(
    private val facing: Direction = Direction.North,
    private val at: Position = at(0, 0),
    private val scanner: Scanner? = null,
    private val ignoringCommands: Boolean = false,
) {

    fun receiveCommands(vararg commands: Command): Rover =
        commands.fold(this) { acc, command -> acc.executeCommand(command) }

    private fun executeCommand(command: Command): Rover = viaCircuitBreaker {
        when (command) {
            Forwards -> copy(at = at + facing.vector)
            Backwards -> copy(at = at - facing.vector)
            Right -> copy(facing = facing.clockwise())
            Left -> copy(facing = facing.counterClockwise())
        }
    }

    private fun viaCircuitBreaker(commandBlock: () -> Rover): Rover {
        if (ignoringCommands) return this
        val newRover = commandBlock()
        return if (scanner?.scan(newRover.at) == null) newRover else copy(ignoringCommands = true)
    }
}