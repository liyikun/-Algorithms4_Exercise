package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class ResizingArrayQueueOfStrings<Item> implements Iterable<Item>{

    private Item[] q;
    private int S;
    private int E;
    private int l;

    ResizingArrayQueueOfStrings(int len) {
        q = (Item[]) new Object[len];
        l = len;
    }
    public void enQueues(Item item) {
        if(E == l) resize(l * 2);
        q[E++] = item;
    }
    public Item deQueues() {
        Item item = q[S];
        q[S++] = null;
        if(size() < l / 4) resize(l/2);
        return item;
    }
    public int size() {
        return E - S;
    }
    public boolean isEmpty() {
        return S == E;
    }
    private void resize(int max) {
        System.out.println(max);
        Item[] t = (Item[]) new Object[max];
        int c = 0;
        for(int i = S;i < E; i++) {
            t[c++] = q[i];
        }
        S = 0;
        E = c;
        l = max;
        q = t;
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<Item> {
        private int current = S;
        private int last = E;
        @Override
        public Item next() {
            return q[current++];
        }

        @Override
        public boolean hasNext() {
            return current == last;
        }
    }

    public static void main(String[] args){
        ResizingArrayQueueOfStrings<String> s;
        s = new ResizingArrayQueueOfStrings<String>(10);
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.enQueues(item);
            else if(!s.isEmpty()) StdOut.print(s.deQueues() + " ");
        }
        StdOut.println("(" + s.size() + "left on queues)");
    }

}
