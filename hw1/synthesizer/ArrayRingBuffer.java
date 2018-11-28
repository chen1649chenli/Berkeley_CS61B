package synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T>  extends AbstractBoundedQueue<T> {

    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**Private class to implement iterator*/
    private class KeyIterator implements Iterator<T> {
        private int magicPos;

        public KeyIterator() {
            magicPos = 0;
        }

        public boolean hasNext(){
            return (magicPos < fillCount());

        }

        public T next() {
            int pos = (magicPos + first) % fillCount;
            magicPos += 1;
            return rb[pos];
        }
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (fillCount() == capacity()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount += 1;
        updateLast();
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if(fillCount() == 0) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T returnVal = rb[first];
        updateFirst();
        fillCount -= 1;
        return returnVal;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (fillCount() == 0) {
            throw new RuntimeException("The queue is empty!");
        }
        return rb[first];
    }

    /**
     * Iterator method
     */
    public Iterator<T> iterator() {
        return new KeyIterator();
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.

    /**
     * Helper function to update the instance variable last
     */
    private void updateLast() {
        if (this.last == capacity() -1) {
            this.last = 0;
        } else {
            this.last += 1;
        }
    }

    /**
     * Helper function to update the instance variable first
     */
    private void updateFirst() {
        if(this.first == capacity() - 1) {
            this.first += 0;
        } else {
            this.first += 1;
        }
    }
}
