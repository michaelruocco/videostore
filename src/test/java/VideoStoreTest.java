import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VideoStoreTest {

    private final Movie newReleaseMovie1 = new Movie("New Release 1", Movie.NEW_RELEASE);
    private final Movie newReleaseMovie2 = new Movie("New Release 2", Movie.NEW_RELEASE);
    private final Movie childrensMovie = new Movie("Childrens", Movie.CHILDRENS);
    private final Movie regular1 = new Movie("Regular 1", Movie.REGULAR);
    private final Movie regular2 = new Movie("Regular 2", Movie.REGULAR);
    private final Movie regular3 = new Movie("Regular 3", Movie.REGULAR);

    private final Customer customer = new Customer("Customer");

    @Test
    void testSingleNewReleaseStatementTotals() {
        customer.addRental(new Rental(newReleaseMovie1, 3));

        customer.statement();

        assertThat(customer.getTotalAmount()).isEqualTo(9.0);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(2);
    }

    @Test
    void testDualNewReleaseStatementTotals() {
        customer.addRental(new Rental(newReleaseMovie1, 3));
        customer.addRental(new Rental(newReleaseMovie2, 3));

        customer.statement();

        assertThat(customer.getTotalAmount()).isEqualTo(18.0);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(4);
    }

    @Test
    void testSingleChildrensStatementTotals() {
        customer.addRental(new Rental(childrensMovie, 3));

        customer.statement();

        assertThat(customer.getTotalAmount()).isEqualTo(1.5);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(1);
    }

    @Test
    void testMultipleRegularStatementTotals() {
        customer.addRental(new Rental(regular1, 1));
        customer.addRental(new Rental(regular2, 2));
        customer.addRental(new Rental(regular3, 3));

        customer.statement();

        assertThat(customer.getTotalAmount()).isEqualTo(7.5);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(3);
    }

    @Test
    void testMultipleRegularStatementFormat() {
        customer.addRental(new Rental(regular1, 1));
        customer.addRental(new Rental(regular2, 2));
        customer.addRental(new Rental(regular3, 3));

        assertThat(customer.statement()).isEqualTo("Rental Record for Customer\n" +
                "\tRegular 1\t2.0\n" +
                "\tRegular 2\t2.0\n" +
                "\tRegular 3\t3.5\n" +
                "You owed 7.5\n" +
                "You earned 3 frequent renter points\n");
    }

}