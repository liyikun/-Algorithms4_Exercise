package Find;


import DataStruct.Queue;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        Key key;
        Value val;
        private Node left,right;
        private boolean color;
        private int N;

        Node(Key key,Value val,int N,boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        else return x.N;
    }

    public void flipColors(Node x) {
        if(x == null) return;
        x.color = RED;
        if(x.left != null) x.left.color = BLACK;
        if(x.right != null) x.right.color = BLACK;
    }

    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public boolean isRed(Node x) {
        if(x == null) return false;
        return x.color;
    }

    public void put(Key key,Value val) {
        root = put(root,key,val);
        root.color = BLACK;

    }

    public Node put(Node h,Key key,Value val) {
        if(h == null) {
            return new Node(key,val,1,RED);
        }

        int cmp = key.compareTo(h.key);
        if(cmp < 0) h.left = put(h.left,key,val);
        else if(cmp > 0) h.right = put(h.right,key,val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);
        h.N = 1 + size(h.left) + size(h.right);
        return h;
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
    public boolean isEmpty() {
        return root == null;
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


    public static void main(String[] args) {
        RedBlackTree<String, Integer> st = new RedBlackTree<String, Integer>();

        In in = new In(args[0]);
        for (int i = 0; !in.isEmpty(); i++) {
            String key = in.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }

}
