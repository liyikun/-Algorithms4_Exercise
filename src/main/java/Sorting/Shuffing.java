package Sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Shuffing {
    public static void Shuffle(String[] a) {
        for(int i = 0  ;i<a.length;i++) {
            int j = StdRandom.uniform(i + 1);
            exch(a,i,j);
        }

    }

    private static void exch(String[] a,int i,int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] a = in.readAllStrings();
        Shuffle(a);
        show(a);

    }
}
