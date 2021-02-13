package videostore;

import org.junit.jupiter.api.Test;
import videostore.movie.ChildrensMovie;
import videostore.movie.Movie;
import videostore.movie.NewReleaseMovie;
import videostore.movie.RegularMovie;

import static org.assertj.core.api.Assertions.assertThat;

class VideoStoreTest {

    private final Movie newRelease1 = new NewReleaseMovie("New Release 1");
    private final Movie newRelease2 = new NewReleaseMovie("New Release 2");
    private final Movie childrens = new ChildrensMovie("Childrens");
    private final Movie regular1 = new RegularMovie("Regular 1");
    private final Movie regular2 = new RegularMovie("Regular 2");
    private final Movie regular3 = new RegularMovie("Regular 3");

    private final Statement statement = new Statement("Customer");

    @Test
    void shouldCalculateTwoNewReleaseStatementTotalAmount() {
        setupTwoNewReleaseMovieRentals();

        assertThat(statement.calculateTotalAmount()).isEqualTo(18.0);
    }

    @Test
    void shouldCalculateTwoNewReleaseStatementFrequentRenterPoints() {
        setupTwoNewReleaseMovieRentals();

        assertThat(statement.calculateFrequentRenterPoints()).isEqualTo(4);
    }

    @Test
    void shouldCalculateSingleChildrensStatementTotalAmount() {
        setupSingleChildrensMovieRental();

        assertThat(statement.calculateTotalAmount()).isEqualTo(1.5);
    }

    @Test
    void shouldCalculateSingleChildrensStatementFrequentRenterPoints() {
        setupSingleChildrensMovieRental();

        assertThat(statement.calculateFrequentRenterPoints()).isEqualTo(1);
    }

    @Test
    void shouldCalculateMultipleRegularStatementTotalAmount() {
        setupMultipleRegularMovieRentals();

        assertThat(statement.calculateTotalAmount()).isEqualTo(7.5);
    }

    @Test
    void shouldCalculateMultipleRegularStatementFrequentRenterPoints() {
        setupMultipleRegularMovieRentals();

        assertThat(statement.calculateFrequentRenterPoints()).isEqualTo(3);
    }

    @Test
    void shouldFormatMultipleRegularStatementCorrectly() {
        setupMultipleRegularMovieRentals();

        assertThat(statement.generate()).isEqualTo("Rental Record for Customer\n" +
                "\tRegular 1\t2.0\n" +
                "\tRegular 2\t2.0\n" +
                "\tRegular 3\t3.5\n" +
                "You owed 7.5\n" +
                "You earned 3 frequent renter points\n");
    }

    private void setupTwoNewReleaseMovieRentals() {
        statement.add(new Rental(newRelease1, 3));
        statement.add(new Rental(newRelease2, 3));
    }

    private void setupSingleChildrensMovieRental() {
        statement.add(new Rental(childrens, 3));
    }

    private void setupMultipleRegularMovieRentals() {
        statement.add(new Rental(regular1, 1));
        statement.add(new Rental(regular2, 2));
        statement.add(new Rental(regular3, 3));
    }

}