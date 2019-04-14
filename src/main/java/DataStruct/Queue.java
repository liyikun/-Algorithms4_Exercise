package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Queue<Item> implements Iterable<Item>{
    private Node first;
    private Node last;
    private int N;

    public void enQueues(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if(isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }
    public Item deQueues() {
        Item item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        N--;
        return item;
    }
    public int size() {
        return N;
    }
    public boolean isEmpty() {
        return first == null;
    }
    private class Node {
        Item item;
        Node next;
    }
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    class QueueIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }
    public static void main(String[] args) {
        Queue <String> coll = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            coll.enQueues(item);
        }

        for(String s: coll) {
            StdOut.println(s);
        }

        while (!coll.isEmpty()) {
            coll.deQueues();
        }

        StdOut.println("(" + coll.size() + "left on stack)");
    }
}

