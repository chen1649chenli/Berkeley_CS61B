package hw3.hash;

import java.util.*;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        int size = oomages.size();
        int min = size / 50;
        int max = (int) (size / 2.5);

        HashMap<Integer, Integer> tracker = new HashMap<>();
        for (Oomage oomage : oomages) {
            int bucketNum = (oomage.hashCode() & 0x7FFFFFFF) % M;
            if (tracker.containsKey(bucketNum)) {
                int val = tracker.get(bucketNum);
                tracker.put(bucketNum, val + 1);
            }else {
                tracker.put(bucketNum, 1);
            }
        }

        Set<Integer> trackerKeys = tracker.keySet();
        for (Integer i : trackerKeys) {
            int val = tracker.get(i);
            if (val <= min || val >= max) {
                return false;
            }
        }
        return true;

    }
}
