package hw2;
import edu.princeton.cs.introcs.Stopwatch;

public class TestPercolationStats {
    public static void main(String[] args) {
        PercolationFactory pf = new PercolationFactory();
        Stopwatch timer1 = new Stopwatch();

        PercolationStats stats = new PercolationStats(100, 30, pf);
        System.out.println(timer1.elapsedTime());

    }
}
