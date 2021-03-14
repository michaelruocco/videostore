package videostore;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

@RequiredArgsConstructor
public class Statement {

    private final String customerName;
    private final Collection<Rental> rentals = new ArrayList<>();

    public void add(Rental rental) {
        rentals.add(rental);
    }

    public String generate() {
        Collection<String> lines = new ArrayList<>();
        lines.add(header());
        lines.addAll(rentalLines());
        lines.addAll(footer());
        return String.join(lineSeparator(), lines);
    }

    private String header() {
        return String.format("Rental Record for %s", customerName);
    }

    private Collection<String> rentalLines() {
        return rentals.stream()
                .map(this::toRentalLine)
                .collect(Collectors.toList());
    }

    private String toRentalLine(Rental rental) {
        return String.format("\t%s\t%.1f", rental.getTitle(), rental.calculateAmount());
    }

    private Collection<String> footer() {
        return Arrays.asList(
                amountOwedLine(),
                frequentRenterPointsLine()
        );
    }

    private String amountOwedLine() {
        return String.format("You owed %.1f", calculateTotalAmount());
    }

    private String frequentRenterPointsLine() {
        return String.format("You earned %d frequent renter points%n", calculateFrequentRenterPoints());
    }

    private double calculateTotalAmount() {
        return rentals.stream()
                .mapToDouble(Rental::calculateAmount)
                .sum();
    }

    private int calculateFrequentRenterPoints() {
        return rentals.stream()
                .mapToInt(Rental::calculateFrequentRenterPoints)
                .sum();
    }

}
