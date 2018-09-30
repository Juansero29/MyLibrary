package utils;

/**
 * Contains two objects of two different types
 * @param <X> - the type of the first object to contain
 * @param <Y> - the type of the second object to contain
 */
public class Tuple<X, Y> {

    public final X x;
    public final Y y;

    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}