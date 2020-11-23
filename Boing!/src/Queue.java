import java.util.NoSuchElementException;

/**
 * A class that implements a Queue. It uses a linkedList from the QueueElement class.
 * This is implement using generics.
 *
 * @author 1909148
 */
public class Queue<T> {
    private QueueElement<T> head;
    private QueueElement<T> tail;
    private int currentSize;

    /**
     * This constructs an empty Queue.
     */
    public Queue() {
        this.head = null;
        this.tail = null;
        currentSize = 0;
    }

    /**
     * This method will check if the Queue is empty.
     *
     * @return Will return true if Queue is empty, else false.
     */
    public boolean isEmpty() {
        if ((head == null) && (tail == null)) {
            currentSize = 0;
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method gets the element at the head of the Queue.
     *
     * @return The element at the head of the Queue.
     * @throws NoSuchElementException When the Queue is empty.
     */
    public T peek() throws NoSuchElementException {
        if (head == null) { //can use tenery operation
            throw new NoSuchElementException();
        } else {
            return head.getElement();
        }
    }

    /**
     * This method will remove an element from the front of the Queue.
     *
     * @throws NoSuchElementException When the Queue is empty.
     */
    public void dequeue() throws NoSuchElementException {
        //Dequeue code is need here
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (head == tail) {
            head = null;
            tail = null;
            currentSize = 0;
        } else {
            head = head.getNext();
            currentSize--;
        }

    }

    /**
     * This method will add an element at the rear of the Queue.
     * The currentsize will increment as an item is added.
     *
     * @param element The element that is added to the Queue.
     */
    public void enqueue(T element) {
        final QueueElement<T> temp = new QueueElement<>(element, head);
        if (isEmpty()) {
            head = tail = temp;
        } else {
            tail.setNext(temp);
            tail = temp;
            currentSize++;
        }
    }

    /**
     * Method to print the full contents of the queue in order from head to tail.
     * This will iterate through the entire queue and print all the elements in the Queue.
     */
    public void print() {
        //Code to print the code is needed here
        QueueElement<T> temp = head;
        for (int i = 0; i < currentSize; i++) {
            System.out.println(temp.getElement());
            temp = temp.getNext();
        }
    }
}
