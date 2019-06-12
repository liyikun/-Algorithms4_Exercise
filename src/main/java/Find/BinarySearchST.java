package Find;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;
import DataStruct.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchST <Key extends Comparable<Key>,Value>{

    private Key[] keys;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public void put(Key key,Value value) {
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for(int j = N;j > i;j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    private int rank(Key key) {
        return rank(key,0,N-1);
    }

    private int rank(Key key,int lo,int hi) {
        if(lo >= hi) return lo;
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp < 0) return rank(key,lo,mid-1);
        else if(cmp > 0) return rank(key,mid + 1,hi);
        else return mid;
    }

    public Key max() {
        return keys[N-1];
    }

    public Key min() {
        return keys[0];
    }

    public boolean contains(Key key) {
        int i = rank(key);
        return keys[i].compareTo(key) == 0;
    }

    public void delete() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi) {
        Queue<Key> queue = new Queue<Key>();
        for(int i = 0;i<N;i++) {
            queue.enQueues(keys[i]);
        }
        return queue;
    }



    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);

        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>(minlen);

        In in = new In(args[0]);
        while(!in.isEmpty()) {
            String word = in.readString();
            if(word.length() < minlen) continue;
            if(!st.contains(word)) st.put(word,1);
            else st.put(word,st.get(word) + 1);
        }

        String max = "";

        st.put(max,0);

        for(String word: st.keys()) {
            StdOut.println(word + " " + st.get(word));
        }
    }
}
