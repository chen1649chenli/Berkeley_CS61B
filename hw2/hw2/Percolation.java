package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int[][] grid;
    private int openSite;
    private int edgeSize;

    /**
     * Constructs the Percolation class
     */
    public Percolation(int N) {
        if ( N <=0 ) {
            throw new IllegalArgumentException("Percolation size needs to " +
                    "be a positive integer!");
        }
        edgeSize = N;
        grid = new int[N][N];
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                grid[i][j] = 0;
            }
        }
        openSite = 0;
    }

    public void open(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row <= 0 ||col <= 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        grid[row][col] = 1;
        openSite += 1;
    }

    public boolean isOpen(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row <= 0 ||col <= 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        return grid[row][col] == 1;
    }

    public boolean isFull(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row <= 0 ||col <= 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        return false;
    }

    public int numberOfOpenSites() {
        return openSite;
    }

    public boolean percolates() {
        return false;
    }

    public static void main(String[] args) {

    }

}
