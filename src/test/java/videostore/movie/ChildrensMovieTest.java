package videostore.movie;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ChildrensMovieTest {

    private final Movie movie = new ChildrensMovie("Childrens videostore.movie.Movie");

    @Test
    void shouldCalculateAmount() {
        assertThat(movie.calculateAmount(0)).isEqualTo(1.5);
        assertThat(movie.calculateAmount(1)).isEqualTo(1.5);
        assertThat(movie.calculateAmount(2)).isEqualTo(1.5);
        assertThat(movie.calculateAmount(3)).isEqualTo(1.5);
        assertThat(movie.calculateAmount(4)).isEqualTo(3);
        assertThat(movie.calculateAmount(5)).isEqualTo(4.5);
    }

    @Test
    void shouldCalculateOneFrequentRenterPointRegardlessOfDaysRented() {
        assertThat(movie.calculateFrequentRenterPoints(0)).isEqualTo(1);
        assertThat(movie.calculateFrequentRenterPoints(1)).isEqualTo(1);
        assertThat(movie.calculateFrequentRenterPoints(2)).isEqualTo(1);
    }

}