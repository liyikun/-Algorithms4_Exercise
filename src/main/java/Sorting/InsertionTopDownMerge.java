package Sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class InsertionTopDownMerge {
    private static Comparable aux[];

    public static void sort(Comparable a[]) {
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable a[], int lo, int hi) {
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        Merge(a,lo,mid,hi);
    }

    public static void Merge(Comparable a[],int lo,int mid,int hi) {

        if(less(a[mid],a[mid + 1])) return;

        for(int k = lo;k<=hi;k++) {
            for(int j = k;j>lo;j--) {
                if(less(a[j],a[j-1])) {
                    exch(a,j,j-1);
                } else {
                    break;
                }
            }
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
