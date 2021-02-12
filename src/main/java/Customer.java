
import java.util.ArrayList;
import java.util.Collection;

public class Customer {

    private final String name;
    private final Collection<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String statement() {
        clearTotals();
        String text = header();
        text += rentalLines();
        text += footer();
        return text;
    }

    private void clearTotals() {
        totalAmount = 0;
        frequentRenterPoints = 0;
    }

    private String header() {
        return String.format("Rental Record for %s%n", name);
    }

    private String rentalLines() {
        String rentalLines = "";
        for (Rental each : rentals) {
            double thisAmount = 0;
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
            }

            frequentRenterPoints++;

            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASE
                    && each.getDaysRented() > 1)
                frequentRenterPoints++;

            rentalLines += "\t" + each.getMovie().getTitle() + "\t"
                    + thisAmount + "\n";
            totalAmount += thisAmount;
        }
        return rentalLines;
    }

    private String footer() {
        return String.format("You owed %.1f%nYou earned %d frequent renter points%n", totalAmount, frequentRenterPoints);
    }

}