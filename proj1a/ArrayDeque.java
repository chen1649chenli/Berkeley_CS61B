public class ArrayDeque<T> {

    private int size;
    private T[] Item;
    private int nextFirst;
    private int nextLast;
    private int factor;

    public ArrayDeque() {
        Item = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
        factor = 2;
    }


    public void addFirst(T item) {
        if (needIncreaseSize()) {
            increaseSize();
        }
        Item[nextFirst] = item;
        size = size + 1;
        nextFirst = nextFirst - 1;
    }

    public void addLast(T item) {
        if (needIncreaseSize()) {
            increaseSize();
        }
        Item[nextLast] = item;
        size = size + 1;
        nextLast = nextLast + 1;

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {
        return Item[0];
    }

    public T removeLast() {
        return Item[0];
    }

    public T get(int index) {
        return Item[0];
    }

    private boolean needIncreaseSize() {
        return (Item.length - size <= 2);
    }

    private boolean needDecreaseSize() {
        return (Item.length > 15 && (4 * size < Item.length));
    }

    private void increaseSize() {
        if (nextFirst < nextLast) {
            T[] newItems = (T[]) new Object[Item.length * factor];
            System.arraycopy(Item, 0, newItems, 0, Item.length);
            Item = newItems;
        } else {
            T[] newItems = (T[]) new Object[Item.length * factor];
            System.arraycopy(Item, 0, newItems, 0, nextLast);
            System.arraycopy(Item, nextFirst, newItems,
                    nextFirst + Item.length, Item.length - nextFirst );
            nextFirst = nextFirst + Item.length;
            Item = newItems;
        }
    }

    private void decreaseSize() {
        int toBeRemove = Item.length / 2;
        if (nextFirst < nextLast) {
            int frontToBeRemoved = nextFirst;
            int backToBeRemoved = toBeRemove - frontToBeRemoved;
        }

    }

}
