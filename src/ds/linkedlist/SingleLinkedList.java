package ds.linkedlist;

/*
    implementation of methods of single linked list
 */
public class SingleLinkedList<E> {

    private int size;
    private Node head;
    private Node tail;

    // to iterate all elements
    public void iterate() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value); // to print the value
            temp = temp.next; // to move a step to forward
        }
    }

    // to get a element in given index
    public E get(int index) {
        if (index >= size || size < 0) throw new IndexOutOfBoundsException();

        Node temp = head;
        for (int i = 0; i < index; i++) {
            // to move a step to forward
            temp = temp.next;
        }
        // to return value of the array found
        return temp.value;
    }

    // to add a new element
    public void add(E element) {
        if (head == null) {
            // if there is a no node, head and tail are the same node
            head = tail = new Node(element);
        } else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size++;
    }

    // to delete element from the nodes
    public boolean delete(E element) {
        Node temp = new Node(null, head);
        Node dummy = temp;
        while (temp.next != null) {
            if (temp.next.value.equals(element)) {
                // if found node is last node of the list, need to change tail
                if (temp.next == tail) tail = temp;
                temp.next = temp.next.next;
                // if found node is first node if the list, need to change head
                head = dummy.next;
                size--;
            }
            // to move a step to forward
            temp = temp.next;
        }
        // to return false result if there is not given element
        return false;
    }

    // to check whether node is empty or not
    public boolean isEmpty() {
        return size <= 0;
    }

    // to copy all node element to new node
    public void copy() {
        // to create new node that keeps copied nodes
        Node copy = new Node(null, null);
        Node dummy = copy;
        Node temp = head;

        while (temp != null) {
            copy.next = temp;
            copy = copy.next;
            temp = temp.next;
        }
        copy = dummy.next;

        // to print elements of copied nodes
        while (copy != null) {
            System.out.println(copy.value);
            copy = copy.next;
        }
    }

    // to sort all nodes with insertion sort
    public void insertionSort() {
        if (head == null) throw new NullPointerException();

        Node temp = head;
        Node sentinel = new Node(null, null);

        while (temp != null) {

            Node next_cell = temp;
            temp = temp.next;
            Node after_me = sentinel;

            while (after_me.next != null && (Integer) after_me.next.value < (Integer) next_cell.value) {
                after_me = after_me.next;
            }

            next_cell.next = after_me.next;
            after_me.next = next_cell;
        }

        sentinel = sentinel.next;

        // to print elements of new node
        while (sentinel != null) {
            System.out.println(sentinel.value);
            sentinel = sentinel.next;
        }
    }

    // to sort all nodes with insertion sort && this function works for only int type
    public void selectionSort() {
        Node temp = head;
        Node sentinel = new Node(null, null);
    }

    // to delete all nodes whi are equal to given element
    public boolean deleteAll(E element) {
        Node temp = new Node(null, head);
        Node dummy = temp;
        while (temp != null && temp.next != null) {
            if (temp.next.value.equals(element)) {
                temp.next = temp.next.next;
                head = dummy.next;
                size--;
            }
            // to move a step to forward
            if (temp.value.equals(element))
                temp = temp.next;
        }
        // to return false result if there is not given element
        return false;
    }


    private class Node {
        E value;
        Node next;

        Node(E value) {
            this.value = value;
        }

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}