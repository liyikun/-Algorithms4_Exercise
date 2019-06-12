package Sorting;


public class IndexMinPq<Key extends Comparable<Key>>{
   private int pq[];
   private int qp[];
   private Key keys[];
   private int N;
   private void exch(int i,int j) {
       int temp = pq[j];
       pq[j] = pq[i];
       pq[i] = temp;
       qp[pq[i]] = i;
       qp[pq[j]] = j;
   }

   private boolean less(int i,int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
   }

   private void swim(int k) {
       while (k > 1 && less(k/2,k)) {
           exch(k,k/2);
           k = k/2;
       }
   }

   private void sink(int k) {
        while (k * 2 <= N) {
            int j = k*2;
            if(k < N && less(j+1,j)) j++;
            if(!less(k,j)) break;
            exch(k,j);
            k = j;
        }
   }


   public IndexMinPq(int Max) {
       keys = (Key[]) new Comparable[Max + 1];
       qp = new int[Max + 1];
       pq = new int[Max + 1];
       for(int i =0;i<=Max;i++) qp[i] = -1;
   }

   public void insert(int index,Key item) {
       pq[++N] = index;
       qp[index] = N;
       keys[index] = item;
       swim(N);
   }

   public void delete(int index) {
       int position = qp[index];

   }

   public Key delMin() {
        return null;
   }

    public int minIndex() {
       return pq[1];
    }

    public Key min() {
       return keys[pq[1]];
    }

   public void change() {

   }

   public boolean contains(int index) {
       return qp[index] != -1;
   }





}
