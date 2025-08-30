package be.swsb.coderetreat.rover.obstacledetection

import be.swsb.coderetreat.rover.Position
import kotlin.random.Random

data class RandomScanner(private val random: Random = Random) : Scanner {
    override fun scan(position: Position): Obstacle? =
        random.nextInt(1, 20).let {
            when (it) {
                1 -> Obstacle.Crater
                2 -> Obstacle.Martian
                else -> null
            }
        }
}