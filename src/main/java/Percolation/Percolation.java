package Percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation{
    private WeightedQuickUnionUF uf;
    public Percolation(int n) {
        uf = new WeightedQuickUnionUF(22);
        uf.union(0*n+1, 0*n+1);
    }               // create n-by-n grid, with all sites blocked
    public void open(int row, int col) {

    }   // open site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        return true;
    } // is site (row, col) open?

    public boolean isFull(int row, int col)  {
        return true;
    }// is site (row, col) full?
    public int numberOfOpenSites() {
        return 0;
    }      // number of open sites
    public boolean percolates()  {
        return true;
    }           // does the system percolate?
    public static void main(String[] args) {

    }  // test client (optional)
}
