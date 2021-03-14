import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
public class CustomerRentals {

    private Customer customer;
    private List<Rental> rentals;

    public CustomerRentals(Customer customer) {
        this.customer = customer;
        rentals = new ArrayList<>();
    }

    public CustomerRentals(Customer customer, Rental rental) {
        this(customer, Collections.singletonList(rental));
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String generateStatement() {
        double 	totalAmount = 0;
        int	frequentRenterPoints = 0;
        Iterator<Rental> iterator = rentals.iterator();
        String result = "Rental Record for " + customer.getName() + "\n";

        while (iterator.hasNext()) {
            double 	thisAmount = 0;
            Rental rental = iterator.next();
            thisAmount = rental.getRentalAmount();
            totalAmount += thisAmount;
            frequentRenterPoints += rental.getFrequentRenterPoints();

            result += "\t" + rental.getMovie ().getTitle () + "\t"
                    + (thisAmount) + "\n";

        }

        result += "You owed " + (totalAmount) + "\n";
        result += "You earned " + (frequentRenterPoints) + " frequent renter points\n";


        return result;
    }
}
