

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VideoStoreTest
{
	
	private Statement customer;
	private Movie newRelease1;

	
	@Before
	public void setUp ()  {
		customer = new Statement ("Fred");
		newRelease1 = new NewReleaseMovie ("New Release 1");
	}
	
	@Test
	public void testSingleNewReleaseStatement () {
		customer.addRental (new Rental (newRelease1, 3));				
		assertEquals(9.0, customer.getTotal(), 0.001);
		assertEquals(2, customer.getPoints());
	}

	@Test
	public void testDualNewReleaseStatement () {
		Movie newRelease2 = new NewReleaseMovie ("New Release 2");
		customer.addRental (new Rental (newRelease1, 3));
		customer.addRental (new Rental (newRelease2, 3));

		assertEquals(18.0, customer.getTotal(), 0.001);
		assertEquals(4, customer.getPoints());
	}

	@Test
	public void testSingleChildrensStatement () {
		Movie childrensMovie = new ChildrensMovie ("Childrens Movie");
		customer.addRental (new Rental (childrensMovie, 3));

		assertEquals(1.5, customer.getTotal(), 0.001);
		assertEquals(1, customer.getPoints());
	}
	
	@Test
	public void testMultipleRegularStatement () {
		Movie regularMovie1 = new RegularMovie ("Regular Movie 1");
		Movie regularMovie2 = new RegularMovie ("Regular Movie 2");
		Movie regularMovie3 = new RegularMovie ("Regular Movie 3");
		
		customer.addRental (new Rental (regularMovie1, 1));
		customer.addRental (new Rental (regularMovie2, 2));
		customer.addRental (new Rental (regularMovie3, 3));
		
		assertEquals (
			"Rental Record for Fred\n" +
			"\tRegular Movie 1\t2.0\n" +
			"\tRegular Movie 2\t2.0\n" +
			"\tRegular Movie 3\t3.5\n" +
			"You owed 7.5\n" +
			"You earned 3 frequent renter points\n", 
			customer.statement ());
	}

}