package Basic;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Basic1_1_22_b {
    public static int rank(int key,int[] a) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo < hi) {
            int mid = lo + hi / 2;

            if(key > a[mid]) {
                lo = mid + 1;
            } else if(key < a[mid]) {
                hi = mid - 1;
            } else {
                return a[mid];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        In in = new In("TinyW.txt");
        int[] whitelist = in.readAllInts();
        Arrays.sort(whitelist);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int index = rank(key, whitelist);
            StdOut.println(index);
        }
    }

}
