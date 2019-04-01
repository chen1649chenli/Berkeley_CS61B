import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapHelper {
    public static <K, V> V get(Map61B<K, V> m, K key) {
        if(m.containsKey(key)) {
            return m.get(key);
        } else {
            return null;
        }
    }

    public static <K extends Comparable<K>, V> K maxKey(Map61B<K, V> msi) {
        List<K> keylist = msi.keys();
        K largest = keylist.get(0);
        for (K item : keylist) {
            if (item.compareTo(largest) > 0) {
                largest = item;
            }
        }
        return largest;
    }

    @Test
    public void testget() {
        Map61B<String, Integer> m = new ArrayMap<>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
        Integer actual = MapHelper.get(m, "fish");
        Integer expected = 9;
        assertEquals(expected, actual);
    }

    @Test
    public void testmaxKey() {
        Map61B<String, Integer> m = new ArrayMap<>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
        String actual = MapHelper.maxKey(m);
        String expected = "house" ;
        assertEquals(expected, actual);

    }
}
