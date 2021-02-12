
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Statement {

    private final String customerName;
    private final Collection<Rental> rentals = new ArrayList<>();
    private double totalAmount;
    private int frequentRenterPoints;

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public String generate() {
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
        return String.format("Rental Record for %s%n", customerName);
    }

    private String rentalLines() {
        return rentals.stream()
                .map(this::toRentalLine)
                .collect(Collectors.joining());
    }

    private String toRentalLine(Rental rental) {
        frequentRenterPoints += rental.determineFrequentRenterPoints();
        double rentalAmount = rental.determineAmount();
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