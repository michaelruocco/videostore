
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
        for (Rental rental : rentals) {
            rentalLines += rentalLine(rental);
        }
        return rentalLines;
    }

    private String rentalLine(Rental rental) {
        double rentalAmount = rental.determineAmount();
        frequentRenterPoints += rental.determineFrequentRenterPoints();
        totalAmount += rentalAmount;
        return formatRentalLine(rental, rentalAmount);
    }



    private String formatRentalLine(Rental rental, double rentalAmount) {
        return String.format("\t%s\t%.1f%n", rental.getTitle(), rentalAmount);
    }

    private String footer() {
        return String.format("You owed %.1f%n" +
                        "You earned %d frequent renter points%n",
                totalAmount, frequentRenterPoints);
    }

}