package hw2;

import edu.princeton.cs.introcs.StdRandom;
import edu.princeton.cs.introcs.StdStats;

public class PercolationStats {
    public double[] results;
    private int T;


    // perform T independent experiments on an N-by-N grid
    public PercolationStats(int N, int T, PercolationFactory pf) {
        if (N <= 0 ) {
            throw new IllegalArgumentException("N is less than 0!");
        }
        if (T <= 0) {
            throw new IllegalArgumentException("Simulation cycle has to be greater than 0!");
        }
        this.T = T;
        results = new double[T];
        for (int i = 0; i < T; i += 1) {
            Percolation grid = pf.make(N);
            results[i] = simulate(grid, N);
        }

    }
    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);

    }
    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return StdStats.mean(results) - 1.96 * StdStats.stddev(results) / Math.sqrt(T);

    }
    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return StdStats.mean(results) + 1.96 * StdStats.stddev(results) / Math.sqrt(T);
    }

    private double simulate(Percolation grid, int N) {
        while(!grid.percolates()) {
            int row = StdRandom.uniform(N);
            int col = StdRandom.uniform(N);
            grid.open(row, col);
        }
        return (double) grid.numberOfOpenSites() / (N * N);
    }
}
