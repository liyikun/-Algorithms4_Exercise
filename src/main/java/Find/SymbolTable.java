package Find;

import DataStruct.Queue;
import edu.princeton.cs.algs4.StdIn;

import java.util.Iterator;

public class SymbolTable<Key, Value>  {
    public void put(Key key,Value val) {

    }

    public Value get(Key key) {
        return null;
    }

    public void delete(Key key) {

    }

    public boolean contains(Key key) {
        return true;
    }

    public boolean isEmpty() {
        return true;
    }

    public int size() {
        return 1;
    }

    public Iterator<Key> keys() {
        return  new KeysIterator();
    }
    class KeysIterator implements Iterator<Key>{

        @Override
        public Key next() {

            return null;
        }

        @Override
        public boolean hasNext() {
            return true;
        }
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
