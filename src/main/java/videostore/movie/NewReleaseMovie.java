package videostore.movie;

public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * 3d;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }

}