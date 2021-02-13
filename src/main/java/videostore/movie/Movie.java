package videostore.movie;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Movie {

    @Getter
    private final String title;

    public abstract double calculateAmount(int daysRented);

    public abstract int calculateFrequentRenterPoints(int daysRented);

}