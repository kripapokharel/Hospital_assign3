package Utils;
import Exception.IndexOutOfBoundException;
import Exception.OverflowException;
import Exception.UnderflowException;

/**
 * Created by usa on 7/6/2016.
 */
public interface IStack<T> {
    T top() throws UnderflowException;

    void pop() throws UnderflowException;

    boolean isEmpty();

    int size();

}
