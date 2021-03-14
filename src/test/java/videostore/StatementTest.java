package videostore;

import org.junit.jupiter.api.Test;
import videostore.movie.ChildrensMovie;
import videostore.movie.Movie;
import videostore.movie.NewReleaseMovie;
import videostore.movie.RegularMovie;

import static org.assertj.core.api.Assertions.assertThat;

class StatementTest {

    private final Movie newRelease = new NewReleaseMovie("New Release");
    private final Movie childrens = new ChildrensMovie("Childrens");
    private final Movie regular = new RegularMovie("Regular");

    private final Statement statement = new Statement("Customer Name");

    @Test
    void shouldFormatStatementCorrectly() {
        statement.add(new Rental(newRelease, 3));
        statement.add(new Rental(childrens, 4));
        statement.add(new Rental(regular, 5));

        assertThat(statement.generate()).isEqualTo("Rental Record for Customer Name\n" +
                "\tNew Release\t9.0\n" +
                "\tChildrens\t3.0\n" +
                "\tRegular\t6.5\n" +
                "You owed 18.5\n" +
                "You earned 4 frequent renter points\n");
    }

}
