package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {
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
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }
    public Item peek() {
        return first.item;
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

    public static <Item> Stack<Item> copy(Stack<Item> s) {
        Iterator<Item> it = s.iterator();
        Stack<Item> result = new Stack<Item>();
        Stack<Item> temp = new Stack<Item>();
        while (it.hasNext()) {
            temp.push(it.next());
        }
        it = temp.iterator();
        while (it.hasNext()){
            result.push(it.next());
        }
        return result;
    }

    public static void main(String[] args) {
//        Stack <String> coll = new Stack<String>();
//        while (!StdIn.isEmpty()) {
//            String item = StdIn.readString();
//            coll.push(item);
//        }
//
//        for(String s: coll) {
//            StdOut.println(s);
//        }
//
//        StdOut.println("(" + coll.Size() + "left on stack)");

        Stack<String> s1 = new Stack<String>();
        s1.push("first");
        s1.push("second");
        s1.push("third");

        Stack<String> s2 = Stack.copy(s1);
        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
}
