package Sorting;

import DataStruct.Stack;
import edu.princeton.cs.algs4.*;

public class MaxPq<Key extends Comparable<Key>> {
    private Key pq[];
    private int N;

    private void swim(int k) {
        while (k > 1 && less(k/2,k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2;
            if (j< N && less(j,j+1)) j++;
            if (!less(k,j)) break;
            exch(k, j);
            k = j;
        }
    }

    public MaxPq(int MaxN) {
        pq = (Key[]) new Comparable[MaxN+1];
    }

    public void Insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        return pq[1];
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int Size() {
        return N;
    }

    private boolean less(int v, int w) {
        return pq[v].compareTo(pq[w]) < 0;
    }

    private void exch(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]);
        MaxPq<Transaction> pq = new MaxPq<Transaction>(M + 1);
        In in = new In(args[1]);
        String[] a = in.readAllLines();
        for(String item: a) {
            pq.Insert(new Transaction(item));
            if(pq.Size() > M) {
                pq.delMax();
            }
        }

        Stack<Transaction> stack= new Stack<Transaction>();
        StdOut.println(pq.max());
        while (!pq.isEmpty()) stack.push(pq.delMax());
        for (Transaction t: stack) StdOut.println(t);
    }

}
