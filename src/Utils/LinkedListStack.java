package Utils;
import Exception.*;



/**
 * Created by usa on 7/6/2016.
 */
public class LinkedListStack<T > implements ILinkedListStack<T> {
    private LinkedListNode<T> head;
    private int numElement = 0;

    //LinkedListNode<User> currentNode;

    public LinkedListStack() {
        head = null;
    }


    @Override


    public void push(T element) {
        //instantiating a new node each time push method is used
        LinkedListNode<T> node = new LinkedListNode<T>(element);
        //setting currentNode to newly created node
        node.setPointer(head);
        head = node;
        numElement++;
    }

    @Override
    public void pop() {
        T element = head.getElement();
        head = head.getPointer();
        //return null;

    }

    @Override
    public T top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException("Top cannot be operated in an empty stack");
        }

        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (numElement == 0);
    }

    public String toString() {
        LinkedListNode<T> current = head;
        String list = "";
        while (current != null) {
            list += current.getElement() + "\t";
            current = current.getPointer();
        }
        return list;
    }

    @Override
    public int size() {
        return numElement;
    }
}

