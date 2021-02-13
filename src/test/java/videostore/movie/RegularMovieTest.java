package videostore.movie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RegularMovieTest {

    private final Movie movie = new RegularMovie("Regular Movie");

    @ParameterizedTest(name = "rental for {0} days costs {1}")
    @MethodSource("daysRentedAndExpectedAmount")
    void shouldCalculateAmount(int daysRented, double expectedAmount) {
        assertThat(movie.calculateAmount(daysRented)).isEqualTo(expectedAmount);
    }

    @ParameterizedTest(name = "rental for {0} days earns {1} frequent renter points")
    @MethodSource("daysRentedAndFrequentRenterPoints")
    void shouldCalculateFrequentRenterPointsAsOne(int daysRented, int expectedFrequentRenterPoints) {
        assertThat(movie.calculateFrequentRenterPoints(daysRented)).isEqualTo(expectedFrequentRenterPoints);
    }

    private static Stream<Arguments> daysRentedAndExpectedAmount() {
        return Stream.of(
                Arguments.of(0, 2),
                Arguments.of(1, 2),
                Arguments.of(2, 2),
                Arguments.of(3, 3.5),
                Arguments.of(4, 5),
                Arguments.of(5, 6.5)
        );
    }

    private static Stream<Arguments> daysRentedAndFrequentRenterPoints() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(50, 1),
                Arguments.of(99, 1)
        );
    }

}
