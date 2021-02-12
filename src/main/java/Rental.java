
public class Rental {

    private final Movie movie;
    private final int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public double determineAmount() {
        double rentalAmount = 0;
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    public int determineFrequentRenterPoints() {
        boolean bonusEarned = movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1;
        if (bonusEarned) {
            return 2;
        }
        return 1;
    }

    public String getTitle() {
        return movie.getTitle();
    }

}