public class Rental {
	
	private Movie movie;
	private int daysRented;

	public Rental(Movie movie, int daysRented) {
		this.movie = movie;
		this.daysRented = daysRented;
	}

	public double determineAmount() {
		return movie.determineAmount(daysRented);
	}
	
	public int determinePoints() {
		return movie.determinePoints(daysRented);
	}
	
	public String makeItem() {
		return movie.makeItem(daysRented);
	}

}