package be.swsb.coderetreat.rover.obstacledetection

import be.swsb.coderetreat.rover.Obstacle
import be.swsb.coderetreat.rover.Position

interface Scanner {
    fun scan(position: Position): Obstacle?
}