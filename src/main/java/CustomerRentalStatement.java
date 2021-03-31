import lombok.AllArgsConstructor;

import java.util.Iterator;

@AllArgsConstructor
public class CustomerRentalStatement {

    private CustomerRentals customerRentals;

    public String generateStatement() {
        double 	totalAmount = 0;
        int	frequentRenterPoints = 0;
        Iterator<Rental> iterator = customerRentals.getRentals().iterator();
        String result = "Rental Record for " + customerRentals.getCustomer().getName() + "\n";

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
