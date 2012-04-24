import java.util.ArrayList;
import java.util.List;

public class Statement {

	private String customerName;
	private List<Rental> rentals = new ArrayList<Rental>();

	public Statement(String name) {
		this.customerName = name;
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String statement() {
		return makeHeader() + makeItems() + makeFooter();
	}

	private String makeHeader() {
		return "Rental Record for " + customerName + "\n";
	}
	
	private String makeItems() {
		String statement = "";
		for (Rental rental : rentals)
			statement += rental.makeItem();
		return statement;
	}

	private String makeFooter() {
		return "You owed " + getTotal() + "\n" + "You earned " + getPoints() + " frequent renter points\n";
	}

	public double getTotal() {
		double total = 0;
		for (Rental rental : rentals)
			total += rental.determineAmount();
		return total;
	}

	public int getPoints() {
		int points = 0;
		for (Rental rental : rentals) {
			points += rental.determinePoints();
		}
		return points;
	}

}