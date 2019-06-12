package Find;

import DataStruct.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Iterator;


public class SymbolTable<Key extends Comparable<Key>, Value> {

    private Node first;
    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return true;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return 1;
    }

    public Iterable<Key> keys() {

        return new ArrayList<Key>();
    }


    private class Node {
        Key key;
        Value value;
        Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for(Node x = first; x!=null; x=x.next) {
            if(x.key.compareTo(key) == 0) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key,Value value) {
        for(Node x = first; x!= null; x=x.next) {
            if(x.key.compareTo(key) == 0) {
                x.value = value;
                return;
            }
        }
        Node newnode = new Node(key,value,first);
        first = newnode;
    }


    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);

        SymbolTable<String, Integer> st = new SymbolTable<String, Integer>();

        while(!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if(word.length() < minlen) continue;
            if(!st.contains(word)) st.put(word,1);
            else st.put(word,st.get(word) + 1);
        }

        String max = "";

        st.put(max,0);

        for(String word: st.keys()) {

        }
    }
}
