package be.swsb.coderetreat.rover

import be.swsb.coderetreat.rover.Command.*
import be.swsb.coderetreat.rover.obstacledetection.Scanner

data class Rover(
    private val at: Position = at(0, 0),
    private val facing: Direction = Direction.North,
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
        val mutatedRover = commandBlock()
        return if (scanner?.scan(mutatedRover.at) == null) mutatedRover
               else copy(ignoringCommands = true)
    }
}





enum class Command {
    Forwards,
    Backwards,
    Right,
    Left,
}


enum class Direction(
    val vector: Position,
) {
    North(Position(0, 1)),
    East(Position(1, 0)),
    South(Position(0, -1)),
    West(Position(-1, 0));

    fun clockwise(): Direction = when(this) {
        North -> East; East -> South; South -> West; West -> North
    }
    fun counterClockwise(): Direction = when(this) {
        North -> West; West -> South; South -> East; East -> North
    }
}



data class Position(private val x: Int, private val y: Int) {
    operator fun plus(other: Position) = Position(this.x + other.x, this.y + other.y)
    operator fun minus(other: Position) = Position(this.x - other.x, this.y - other.y)
}
fun at(x: Int, y: Int) = Position(x, y)