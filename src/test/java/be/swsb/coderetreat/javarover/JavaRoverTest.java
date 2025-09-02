package be.swsb.coderetreat.javarover;

import be.swsb.coderetreat.rover.Direction;
import be.swsb.coderetreat.rover.Position;
import be.swsb.coderetreat.rover.obstacledetection.RandomScanner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static be.swsb.coderetreat.rover.Command.*;
import static be.swsb.coderetreat.rover.Direction.*;
import static be.swsb.coderetreat.rover.RoverKt.at;
import static kotlin.random.RandomKt.Random;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JavaRoverTest {

//    @ParameterizedTest
//    @MethodSource("forwardsCriteria")
//    void aRoverCanMoveForwards(Position startingPosition, Direction facing, Position expectedPosition) {
//        final var initialJavaRover = JavaRover()
//                .withAt(startingPosition)
//                .withFacing(facing);
//
//        final var actual = initialJavaRover.receiveCommands(Forwards);
//
//        final var expectedJavaRover = JavaRover()
//                .withAt(expectedPosition)
//                .withFacing(facing);
//
//        assertThat(actual).isEqualTo(expectedJavaRover);
//    }
//
//    @ParameterizedTest
//    @MethodSource("backwardsCriteria")
//    void aRoverCanMoveBackwards(Position startingPosition, Direction facing, Position expectedPosition) {
//        final var initialJavaRover = JavaRover()
//                .withAt(startingPosition)
//                .withFacing(facing);
//
//        final var actual = initialJavaRover.receiveCommands(Backwards);
//
//        final var expectedJavaRover = JavaRover()
//                .withAt(expectedPosition)
//                .withFacing(facing);
//
//        assertThat(actual).isEqualTo(expectedJavaRover);
//    }
//
//    @Test
//    void aRoverCanTurnRightAndLeft() {
//        var rover = JavaRover().withFacing(North);
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(East));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(South));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(West));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(North));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(West));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(South));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(East));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(JavaRover().withFacing(North));
//    }
//
//    @Test
//    void aRoverStopsExecutingWhenItEncounteredAnObstacle() {
//        final var scanner = new RandomScanner(Random(5));
//        final var initialRover = JavaRover().withScanner(scanner); //Will scan something on the 5th move
//
//        final var actual = initialRover.receiveCommands(Forwards, Forwards, Forwards, Forwards, Forwards, Forwards, Backwards);
//
//        assertThat(actual).isEqualTo(JavaRover().withAt(at(0, 4)).withScanner(scanner).withIgnoringCommands(true));
//    }

    static Stream<Arguments> forwardsCriteria() {
        return Stream.of(
                arguments(at(10, 10), North, at(10, 11)),
                arguments(at(10, 10), East,  at(11, 10)),
                arguments(at(10, 10), South, at(10, 9)),
                arguments(at(10, 10), West,  at(9, 10))
        );
    }

    static Stream<Arguments> backwardsCriteria() {
        return Stream.of(
                arguments(at(10, 10), North, at(10, 9)),
                arguments(at(10, 10), East,  at(9, 10)),
                arguments(at(10, 10), South, at(10, 11)),
                arguments(at(10, 10), West,  at(11, 10))
        );
    }
}
