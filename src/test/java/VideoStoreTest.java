

import junit.framework.*;

public class VideoStoreTest extends TestCase
{
	private Customer customer;

	private CustomerRentals customerRentals;

	public VideoStoreTest (String name) {
		super (name);
	}
	
	protected void setUp ()  {
		customer = new Customer ("Fred");
	}
	
	public void testSingleNewReleaseStatement () {
		customerRentals = new CustomerRentals(customer, new Rental (new NewReleaseMovie ("The Cell"), 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n",
				customerRentals.generateStatement());
	}

	public void testDualNewReleaseStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new NewReleaseMovie ("The Cell"), 3));
		customerRentals.addRental (new Rental (new NewReleaseMovie("The Tigger Movie"), 3));
		assertEquals ("Rental Record for Fred\n\tThe Cell\t9.0\n\tThe Tigger Movie\t9.0\nYou owed 18.0\nYou earned 4 frequent renter points\n", customerRentals.generateStatement());
	}

	public void testSingleChildrensStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new NewReleaseMovie ("The Tigger Movie"), 3));
		assertEquals ("Rental Record for Fred\n\tThe Tigger Movie\t9.0\nYou owed 9.0\nYou earned 2 frequent renter points\n", customerRentals.generateStatement());
	}
	
	public void testMultipleRegularStatement () {
		customerRentals = new CustomerRentals(customer);
		customerRentals.addRental (new Rental (new RegularMovie ("Plan 9 from Outer Space"), 1));
		customerRentals.addRental (new Rental (new RegularMovie ("8 1/2"), 2));
		customerRentals.addRental (new Rental (new RegularMovie ("Eraserhead"), 3));
		
		assertEquals ("Rental Record for Fred\n\tPlan 9 from Outer Space\t2.0\n\t8 1/2\t2.0\n\tEraserhead\t3.5\nYou owed 7.5\nYou earned 3 frequent renter points\n", customerRentals.generateStatement ());
	}

}