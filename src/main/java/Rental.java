import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Rental
{
	private Movie movie;
	private int daysRented;

	public Double getRentalAmount() {
		return movie.getRentalAmount(daysRented);
	}

	public int getFrequentRenterPoints() {
		return movie.getFrequenRenterPoints(daysRented);
	}
}