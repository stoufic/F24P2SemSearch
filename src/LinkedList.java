import java.util.List;

/**
 * The Class LinkedList.
 * 
 * @author toufi
 * @version 10.20.24
 */
public class LinkedList {

    /** The head. */
    private Node head;

    /** The size. */
    private int size;

    /**
     * The Class Node.
     */
    private static class Node {

        /** The data. */
        private Seminar data;

        /** The next. */
        private Node next;

        /**
         * Instantiates a new node.
         *
         * @param data
         *            the data
         */
        Node(Seminar data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Instantiates a new linked list.
     */
    public LinkedList() {
        head = null;
        size = 0;
    }


    /**
     * Adds the.
     *
     * @param seminar
     *            the seminar
     */
    public void add(Seminar seminar) {
        Node newNode = new Node(seminar);
        if (head == null || head.data.id() > seminar.id()) {
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            while (current.next != null && current.next.data.id() <= seminar
                .id()) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }


    /**
     * Gets the.
     *
     * @param index
     *            the index
     * @return the seminar
     */
    public Seminar get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: "
                + size);
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }


    /**
     * Size.
     *
     * @return the int
     */
    public int size() {
        return size;
    }


    /**
     * Checks if is empty.
     *
     * @return true, if is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Removes the.
     *
     * @param i
     *            the i
     */
    public void remove(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: "
                + size);
        }

        if (i == 0) {
            head = head.next;
        }
        else {
            Node current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }


    /**
     * Prints the list.
     */
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data.id() + " ");
            current = current.next;
        }
        System.out.println();
    }


    /**
     * Contains.
     *
     * @param anotherSeminar
     *            the another seminar
     * @return true, if successful
     */
    public boolean contains(Seminar anotherSeminar) {
        return false;
    }
}
