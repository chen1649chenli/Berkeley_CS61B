package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private boolean[][] gridOpenStatus;
    private int openSite;
    private int edgeSize;
    private WeightedQuickUnionUF sets; //One virtual node is used for isFull()
    private WeightedQuickUnionUF sets2; //Two virtual nodes are used for percolate()


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
        openSite = 0;
        sets = new WeightedQuickUnionUF(N * N + 1);
        sets2 = new WeightedQuickUnionUF(N * N + 2);
    }

    public void open(int row, int col) {
        if(isOpen(row, col)) {
            return;
        }
        if (row >= edgeSize || col >= edgeSize ||
                row < 0 ||col < 0) {
            throw new IndexOutOfBoundsException("Illegal coordinate");
        }
        gridOpenStatus[row][col] = true;
        openSite += 1;
        int pos = posConvert(row, col);
        if (row == 0) {
            sets.union(pos, edgeSize * edgeSize);
            sets2.union(pos, edgeSize * edgeSize);
        }

        if (row == edgeSize - 1) {
            sets2.union(pos, edgeSize * edgeSize + 1);
        }

        if (checkLeft(row, col)) {
            int posNeighbor = posConvert(row, col - 1);
            connectNeigbor(pos, posNeighbor);
        }
        if (checkRight(row, col)) {
            int posNeighbor = posConvert(row, col + 1);
            connectNeigbor(pos, posNeighbor);
        }
        if (checkTop(row, col)) {
            int posNeighbor = posConvert(row - 1, col);
            connectNeigbor(pos, posNeighbor);
        }
        if (checkBottom(row, col)) {
            int posNeighbor = posConvert(row + 1, col);
            connectNeigbor(pos, posNeighbor);
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
        return sets.connected(pos, edgeSize * edgeSize);
    }

    public int numberOfOpenSites() {
        return openSite;
    }

    public boolean percolates() {
        return sets2.connected(edgeSize * edgeSize, edgeSize * edgeSize + 1);
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

    private void connectNeigbor(int pos1, int pos2) {
        sets.union(pos1, pos2);
        sets2.union(pos1, pos2);
    }

    private int posConvert(int row, int col) {
        return row * edgeSize + col;
    }

    public static void main(String[] args){

    }



}
