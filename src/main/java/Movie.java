import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Movie
{
	private String title;
	private PriceCode priceCode;

	public abstract Double getRentalAmount(int daysRented);

	public abstract int getFrequenRenterPoints(int daysRented);
}