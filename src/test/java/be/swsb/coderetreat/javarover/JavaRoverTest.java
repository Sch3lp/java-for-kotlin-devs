package be.swsb.coderetreat.javarover;

import be.swsb.coderetreat.rover.Direction;
import be.swsb.coderetreat.rover.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static be.swsb.coderetreat.rover.Command.*;
import static be.swsb.coderetreat.rover.Direction.*;
import static be.swsb.coderetreat.rover.RoverKt.at;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class JavaRoverTest {

//    @ParameterizedTest
//    @MethodSource("forwardsCriteria")
//    void aRoverCanMoveForwards(Position startingPosition, Direction facing, Position expectedPosition) {
//        final var initialJavaRover = new JavaRover()
//                .withAt(startingPosition)
//                .withFacing(facing);
//
//        final var actual = initialJavaRover.receiveCommands(Forwards);
//
//        final var expectedJavaRover = new JavaRover()
//                .withAt(expectedPosition)
//                .withFacing(facing);
//
//        assertThat(actual).isEqualTo(expectedJavaRover);
//    }
//
//    @ParameterizedTest
//    @MethodSource("backwardsCriteria")
//    void aRoverCanMoveBackwards(Position startingPosition, Direction facing, Position expectedPosition) {
//        final var initialJavaRover = new JavaRover()
//                .withAt(startingPosition)
//                .withFacing(facing);
//
//        final var actual = initialJavaRover.receiveCommands(Backwards);
//
//        final var expectedJavaRover = new JavaRover()
//                .withAt(expectedPosition)
//                .withFacing(facing);
//
//        assertThat(actual).isEqualTo(expectedJavaRover);
//    }
//
//    @Test
//    void aRoverCanTurnRightAndLeft() {
//        var rover = new JavaRover().withFacing(North);
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(East));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(South));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(West));
//
//        rover = rover.receiveCommands(Right);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(North));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(West));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(South));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(East));
//
//        rover = rover.receiveCommands(Left);
//        assertThat(rover).isEqualTo(new JavaRover().withFacing(North));
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
