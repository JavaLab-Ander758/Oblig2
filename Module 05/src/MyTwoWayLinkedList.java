import java.util.AbstractSequentialList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class MyTwoWayLinkedList<E> extends AbstractSequentialList<E> implements MyList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public MyTwoWayLinkedList() {
    }

    /**
     * Generates TwoWayLinkedList list with objects in array E[]
     * @param objects Objects to put in new list
     */
    public MyTwoWayLinkedList(E[] objects) {
        this.addAll(Arrays.asList(objects));
    }

    /**
     * @return First element in list || null if list is empty
     */
    public E getFirst() {
        return isEmpty() ? null : head.element;
    }

    /**
     * @return Last element in list || null if list is empty
     */
    public E getLast() {
        return isEmpty() ? null : tail.element;
    }

    /**
     * @return Size of the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Add an element at beginning of list
     * @param e The element to add in list
     */
    public void addFirst(E e) {
        Node<E> newHead = new Node<>(e); // Create a new node
        newHead.next = head; // Link the new node with the head
        head = newHead; // Set head to point to the new node
        size++; // Increase list size

        if (tail == null) { // The new head is the only node in list
            tail = head;
        }
    }

    /**
     * Add an element at end of list
     * @param e The element to add in list
     */
    public void addLast(E e) {
        Node<E> newTail = new Node<>(e); // Create a new node
        if (tail == null) { // The new tail is the only node in list
            head = tail = newTail;
        } else {
            tail.next = newTail; // Now old tail node points to new tail
            tail = tail.next; // Tail now points to the new tail node
        }

        size++; // Increase size
    }

    /**
     * Add an element to list at given index
     * @param index Index in list to add element to
     * @param e The element to add in list
     */
    @Override
    public void add(int index, E e) {
        if (index <= 0) { // Index smaller than 0 means that we set new head
            addFirst(e);
        } else if (index >= size) { // Index larger than size means that we set new tail
            addLast(e);
        } else { // Index is somewhere in the list
            Node<E> current = getNodeAtIndex(--index);
            Node<E> temp = current.next; // Create temporary node to keep next element in list
            current.next = new Node<>(e); // Set current.next to new node
            current.next.next = temp; // New elements next post to element after it in list
            size++; // Increase size
        }
    }

    /**
     * Remove the head node and return removed object in removed noode
     * @return Object contained in removed node
     */
    public E removeFirst() {
        if (isEmpty()) { // No elements in list
            return null;
        } else {
            Node<E> temp = head; // Keep hold of old head
            head = head.next; // Set head to point to next element in list
            size--; // Decrease size
            if (head == null) { // If there were only one element in list then tail needs to point to null
                tail = null;
            }
            return temp.element; // Return deleted element
        }
    }

    /**
     * Remove last element in list
     * @return Object contained in removed node
     */
    public E removeLast() {
        if (size == 0)
            return null;
        else if (size == 1) {
            E temp = head.element;
            clear();
            return temp;
        } else {
            Node<E> current = getNodeAtIndex(size - 2);
            E temp = tail.element; // Keep current tail node element to return it
            tail = current; // Set next to last element as tail
            tail.next = null; // New tail needs to point to null instead of old tail
            size--; // Decrease size
            return temp; // Return old tail
        }
    }

    /**
     * Remove element at specified index in list
     * @param index Index of element to remove from list
     * @return The element that was removed
     */
    @Override
    public E remove(int index) {
        checkIndex(index);

        if (index == 0)
            return removeFirst();
        else if (index == size - 1)
            return removeLast();
        else {
            Node<E> previous = getNodeAtIndex(--index);
            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    /**
     * Override toString() to return elements in the list
     * @return String of elements in the list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;

        for (int i = 0; i < size && current != null; i++, current = current.next) {
            result.append(current.element);
            result.append(", ");
        }

        result.deleteCharAt(result.length() - 1);
        result.append("]");
        return result.toString();
    }

    /**
     * Clear the list
     */
    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    /**
     * Return true if list contains element e
     * @param e Object to look for in list
     * @return boolean
     */
    public boolean contains(Object e) {
        if (size == 0)
            return false; // List was empty

        // Iterate list to find e in list
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element))
                return true;
            current = current.next; // Go to next node
        }
        return false; // e was not found in list
    }

    @Override
    public E get(int index) {
        // Throw out of bounds exception if index is not in list
        checkIndex(index);

        // Iterate list to given index and return its element
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.element;
    }

    /**
     * Check index of specified Object in list
     * @param e Object to look for in list
     * @return Index of match or error value -1 if not found
     */
    @Override
    public int indexOf(Object e) {
        // Return -1 if list is empty
        if (isEmpty())
            return -1;

        // Iterate list and return any index of match
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) // Check for match
                return i;
            current = current.next;
        }

        // Return -1 if no match
        return -1;
    }

    /**
     * Check last index of specified Object in list
     * @param e Object to look for in list
     * @return Last index of match or error value -1 if not found
     */
    @Override
    public int lastIndexOf(Object e) {
        // Return -1 if list is empty
        if (size == 0)
            return -1;

        // Iterate list backwards and return any index of match
        int lastIndex = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) // Check for match
                lastIndex = i;
            current = current.next;
        }

        // Return -1 if no match
        return lastIndex;
    }

    /**
     * Set/replace element in list at given index
     * @param index Index to place element in list
     * @param e Element to add in list
     * @return Element that was removed
     */
    public E set(int index, E e) {
        // Throw out of bounds exception if index is not in list
        checkIndex(index);

        // Iterate list to given index and change its element
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        E cache = current.element;
        current.element = e;
        return cache; // Return the previous element
    }

    /**
     * Get node at specified index
     * @param index Index of node to return in list
     * @return Node at given index in list
     */
    private Node<E> getNodeAtIndex(int index) {
        Node<E> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current;
    }

    /**
     * Check if specified index is valid
     * @param index Index to check in list
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(String.format("Index '%s' is out of bounds of list!", index));
    }


    @Override
    public Iterator<E> iterator() {
        return new TwoWayIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new TwoWayListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new TwoWayListIterator(index);
    }

    private class TwoWayIterator implements Iterator<E> {
        private Node<E> current = head;
        private int index = 0;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }
    }






    private class TwoWayListIterator implements ListIterator<E> {
        private Node<E> current = head;
        private int index = 0;

        public TwoWayListIterator() {
        }

        public TwoWayListIterator(int index) {
            this.index = index;
            for (int i = 0; i < index; i++)
                current = current.next;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            index++;
            return e;
        }

        @Override
        public boolean hasPrevious() {
            return current != null;
        }

        @Override
        public E previous() {
            E e = current.element;
            current = current.previous;
            index--;
            return e;
        }

        @Override
        public int nextIndex() {
            return index;
        }

        @Override
        public int previousIndex() {
            if (hasPrevious())
                return index;
            return -1;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;

        public Node (E element) {
            this.element = element;
        }
    }
}