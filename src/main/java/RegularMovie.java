public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public Double getRentalAmount(int daysRented) {
        double amount = 0;
        amount += 2;
        if (daysRented > 2) {
            amount += (daysRented - 2) * 1.5;
        }

        return amount;
    }

    @Override
    public int getFrequenRenterPoints(int daysRented) {
        return 1;
    }
}
