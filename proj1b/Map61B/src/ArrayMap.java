import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayMap<K, V> implements Map61B <K, V>, Iterable<K> {
    private K[] keys;
    private V[] values;
    private int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    public Iterator<K> iterator() {
        List<K> keylist = keys();
        return keylist.iterator();
    }

    private int keyIndex(K key) {
        for (int i = 0; i < size; i += 1) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsKey(K key) {
        int index = keyIndex(key);
        return (index > -1);
    }

    @Override
    public void put(K key, V value) {
        int index = keyIndex(key);
        if (index > -1) {
            /* keys[index] = key;*/
            values[index] = value;
        } else {
            keys[size] = key;
            values[size] = value;
            size += 1;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public List<K> keys() {
        List<K> keyList = new ArrayList<K>();
        for (int i = 0; i < size; i += 1) {
            keyList.add(keys[i]);
        }
        return keyList;
    }

    @Override
    public V get(K key) {
        int index = keyIndex(key);
        if (index == -1) {
            throw new IllegalArgumentException("The key provided " + key + " was not in the array map");
        }
        return values[index];
    }

}
