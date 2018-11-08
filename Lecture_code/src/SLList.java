public class SLList<placeholder> {

    private class IntNode {
        public placeholder item;
        public IntNode next;

        public IntNode(placeholder i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /**
     * Constructs an empty SLList
     */
    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList (placeholder x){
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(placeholder num) {
       sentinel.next =  new IntNode(num, sentinel.next);
       size = size + 1;
    }

    public placeholder getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds an item to the end of the list
     */
    public void addLast(placeholder x) {
        IntNode ptr = sentinel;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new IntNode(x, null);
        size = size + 1;
    }


    /**
     * A method to calculate the size of the SLList
     */

    public int size() {
        return size;

    }

    public static void main(String[] args) {
        SLList<String> L = new SLList();
        L.addLast("I");
        L.addFirst("Love");
        L.addLast("Math");
        System.out.println(L.size());
    }
}
