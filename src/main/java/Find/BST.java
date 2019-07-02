package Find;

import DataStruct.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BST<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left,right;
        private int N;

        public Node(Key key,Value val,int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

    }
    public boolean isEmpty() {
        return root == null;
    }
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        else return x.N;
    }

    public Value get(Key key){
        return get(root,key);
    }

    public Value get(Node x,Key key){
        if(x == null) return null;
        int cmp = x.key.compareTo(key);
        if(cmp > 0) return get(x.left,key);
        else if(cmp < 0) return get(x.right,key);
        else return x.val;
    }


    public void put(Key key,Value val){
        root = put(root,key,val);
    }

    public Node put(Node x,Key key,Value val) {
        if(x == null) return new Node(key,val,1);
        int cmp = x.key.compareTo(key);
        if(cmp > 0) x.left = put(x.left,key,val);
        else if(cmp < 0) x.right = put(x.right,key,val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(),max());
    }

    public Iterable<Key> keys(Key lo,Key hi) {

        Queue<Key> queue = new Queue<Key>();
        keys(root,queue,lo,hi);
        return queue;
    }

    public void keys(Node x,Queue quese,Key lo,Key hi) {
        if(x == null) return;
        int complo = lo.compareTo(x.key);
        int comphi = hi.compareTo(x.key);
        if(complo < 0)keys(x.left,quese,lo,hi);
        if(complo <= 0 && comphi >=0 ) quese.enQueues(x.key);
        if(comphi > 0) keys(x.right,quese,lo,hi);
    }


    public Key max(){
        if(isEmpty()) return null;
        return max(root);
    }

    private Key max(Node x) {
        if(x.right == null) return x.key;
        return max(x.right);
    }

    public Key min() {
        if(isEmpty()) return null;
        return min(root);
    }

    private Key min(Node x) {
        if(x.left == null) return x.key;
        else return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if(x == null) return null;
        return x.key;
    }

    private Node floor(Node x,Key key) {
        if(x == null) return null;
        int comp = x.key.compareTo(key);
        if(comp == 0) return x;
        if(comp > 0) return floor(x.left,key);
        Node t = floor(x.right,key);
        if(t != null) return t;
        else return x;
    }

    public Key select(int k) {
        return select(root,k).key;
    }

    private Node select(Node x,int k) {
        if(x == null) return null;
        int t = size(x);
        if(t > k) return select(x.left,k);
        else if(t < k) return select(x.right,k);
        else return x;
    }

    public int rank(Key key) {
        return rank(key,root);
    }
    private int rank(Key key,Node x) {
        if(x == null) return 0;
        int comp = key.compareTo(x.key);
        if(comp < 0) return rank(key,x.left);
        else if(comp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }


    public Key findRank(int r) {
        return findRank(r,root);
    }

    private Key findRank(int r,Node x) {
        if(x == null) return null;
        if(r < size(x.left)) {
            return findRank(r,x.left);
        } else if(r > size(x.left)) {
            return findRank(r - 1 - size(x.left) ,x.right);
        } else {
            return x.key;
        }
    }

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();

        In in = new In(args[0]);
        for (int i = 0; !in.isEmpty(); i++) {
            String key = in.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));

        System.out.println(st.findRank(1));
    }


    // max min floor ceiling select rank delete deleteMin deleteMax keys
}
