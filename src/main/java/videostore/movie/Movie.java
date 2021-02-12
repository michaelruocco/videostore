package videostore.movie;

public abstract class Movie {

    private final String title;

    protected Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateAmount(int daysRented);

    public abstract int calculateFrequentRenterPoints(int daysRented);

}