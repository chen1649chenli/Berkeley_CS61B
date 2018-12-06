package hw2;

public class testPercolationStats {
    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        PercolationStats test1 = new PercolationStats(10, 30 , pf);
        for (int i = 0; i < 30; i++ ) {
            System.out.println(test1.results[i]);
        }
        System.out.println(test1.stddev());
        System.out.println(test1.confidenceHigh());
    }
}
