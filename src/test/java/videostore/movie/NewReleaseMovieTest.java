package videostore.movie;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NewReleaseMovieTest {

    private final Movie movie = new NewReleaseMovie("New Release Movie");

    @ParameterizedTest(name = "rental for {0} days costs {1}")
    @MethodSource("daysRentedAndExpectedAmount")
    void shouldCalculateAmount(int daysRented, double expectedAmount) {
        assertThat(movie.calculateAmount(daysRented)).isEqualTo(expectedAmount);
    }

    @ParameterizedTest(name = "rental for {0} days earns {1} frequent renter points")
    @MethodSource("daysRentedAndFrequentRenterPoints")
    void shouldCalculateFrequentRenterPoints(int daysRented, int expectedFrequentRenterPoints) {
        assertThat(movie.calculateFrequentRenterPoints(daysRented)).isEqualTo(expectedFrequentRenterPoints);
    }

    private static Stream<Arguments> daysRentedAndExpectedAmount() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 3),
                Arguments.of(2, 6),
                Arguments.of(3, 9),
                Arguments.of(4, 12),
                Arguments.of(5, 15)
        );
    }

    private static Stream<Arguments> daysRentedAndFrequentRenterPoints() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(3, 2),
                Arguments.of(50, 2),
                Arguments.of(99, 2)
        );
    }

}
