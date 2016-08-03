package Utils;


import java.io.Serializable;

/**
 * Created by usa on 7/8/2016.
 */
public class ArrayOrderedList<T> implements IList<T>, Serializable {
    private final int DEFCAP = 100;
    protected int location;
    protected int currentPosition;
    private int numOfElements = 0;
    private T orderedList[];
    private int originalSize;

    public ArrayOrderedList() {
        orderedList = (T[]) new Object[DEFCAP];
        numOfElements = 0;
    }

    public ArrayOrderedList(int size) {
        orderedList = (T[]) new Object[size];
        originalSize = size;
        numOfElements = 0;

    }

    @Override
    public void add(T element) {
        int location = 0;
        // T item=orderedList[location];
        if (orderedList.length == numOfElements) {
            enlarge();
        }
        //locating the right position for the element to be added
        for (int i = location; i < size(); i++) {
            T item = orderedList[location];
            if (((Comparable) item).compareTo(element) < 0) {
                location++;
            } else {
                break;
            }
        }
        //shifting the location and adding element
        for (int i = numOfElements; i > location; i--) {
            orderedList[i] = orderedList[i - 1];
        }
        orderedList[location] = element;
        numOfElements++;
    }

    @Override
    public void remove(T element) {
        int location = 0;
        while (location < numOfElements) {
            if (orderedList[location].equals(element)) {
                for (int i = location; i <= numOfElements - 2; i++) {
                    orderedList[i] = orderedList[i++];
                    orderedList[numOfElements - 1] = null;
                    numOfElements--;
                }
            } else {
                location++;
            }
        }


    }

    @Override
    public boolean contains(T element) {
        location = 0;
        boolean found = false;
        while (location < numOfElements) {
            if (orderedList[location].equals(element)) {
                found = true;
            } else {
                location++;
            }
        }
        return found;
    }


    @Override
    public boolean isEmpty() {
        return (numOfElements == 0);
    }

    @Override
    public int size() {
        return numOfElements;
    }

    @Override
    public T get(T element) {
        //contains( element);
        if (contains(element))
            return orderedList[location];
        else
            return null;

    }

    public T getE(int i) {
        return orderedList[i];
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }

    @Override
    public T getNext() {
        T next = orderedList[currentPosition];
        if (currentPosition == (numOfElements - 1))
            currentPosition = 0;
        else
            currentPosition++;

        return next;
    }

    private void enlarge() {
        T[] largerList = (T[]) new Object[2 * originalSize];
        for (int i = 0; i < orderedList.length; i++) {
            largerList[i] = orderedList[i];
        }
        orderedList = largerList;
    }


    public String toString() {
        String list = "";
        for (T value : orderedList) {
            list += value + "\n";
        }
        return list;
    }
}
