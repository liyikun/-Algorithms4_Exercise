package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{

    private int N;
    private Item[] a;

    public ResizingArrayStack(int len) {
        a = (Item[]) new Object[len];
    }

    public void push(Item item) {
        if (N == a.length) resize(2 * a.length);
        a[N++] = item;
    }

    public Item pop() {
        Item item = a[--N];

        a[N] = null;
        if (N > 0 & N == a.length / 4) resize(a.length / 2);

        return item;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int Size() {
        return N;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayInterator();
    }

    private class ReverseArrayInterator implements Iterator<Item> {
        private int i = N;

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        DataStruct.FixedCapacityStack<String> s;
        s = new DataStruct.FixedCapacityStack<String>(100);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.Size() + "left on stack)");
    }


}
