package Sorting;

public class IndexMinPq<Key extends Comparable<Key>>{
    private int[]pq;
    private int[]qp;
    private Key[] a;
    public IndexMinPq(int max) {
        pq = new int[max + 1];
        qp = new int[max + 1];
        for (int i =0;i<=max;i++) qp[i] = -1;
    }

    public void Insert(int index,Key v) {

    }

    public void change(int key,Key item) {

    }

    private boolean less(int v,int w) {
        return a[v].compareTo(a[w]) < 0;
    }
    private void exch(int i,int j) {
        Key temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public boolean contains(int k) {
        return pq[k] != -1;
    }

    public void delete(int k) {

    }
}
