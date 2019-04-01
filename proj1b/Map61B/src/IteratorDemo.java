public class IteratorDemo {
    public static void main(String[] args) {
        ArrayMap<String, Integer> am = new ArrayMap<>();
        am.put("hello", 5);
        am.put("syrups", 10);
        am.put("kimdom", 10);

        for (String s : am) {
            System.out.println(s);
        }
    }

}
