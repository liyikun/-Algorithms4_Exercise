package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node {
        Item item;
        Node next;
    }
    public int Size() {
        return N;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        Bag <String> coll = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            coll.add(item);
        }

        for(String s: coll) {
            StdOut.println(s);
        }

        StdOut.println("(" + coll.Size() + "left on stack)");
    }
}
