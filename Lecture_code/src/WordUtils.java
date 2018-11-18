public class WordUtils {
    /** Returns the length of the longest word */
    public static String longest(List61B<String> list) {
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++){
            String longestString = list.get(maxIndex);
            String currentString = list.get(i);
            if (longestString.length() < currentString.length()) {
                maxIndex = i;
            }
        }
        return list.get(maxIndex);
    }

    public static void main(String[] args) {
        List61B<String> somelist = new SLList<>();
        somelist.addFirst("I");
        somelist.addLast("Love");
        somelist.addLast("game!");
        //System.out.println(longest(somelist));
        somelist.print();
    }
}
