
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Statement {

    private final String customerName;
    private final Collection<Rental> rentals = new ArrayList<>();

    public Statement(String customerName) {
        this.customerName = customerName;
    }

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::calculateAmount)
                .sum();
    }

    public int calculateFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::calculateFrequentRenterPoints)
                .sum();
    }

    public String generate() {
        String text = header();
        text += rentalLines();
        text += footer();
        return text;
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
        return formatRentalLine(rental);
    }

    private String formatRentalLine(Rental rental) {
        return String.format("\t%s\t%.1f%n", rental.getTitle(), rental.calculateAmount());
    }

    private String footer() {
        return String.format("You owed %.1f%n" +
                        "You earned %d frequent renter points%n",
                calculateTotalAmount(), calculateFrequentRenterPoints());
    }

}