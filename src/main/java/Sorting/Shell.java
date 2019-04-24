package Sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
    public static void sort(Comparable[] a) {
        int N = 1;
        while (N < a.length / 3) N = N*3 + 1;
        while (N >= 1) {
            for(int i = N;i < a.length; i ++) {
                for(int j = i;j>=N && less(a[j],a[j-N]);j -= N) {
                    exch(a,j,j - N);
                }
            }
            N = N / 3;
        }
    }
    private static boolean less(Comparable v,Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Comparable[] a,int i,int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }
    private static boolean sorted(Comparable[] a) {
        for(int i = 1;i<a.length;i++)
            if(less(a[i],a[i-1])) return false;
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
