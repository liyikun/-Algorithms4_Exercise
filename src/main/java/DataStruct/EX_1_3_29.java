package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class EX_1_3_29<Item> implements Iterable<Item>{
    private Node last;
    public void enQueues(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        if(last != null)
        {
            newNode.next = last.next;
            last.next = newNode;
            last = newNode;
        } else {
            last = newNode;
            newNode.next = newNode;
        }
    }

    public Item deQueues() {
        Node firstNode = last.next;
        Item firstItem = firstNode.item;
        if(firstNode != last) {
            last.next = firstNode.next;
        } else {
            last = null;
        }
        return firstItem;
    }


    public boolean isEmpty() {
        return last == null;
    }

    class Node {
        Item item;
        Node next;
    }

    public Iterator<Item> iterator() {
        return new QueseIterator();
    }

    private class QueseIterator implements Iterator<Item>{
        private Node current = last.next;
        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public boolean hasNext() {
            return current.next != last.next;
        }
    }

    public static void main(String[] args){
        EX_1_3_29<String> s = new EX_1_3_29();
        while (!StdIn.isEmpty()){
            String item = StdIn.readString();
            if(!item.equals("-"))
                s.enQueues(item);
            else if(!s.isEmpty()) StdOut.print(s.deQueues() + " ");
        }
    }

}
