package be.swsb.coderetreat.javarover;


import be.swsb.coderetreat.rover.Command;
import be.swsb.coderetreat.rover.Direction;
import be.swsb.coderetreat.rover.Position;

public record JavaRover(
        Position at,
        Direction facing
) {

}

