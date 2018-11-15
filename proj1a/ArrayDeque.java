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
        increaseNextFirst();
    }

    public void addLast(T item) {
        if (needIncreaseSize()) {
            increaseSize();
        }
        Item[nextLast] = item;
        size = size + 1;
        increaseNextLast();

    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size; i++) {
            int pos = nextFirst + i + 1;
            if (pos > Item.length - 1) {
                pos = pos - Item.length;
            }
            System.out.print(Item[pos] + " ");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T stuff = getFirst();
        size = size - 1;
        decreaseNextFirst();
        if (needDecreaseSize()) {
            decreaseSize();
        }
        return stuff;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T stuff = getLast();
        size = size - 1;
        decreaseNextLast();
        if (needDecreaseSize()) {
            decreaseSize();
        }
        return stuff;
    }

    public T get(int index) {
        int pos = nextFirst + index + 1;
        if (pos >= Item.length) {
            pos = pos - Item.length;
        }
        return Item[pos];
    }

    private boolean needIncreaseSize() {
        return (Item.length - size <= 2);
    }

    private boolean needDecreaseSize() {
        return (Item.length > 15 && (4 * size < Item.length));
    }

    private void increaseSize() {
        if (nextFirst < nextLast) {
            /* Adds new space to the end of the array */
            T[] newItems = (T[]) new Object[Item.length * factor];
            System.arraycopy(Item, 0, newItems, 0, Item.length);
            Item = newItems;
        } else if(nextFirst == Item.length -1){
            T[] newItems = (T[]) new Object[Item.length * factor];
            System.arraycopy(Item, 0, newItems, 0, Item.length);
            nextFirst = newItems.length -1;
            Item = newItems;
        }else if (nextLast == 0) {
            T[] newItems = (T[]) new Object[Item.length * factor];
            System.arraycopy(Item, 0, newItems, 0, Item.length);
            nextLast = Item.length;
            Item = newItems;
        }else {
            /* Adds new space to the middle of the front and next postion */
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
        if (nextFirst < nextLast || nextLast == 0) {
            T[] newItems = (T[]) new Object[Item.length - toBeRemove];
            //int frontToBeRemoved = (nextFirst + 1) % Item.length;
            System.arraycopy(Item, nextFirst, newItems, 0, size);
            /*Sets the new values for nextFirst and nextLast */
            nextFirst= 0;
            nextLast = size + 1;
            Item = newItems;
        } else if (nextFirst == Item.length - 1){
            T[] newItems = (T[]) new Object[Item.length - toBeRemove];
            System.arraycopy(Item, 0, newItems, 0, size);
            Item = newItems;
        } else {
            T[] newItems = (T[]) new Object[Item.length - toBeRemove];
            int firstPos = newItems.length - (Item.length - nextFirst - 1);
            int firstlen = Item.length - nextFirst - 1;
            System.arraycopy(Item, 0, newItems, 0, nextLast);
            System.arraycopy(Item, nextFirst + 1, newItems, firstPos, firstlen);
            nextFirst = firstPos - 1;
            Item = newItems;
        }
    }

    private void increaseNextFirst() {
        nextFirst = nextFirst - 1;
        if (nextFirst < 0) {
            nextFirst = nextFirst + Item.length;
        }
    }

    private void increaseNextLast() {
        nextLast = nextLast + 1;
        if (nextLast == Item.length) {
            nextLast = nextLast - Item.length;
        }
    }

    private void decreaseNextFirst() {
        nextFirst = nextFirst + 1;
        if (nextFirst == Item.length) {
            nextFirst = 0;
        }
    }

    private void decreaseNextLast() {
        nextLast = nextLast - 1;
        if (nextLast < 0) {
            nextLast = nextLast + Item.length;
        }
    }

    private T getFirst() {
        if (nextFirst == Item.length - 1) {
            return Item[0];
        } else {
            return Item[nextFirst + 1];
        }
    }

    private T getLast() {
        if (nextLast == 0) {
            return Item[Item.length - 1];
        } else {
            return Item[nextLast - 1];
        }

    }

}
