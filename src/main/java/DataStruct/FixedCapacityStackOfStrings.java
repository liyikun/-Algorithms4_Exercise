package DataStruct;

public class FixedCapacityStackOfStrings {
    private int N;
    private String[] a;
    public FixedCapacityStackOfStrings(int len) {
        a = new String[100];
    }
    public void push(String item) {
        a[N++] = item;
    }
    public String pop() {
        return a[--N];
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public int Size() {
        return N;
    }
}
