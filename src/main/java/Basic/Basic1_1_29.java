package Basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Basic1_1_29 {

    public static int rank(int key,int[] a){
        int lo = 0;
        int ho = a.length - 1;

        while (lo <= ho) {
            int mid = (lo + ho) / 2;
            if(a[mid] > key) ho = mid - 1;
            if(a[mid] < key) lo = mid + 1;
            else {
                while (a[mid] == key) {
                    mid--;
                };
                return ++mid;
            }
        }

        return -1;
    }

    public static int count(int key,int[] a){
      int c = 0;
      int i = rank(key, a);
      for(;a[i] == key;i++) {
          c++;
      }
      return c;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        String indices = "",
                values = "";
        for (int i = 0; i < whitelist.length; i++)
        {
            indices += String.format("%4d", i);
            values += String.format("%4d", whitelist[i]);
        }
        StdOut.println(indices + "\n" + values);


        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = rank(key, whitelist);
            int count = count(key, whitelist);
            StdOut.println(index);
            StdOut.println(count);
        }
    }

}
