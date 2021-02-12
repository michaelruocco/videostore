package videostore.movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegularMovieTest {

    private final Movie movie = new RegularMovie("Regular videostore.movie.Movie");

    @Test
    void shouldCalculateAmount() {
        assertThat(movie.calculateAmount(0)).isEqualTo(2);
        assertThat(movie.calculateAmount(1)).isEqualTo(2);
        assertThat(movie.calculateAmount(2)).isEqualTo(2);
        assertThat(movie.calculateAmount(3)).isEqualTo(3.5);
        assertThat(movie.calculateAmount(4)).isEqualTo(5);
        assertThat(movie.calculateAmount(5)).isEqualTo(6.5);
    }

    @Test
    void shouldCalculateSingleFrequentRenterPointRegardlessOfDaysRented() {
        assertThat(movie.calculateFrequentRenterPoints(0)).isEqualTo(1);
        assertThat(movie.calculateFrequentRenterPoints(1)).isEqualTo(1);
        assertThat(movie.calculateFrequentRenterPoints(2)).isEqualTo(1);
    }

}