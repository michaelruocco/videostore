package videostore;

import videostore.movie.Movie;

public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

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