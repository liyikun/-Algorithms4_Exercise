package Find;

public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

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

        public boolean isRed(Node x) {
            if(x == null) return false;
            return x.color;
        }

    }

}
