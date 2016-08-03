package Utils;

/**
 * Created by usa on 7/11/2016.
 */
public interface IList<T> {
    void add(T element);

    void remove(T element);

    boolean contains(T element);

    boolean isEmpty();

    int size();

    T get(T element);

    void reset();

    T getNext();

    String toString();

}
