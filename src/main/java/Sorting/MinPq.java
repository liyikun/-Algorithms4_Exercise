package Sorting;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

public class MinPq<Key extends Comparable<Key>> {
    private Key[] a;
    private int N;
    private void swim(int j) {
        while (j > 1 && less(j,j/2)) {
            exch(j,j/2);
            j = j/2;
        }
    }
    private void sink(int j) {
        while (j * 2 <= N) {
            int k = j * 2;
            if(k< N && less(k+1,k)) k++;
            if(!less(k,j)) break;
            exch(k,j);
            j = k;
        }
    }
    private boolean less(int v,int w) {
        return a[v].compareTo(a[w]) < 0;
    }
    private void exch(int i,int j) {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public MinPq(int max) {
        a = (Key[]) new Comparable[max + 1];
    }
    public void Insert(Key v) {
        a[++N] = v;
        swim(N);
    }
    public Key min() {
        return a[1];
    }

    public Key delMin() {
        Key del = a[1];
        exch(1,N);
        a[N--] = null;
        sink(1);
        return del;
    }

    public boolean isEmpty() {
        return N < 1;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MinPq<Transaction> pq = new MinPq<Transaction>(M);
        In in = new In(args[1]);
        String[] files = in.readAllLines();

        for(String sItem : files) {
            Transaction item = new Transaction(sItem);
            pq.Insert(item);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.delMin());
        }
    }

}
