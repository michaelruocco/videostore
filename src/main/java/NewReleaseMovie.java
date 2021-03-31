
public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public Double getRentalAmount(int daysRented) {
        return Double.valueOf(daysRented * 3);
    }

    @Override
    public int getFrequenRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }
}
