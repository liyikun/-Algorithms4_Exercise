package Sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class ThreeQuickSort {
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int lt = lo,i = lo + 1,gt = hi;
        Comparable v = a[lo];
        while (i <= gt) {
            int comp = a[i].compareTo(v);
            if(comp < 0) exch(a,lt++,i++);
            else if(comp>0) exch(a,i,gt--);
            else i++;
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    private static boolean sorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        Integer[] b = new Integer[a.length];
        for(int i =0;i<a.length;i++) {
            b[i] = a[i];
        }
        sort(b);
        assert sorted(b);
        show(b);
    }
}
