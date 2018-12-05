package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.junit.Test;
import org.junit.Assert;

public class Percolation {
    private boolean[][] gridOpenStatus;
    private boolean[] gridFullStatus;
    private int openSite;
    private int edgeSize;
    private WeightedQuickUnionUF sets;
    private boolean isPercolate;

    /**
     * Constructs the Percolation class
     */
    public Percolation(int N) {
        if ( N <= 0 ) {
            throw new IllegalArgumentException("Percolation size needs to " +
                    "be a positive integer!");
        }
        edgeSize = N;
        gridOpenStatus = new boolean[N][N];
        for (int i = 0; i < N; i += 1) {
            for (int j = 0; j < N; j += 1) {
                gridOpenStatus[i][j] = false;
            }
        }
        gridFullStatus = new boolean[N * N];
        for (int i = 0; i < N * N; i += 1) {
            gridFullStatus[i] = false;
        }

        openSite = 0;
        sets = new WeightedQuickUnionUF(N * N);
        isPercolate = false;
    }

    public void open(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row < 0 ||col < 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        gridOpenStatus[row][col] = true;
        openSite += 1;
        if (row == 0) {
            int pos = posConvert(row, col);
            gridFullStatus[pos] = true;
        }
        int pos = posConvert(row, col);
        if (checkLeft(row, col)) {
            int posNeighbor = posConvert(row, col - 1);
            updateFullStatus(pos, posNeighbor);
        }
        if (checkRight(row, col)) {
            int posNeighbor = posConvert(row, col + 1);
            updateFullStatus(pos, posNeighbor);
        }
        if (checkTop(row, col)) {
            int posNeighbor = posConvert(row - 1, col);
            updateFullStatus(pos, posNeighbor);
        }
        if (checkBottom(row, col)) {
            int posNeighbor = posConvert(row + 1, col);
            updateFullStatus(pos, posNeighbor);
        }

        if (row == edgeSize - 1 && isFull(row, col) == true) {
            isPercolate = true;
        }

    }

    public boolean isOpen(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row < 0 || col < 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        return gridOpenStatus[row][col];
    }

    public boolean isFull(int row, int col) {
        if (row >= edgeSize || col >= edgeSize ||
                row < 0 ||col < 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        int pos = posConvert(row, col);
        int root = sets.find(pos);
        return gridFullStatus[root];
    }

    public int numberOfOpenSites() {
        return openSite;
    }

    public boolean percolates() {
        return isPercolate;
    }

    private boolean checkLeft(int row, int col) {
        if (col > 0) {
            return gridOpenStatus[row][col - 1];
        }
        return false;
    }

    private boolean checkRight(int row, int col) {
        if (col < edgeSize - 1) {
            return gridOpenStatus[row][col + 1];
        }
        return false;
    }

    private boolean checkTop(int row, int col) {
        if (row > 0) {
            return gridOpenStatus[row - 1][col];
        }
        return false;
    }

    private boolean checkBottom(int row, int col) {
        if (row < edgeSize - 1) {
            return gridOpenStatus[row + 1][col];
        }
        return false;
    }

    private void updateFullStatus(int pos1, int pos2) {
        int rootPos1 = sets.find(pos1);
        int rootPos2 = sets.find(pos2);
        if (gridFullStatus[pos1] || gridFullStatus[pos2] ||
                gridFullStatus[rootPos1] || gridFullStatus[rootPos2]) {
            sets.union(pos1, pos2);
            int newRootPos = sets.find(pos1);
            gridFullStatus[newRootPos] = true;
        } else {
            sets.union(pos1, pos2);
        }
    }

    private int posConvert(int row, int col) {
        return row * edgeSize + col;
    }



}
