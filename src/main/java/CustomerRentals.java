import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@AllArgsConstructor
@Getter
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
}
