public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        IntUnaryFunction f = new TenX();
        int x = 2;
        System.out.print(do_twice(f, x));
    }
}
