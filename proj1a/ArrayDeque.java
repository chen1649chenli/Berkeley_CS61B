public class ArrayDeque<T> {

    private int size;
    private T[] placeholder;
    private int nextFirst;
    private int nextLast;
    private int factor;

    public ArrayDeque() {
        placeholder = (T[]) new Object[8];
        nextFirst = 4;
        nextLast = 5;
        size = 0;
        factor = 2;
    }


    public void addFirst(T item) {
        if (needIncreaseSize()) {
            increaseSize();
        }
        placeholder[nextFirst] = item;
        size = size + 1;
        increaseNextFirst();
    }

    public void addLast(T item) {
        if (needIncreaseSize()) {
            increaseSize();
        }
        placeholder[nextLast] = item;
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
            if (pos > placeholder.length - 1) {
                pos = pos - placeholder.length;
            }
            System.out.print(placeholder[pos] + " ");
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
        if (pos >= placeholder.length) {
            pos = pos - placeholder.length;
        }
        return placeholder[pos];
    }

    private boolean needIncreaseSize() {
        return (placeholder.length - size <= 2);
    }

    private boolean needDecreaseSize() {
        return (placeholder.length > 15 && (4 * size < placeholder.length));
    }

    private void increaseSize() {
        if (nextFirst < nextLast) {
            /* Adds new space to the end of the array */
            T[] newplaceholders = (T[]) new Object[placeholder.length * factor];
            System.arraycopy(placeholder, 0, newplaceholders, 0, placeholder.length);
            placeholder = newplaceholders;
        } else if(nextFirst == placeholder.length - 1) {
            T[] newplaceholders = (T[]) new Object[placeholder.length * factor];
            System.arraycopy(placeholder, 0, newplaceholders, 0, placeholder.length);
            nextFirst = newplaceholders.length - 1;
            placeholder = newplaceholders;
        } else if (nextLast == 0) {
            T[] newplaceholders = (T[]) new Object[placeholder.length * factor];
            System.arraycopy(placeholder, 0, newplaceholders, 0, placeholder.length);
            nextLast = placeholder.length;
            placeholder = newplaceholders;
        } else {
            /* Adds new space to the middle of the front and next postion */
            T[] newplaceholders = (T[]) new Object[placeholder.length * factor];
            System.arraycopy(placeholder, 0, newplaceholders, 0, nextLast);
            System.arraycopy(placeholder, nextFirst, newplaceholders,
                    nextFirst + placeholder.length, placeholder.length - nextFirst);
            nextFirst = nextFirst + placeholder.length;
            placeholder = newplaceholders;
        }
    }

    private void decreaseSize() {
        int toBeRemove = placeholder.length / 2;
        if (nextFirst < nextLast || nextLast == 0) {
            T[] newplaceholders = (T[]) new Object[placeholder.length - toBeRemove];
            //int frontToBeRemoved = (nextFirst + 1) % placeholder.length;
            System.arraycopy(placeholder, nextFirst, newplaceholders, 0, size + 2);
            /*Sets the new values for nextFirst and nextLast */
            nextFirst = 0;
            nextLast = size + 1;
            placeholder = newplaceholders;
        } else if (nextFirst == placeholder.length - 1) {
            T[] newplaceholders = (T[]) new Object[placeholder.length - toBeRemove];
            System.arraycopy(placeholder, 0, newplaceholders, 0, size);
            nextFirst = newplaceholders.length - 1;
            placeholder = newplaceholders;
        } else {
            T[] newplaceholders = (T[]) new Object[placeholder.length - toBeRemove];
            int firstPos = newplaceholders.length - (placeholder.length - nextFirst - 1);
            int firstlen = placeholder.length - nextFirst - 1;
            System.arraycopy(placeholder, 0, newplaceholders, 0, nextLast);
            System.arraycopy(placeholder, nextFirst + 1, newplaceholders, firstPos, firstlen);
            nextFirst = firstPos - 1;
            placeholder = newplaceholders;
        }
    }

    private void increaseNextFirst() {
        nextFirst = nextFirst - 1;
        if (nextFirst < 0) {
            nextFirst = nextFirst + placeholder.length;
        }
    }

    private void increaseNextLast() {
        nextLast = nextLast + 1;
        if (nextLast == placeholder.length) {
            nextLast = nextLast - placeholder.length;
        }
    }

    private void decreaseNextFirst() {
        nextFirst = nextFirst + 1;
        if (nextFirst == placeholder.length) {
            nextFirst = 0;
        }
    }

    private void decreaseNextLast() {
        nextLast = nextLast - 1;
        if (nextLast < 0) {
            nextLast = nextLast + placeholder.length;
        }
    }

    private T getFirst() {
        if (nextFirst == placeholder.length - 1) {
            return placeholder[0];
        } else {
            return placeholder[nextFirst + 1];
        }
    }

    private T getLast() {
        if (nextLast == 0) {
            return placeholder[placeholder.length - 1];
        } else {
            return placeholder[nextLast - 1];
        }

    }
}
