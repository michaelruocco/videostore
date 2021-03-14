
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Customer
{
	private String name;
	
	public String getName () {
		return name;
	}
}