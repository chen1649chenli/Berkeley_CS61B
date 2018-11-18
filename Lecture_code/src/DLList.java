public class DLList {

    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode previous;

        public IntNode(int i, IntNode p, IntNode n) {
            item = i;
            next = n;
            previous = p;
        }
    }

    private IntNode sentinel;
    private int size;

    /**
     * Constructs an empty SLList
     */
    public DLList() {
        sentinel = new DLList.IntNode(49, null, null);
        sentinel.previous = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public DLList (int x){
        sentinel = new DLList.IntNode(49, null, null);
        sentinel.next = new DLList.IntNode(x, sentinel, sentinel);
        sentinel.previous = sentinel.next;
        size = 1;
    }

    public void addFirst(int num) {
        sentinel.next =  new IntNode(num, sentinel, sentinel.next);
        sentinel.next.next.previous = sentinel.next;
        size = size + 1;
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds an item to the end of the list
     */
    public void addLast(int x) {
        sentinel.previous = new IntNode(x, sentinel.previous, sentinel);
        sentinel.previous.previous.next = sentinel.previous;
        size = size + 1;

    }


    /**
     * A method to calculate the size of the SLList
     */

    public int size() {
        return size;

    }

    /**
     * Remove the last item in the linked list
     */
    public void removeLast() {
        sentinel.previous.next = null;
        sentinel.previous.previous.next = sentinel;
        sentinel.previous = sentinel.previous.previous;
    }

    public static void main(String[] args) {
        DLList L = new DLList();
        L.addLast(10);
        L.addFirst(11);
        L.addLast(12);
        L.addFirst(13);
        L.removeLast();
        System.out.println(L.size());
    }
}
