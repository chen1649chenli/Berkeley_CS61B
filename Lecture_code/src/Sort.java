public class Sort {

    public static int findSmallest(String[] x, int start) {

        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }

    public static void sort(String[] x) {
        sort(x, 0);
    }

    public static void sort(String[] x, int start){
        if (start == x.length - 1) {
            return;
        }else {
            int smallestIndex = findSmallest(x, start);
            swap(x, smallestIndex, start);
            sort(x, start + 1);
        }
    }

}
