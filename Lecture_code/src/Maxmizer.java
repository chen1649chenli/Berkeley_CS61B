public class Maxmizer {
    public static Comparable max(Comparable[] items) {
        int maxDex = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].compareTo(items[maxDex]) > 0) {
                maxDex = i;
            }
        }
        return items[maxDex];
    }

    public static void main(String[] args) {
        Dog[] dogs = {new Dog("Li", 6), new Dog("Ling", 7),
                new Dog("Liang", 9)};
        Dog maxDog =  (Dog) max(dogs);
        maxDog.bark();
    }
}
