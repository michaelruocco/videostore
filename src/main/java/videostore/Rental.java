package videostore;

import lombok.RequiredArgsConstructor;
import videostore.movie.Movie;

@RequiredArgsConstructor
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public String getTitle() {
        return movie.getTitle();
    }

    public double calculateAmount() {
        return movie.calculateAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.calculateFrequentRenterPoints(daysRented);
    }

}