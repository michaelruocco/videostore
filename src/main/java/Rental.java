
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
        return movie.determineAmount(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.determineFrequentRenterPoints(daysRented);
    }

}