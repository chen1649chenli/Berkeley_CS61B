/**
 * Array based list
 * @Author: Li Chen
 */
public class Alist<item> implements List61B <item> {
    private item[] item;
    private int size;
    private static int RFACTOR = 2;

    /** Creates an empty list. */
    public Alist() {
        item = (item[]) new Object[100];
        size = 0;
    }
    /**
     * Resize the underlying array to the target capacity
     */
    private void resize(int capacity) {
        item [] a = (item[]) new Object[capacity];
        System.arraycopy(item,0, a,0, size);
        item = a;
    }

    /** Inserts X into the back of the list. */
    @Override
    public void addLast(item x) {
        if (size == item.length) {
            resize(size * RFACTOR);
        }
        item[size] = x;
        size += 1;
    }
    /** Returns the item from the back of the list */
    @Override
    public item getLast() {
        return item[size - 1];
    }

    /** Gets the ith item (the first item is at position 0) */
    @Override
    public item get(int i) {
        return item[i];
    }

    /** Removes the last item from the list */
    @Override
    public item removeLast() {
        item x = getLast();
        item[size] = null;
        size = size - 1;
        return x;
    }
    /** return the size of the list */
    @Override
    public int size(){
        return size;
    }

    /** Adds an item to the first position of the list*/
    @Override
    public void addFirst(item x){
        insert(x, 0);
    }

    /** Gets the first item of the list */
    @Override
    public item getFirst(){
        return item[0];
    }

    /** Inserts an item to the ith position of the list */
    @Override
    public void insert(item x, int i){
        item[] newItems = (item[]) new Object[item.length + 1];

        System.arraycopy(item, 0, newItems, 0, i);
        newItems[i] = x;

        System.arraycopy(item, i, newItems, i + 1, item.length - i);
        item = newItems;
        size = size + 1;
    }
}
