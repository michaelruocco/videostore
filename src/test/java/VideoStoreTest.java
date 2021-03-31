

import junit.framework.*;
import org.junit.Test;

public class VideoStoreTest extends TestCase
{
	private Customer customer;

	private CustomerRentals customerRentals;

	private CustomerRentalStatement rentalStatement;

	public VideoStoreTest (String name) {
		super (name);
	}
	
	protected void setUp ()  {
		customer = new Customer ("Fred");
	}

	@Test
	public void testSingleChildrenStatement () {
		customerRentals = new CustomerRentals(customer, new Rental (new ChildrenMovie ("Baby's Day Out"), 1));
		rentalStatement = new CustomerRentalStatement(customerRentals);
		assertEquals ("Rental Record for Fred\n\tBaby's Day Out\t1.5\nYou owed 1.5\nYou earned 1 frequent renter points\n",
				rentalStatement.generateStatement());
	}

	@Test
	public void testDualNewReleaseStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new NewReleaseMovie ("The Cell"), 3));
		customerRentals.addRental (new Rental (new NewReleaseMovie("The Tigger Movie"), 3));
		rentalStatement = new CustomerRentalStatement(customerRentals);
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", rentalStatement.generateStatement());
	}

	@Test
	public void testSingleChildrensStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new NewReleaseMovie ("The Tigger Movie"), 3));
		rentalStatement = new CustomerRentalStatement(customerRentals);
		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", rentalStatement.generateStatement());
	}
	
	@Test
	public void testMultipleRegularStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new RegularMovie ("Plan 9 from Outer Space"), 1));
		customerRentals.addRental (new Rental (new RegularMovie ("8 1/2"), 2));
		customerRentals.addRental (new Rental (new RegularMovie ("Eraserhead"), 3));
		rentalStatement = new CustomerRentalStatement(customerRentals);

		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", rentalStatement.generateStatement());
	}

	@Test
	public void testSingleNewReleaseStatement () {
		customerRentals = new CustomerRentals(customer, new Rental (new NewReleaseMovie ("The Cell"), 3));
		rentalStatement = new CustomerRentalStatement(customerRentals);
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n",
				rentalStatement.generateStatement());
	}

}