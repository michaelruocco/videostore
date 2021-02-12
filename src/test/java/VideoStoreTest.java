import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VideoStoreTest {

    private final Customer customer = new Customer("Fred");

    @Test
    void testSingleNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\tThe Cell\t9.0\n" +
                "You owed 9.0\n" +
                "You earned 2 frequent renter points\n");
        assertThat(customer.getTotalAmount()).isEqualTo(9.0);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(2);
    }

    @Test
    void testDualNewReleaseStatement() {
        customer.addRental(new Rental(new Movie("The Cell", Movie.NEW_RELEASE), 3));
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.NEW_RELEASE), 3));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\tThe Cell\t9.0\n" +
                "\tThe Tigger Movie\t9.0\n" +
                "You owed 18.0\n" +
                "You earned 4 frequent renter points\n");
        assertThat(customer.getTotalAmount()).isEqualTo(18.0);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(4);
    }

    @Test
    void testSingleChildrensStatement() {
        customer.addRental(new Rental(new Movie("The Tigger Movie", Movie.CHILDRENS), 3));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\tThe Tigger Movie\t1.5\n" +
                "You owed 1.5\n" +
                "You earned 1 frequent renter points\n");
        assertThat(customer.getTotalAmount()).isEqualTo(1.5);
        assertThat(customer.getFrequentRenterPoints()).isEqualTo(1);
    }

    @Test
    void testMultipleRegularStatement() {
        customer.addRental(new Rental(new Movie("Plan 9 from Outer Space", Movie.REGULAR), 1));
        customer.addRental(new Rental(new Movie("8 1/2", Movie.REGULAR), 2));
        customer.addRental(new Rental(new Movie("Eraserhead", Movie.REGULAR), 3));

        assertThat(customer.statement()).isEqualTo("Rental Record for Fred\n" +
                "\tPlan 9 from Outer Space\t2.0\n" +
                "\t8 1/2\t2.0\n" +
                "\tEraserhead\t3.5\n" +
                "You owed 7.5\n" +
                "You earned 3 frequent renter points\n");
    }

}