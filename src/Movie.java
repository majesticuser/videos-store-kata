
public abstract class Movie {

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	abstract double determineAmount(int daysRented);

	abstract int determinePoints(int daysRented);

	public String makeItem(int daysRented) {
		return "\t" + title + "\t" + determineAmount(daysRented) + "\n";
	}
}