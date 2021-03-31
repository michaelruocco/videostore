import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Movie
{
	private String title;

	public abstract Double getRentalAmount(int daysRented);

	public abstract int getFrequenRenterPoints(int daysRented);
}