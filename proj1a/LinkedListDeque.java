public class LinkedListDeque <T> {

    private class Node {
        public T item;
        public Node prev;
        public Node next;

        /**
         * Constructor of Node class
         */
        public Node(T i, Node p, Node n){
            prev = p;
            next = n;
            item = i;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Constructs an empty LinkedListDeque
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = null;
        sentinel.next = null;
        size = 0;
    }

    /**
     * Construct a LinkedListDeque
     */
    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /**
     * Adds an item of type T to the front of the queue
     * @param item
     */
    public void addFirst(T item) {
        sentinel.next = new Node (item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, return null.
     */
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        /* Gets the first item */
        Node firstnode = sentinel.next;
        /* Removes the first item */
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        firstnode.prev = null;
        firstnode.next = null;
        size = size - 1;

        return firstnode.item;
    }

    /**
     * Adds an item of type T to the end of the queue
     * @param item
     */
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /**
     * Removes and returns the item at the end of the deque.
     * If no such item exists, return null.
     */
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        /* Gets the last item */
        Node lastitem = sentinel.prev;;
        /* Removes the last item */
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        lastitem.prev = null;
        lastitem.next = null;
        size = size - 1;

        return lastitem.item;
    }

    /**
     * Returns true if deque is empty, false otherwise.
     * @return
     */
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Returns the number of items in the deque
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Gets the item at the given index
     */
    public T get(int index) {
        if (index >= size || index < 0 ||isEmpty()) {
            return null;
        }
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    /**
     * Gets the item at the given index using recursion
     */
    public T getRevursive(int index) {
        if (index >= size || index < 0 || isEmpty()) {
            return null;
        }
        Node ptr = sentinel.next;
        return recursiveHelper(index,ptr);
    }

    /**
     * Helper function for getRecursive()
     */
    private T recursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return recursiveHelper(index - 1, node.next);
    }

    /**
     * Prints the items in the deque from first to last.
     * Seperated by a space
     */
    public void printDeque() {
        if (isEmpty()) {
            return;
        }
        for (Node p = sentinel.next; p.next != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

}
