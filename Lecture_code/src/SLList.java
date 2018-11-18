public class SLList<placeholder> implements List61B<placeholder> {

    private class Node {
        public placeholder item;
        public Node next;

        public Node(placeholder i, Node n) {
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    /**
     * Constructs an empty SLList
     */
    public SLList() {
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList (placeholder x){
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    public void addFirst(placeholder num) {
       sentinel.next =  new Node(num, sentinel.next);
       size = size + 1;
    }

    public placeholder getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds an item to the end of the list
     */
    public void addLast(placeholder x) {
        Node ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new Node(x, null);
        size = size + 1;
    }


    /**
     * A method to calculate the size of the SLList
     */

    public int size() {
        return size;

    }

    public void insert(placeholder item, int position) {
        if (sentinel.next == null || position == 0) {
            addFirst(item);
            return;
        }

        Node currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position -= 1;
            currentNode = currentNode.next;
        }

        Node newNode = new Node(item, currentNode.next);
        currentNode.next = newNode;

    }
    /** Returns the back node of our list. */
    private Node getLastNode() {
        Node p = sentinel;

        /* Move p until it reaches the end. */
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    public placeholder removeLast() {
        Node back = getLastNode();
        if (back == sentinel) {
            return null;
        }

        Node p = sentinel;

        while (p.next != back) {
            p = p.next;
        }
        p.next = null;
        return back.item;

    }

    public placeholder get(int position) {
        if (position == 0) {
            return getFirst();
        }
        Node currentNode = sentinel.next.next;
        while (position > 1 && currentNode.next != null) {
            position -= 1;
            currentNode = currentNode.next;
        }

        return currentNode.item;

    }

    public placeholder getLast(){
        Node back = getLastNode();
        return back.item;

    }

    @Override
    public void print() {
        System.out.print("This is a override method. \n");
        for (Node p = sentinel.next; p != null; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SLList<String> L = new SLList();
        L.addLast("I");
        L.addFirst("Love");
        L.addLast("Math");
        System.out.println(L.size());
    }
}
