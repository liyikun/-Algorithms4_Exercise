package Basic;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Basic1_1_15 {
    public static int[] histogram(int[] a,int M) {
        int[] result = new int[M];
        for(int i = 0;i< a.length; i ++) {
            int value = a[i];
            result[value] = result[value] + 1;
        }
        return result;
    }
    public static void main(String[] args) {
        int testM = 100;
        int[] a = new int[100];
        for(int i = 0;i < testM; i ++) {
            a[i] = i;
        }
        int[] result = histogram(a,100);
        StdOut.println(result.length == a.length);
        StdOut.println(Arrays.toString(result));
    }
}
