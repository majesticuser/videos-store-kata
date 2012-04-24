
public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	public double determineAmount(int daysRented) {
		return daysRented * 3;
	}
	
	public int determinePoints(int daysRented) {
		return daysRented > 1 ? 2 : 1;
	}
}
