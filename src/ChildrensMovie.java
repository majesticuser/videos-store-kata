public class ChildrensMovie extends Movie {

	public ChildrensMovie(String title) {
		super(title);
	}

	public double determineAmount(int daysRented) {
		double amount = 1.5;
		if (daysRented > 3)
			amount += (daysRented - 3) * 1.5;

		return amount;
	}
	
	public int determinePoints(int daysRented) {
		return 1;
	}
}
