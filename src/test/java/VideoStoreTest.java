import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VideoStoreTest {

    private final Movie newReleaseMovie1 = new Movie("New Release 1", Movie.NEW_RELEASE);
    private final Movie newReleaseMovie2 = new Movie("New Release 2", Movie.NEW_RELEASE);
    private final Movie childrensMovie = new Movie("Childrens", Movie.CHILDRENS);
    private final Movie regular1 = new Movie("Regular 1", Movie.REGULAR);
    private final Movie regular2 = new Movie("Regular 2", Movie.REGULAR);
    private final Movie regular3 = new Movie("Regular 3", Movie.REGULAR);

    private final Statement statement = new Statement("Customer");

    @Test
    void testSingleNewReleaseStatementTotals() {
        statement.add(new Rental(newReleaseMovie1, 3));

        statement.generate();

        assertThat(statement.getTotalAmount()).isEqualTo(9.0);
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(2);
    }

    @Test
    void testDualNewReleaseStatementTotals() {
        statement.add(new Rental(newReleaseMovie1, 3));
        statement.add(new Rental(newReleaseMovie2, 3));

        statement.generate();

        assertThat(statement.getTotalAmount()).isEqualTo(18.0);
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(4);
    }

    @Test
    void testSingleChildrensStatementTotals() {
        statement.add(new Rental(childrensMovie, 3));

        statement.generate();

        assertThat(statement.getTotalAmount()).isEqualTo(1.5);
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(1);
    }

    @Test
    void testMultipleRegularStatementTotals() {
        statement.add(new Rental(regular1, 1));
        statement.add(new Rental(regular2, 2));
        statement.add(new Rental(regular3, 3));

        statement.generate();

        assertThat(statement.getTotalAmount()).isEqualTo(7.5);
        assertThat(statement.getFrequentRenterPoints()).isEqualTo(3);
    }

    @Test
    void testMultipleRegularStatementFormat() {
        statement.add(new Rental(regular1, 1));
        statement.add(new Rental(regular2, 2));
        statement.add(new Rental(regular3, 3));

        assertThat(statement.generate()).isEqualTo("Rental Record for Customer\n" +
                "\tRegular 1\t2.0\n" +
                "\tRegular 2\t2.0\n" +
                "\tRegular 3\t3.5\n" +
                "You owed 7.5\n" +
                "You earned 3 frequent renter points\n");
    }

}