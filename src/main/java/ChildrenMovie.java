public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public Double getRentalAmount(int daysRented) {
        double amount = 0;
        amount += 1.5;
        if (daysRented > 3) {
            amount += (daysRented - 3) * 1.5;
        }

        return amount;
    }

    @Override
    public int getFrequenRenterPoints(int daysRented) {
        return 1;
    }
}
