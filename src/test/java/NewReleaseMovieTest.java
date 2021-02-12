import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewReleaseMovieTest {

    private final Movie movie = new NewReleaseMovie("New Release Movie");

    @Test
    void shouldCalculateAmountAsThreeTimesDaysRented() {
        assertThat(movie.calculateAmount(0)).isZero();
        assertThat(movie.calculateAmount(1)).isEqualTo(3);
        assertThat(movie.calculateAmount(2)).isEqualTo(6);
        assertThat(movie.calculateAmount(3)).isEqualTo(9);
        assertThat(movie.calculateAmount(4)).isEqualTo(12);
    }

    @Test
    void shouldCalculateOneFrequentRenterPointIfDaysRentedIsLessOneOrLess() {
        assertThat(movie.calculateFrequentRenterPoints(0)).isEqualTo(1);
        assertThat(movie.calculateFrequentRenterPoints(1)).isEqualTo(1);
    }

    @Test
    void shouldCalculateTwoFrequentRenterPointsIfDaysRentedIsGreaterThanOne() {
        assertThat(movie.calculateFrequentRenterPoints(2)).isEqualTo(2);
        assertThat(movie.calculateFrequentRenterPoints(3)).isEqualTo(2);
    }

}