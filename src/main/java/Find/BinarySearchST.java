package Find;


public class BinarySearchST <Key extends Comparable<Key>,Value>{

    private Key[] keys;
    private Value[] values;

    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Object[capacity];
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

    public void delete() {

    }

    public boolean isEmpty() {
        return N == 0;
    }

}
