package Utils;

/**
 * Created by usa on 7/6/2016.
 */
public class LinkedListNode<T> {
    LinkedListNode pointer;
    private T element;

    public LinkedListNode(T element) {
        this.element = element;
        this.pointer = null;
    }

    public LinkedListNode() {
        this.element = element;
        this.pointer = null;
    }

    public LinkedListNode(LinkedListNode pointer) {
        this.pointer = pointer;
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinkedListNode getPointer() {
        return pointer;
    }

    public void setPointer(LinkedListNode pointer) {
        this.pointer = pointer;
    }
}
