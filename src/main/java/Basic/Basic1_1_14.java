package Basic;

import edu.princeton.cs.algs4.StdOut;

public class Basic1_1_14 {
    public static int lg(int N) {
        if(N == 1) return 0;
        if(N == 2) return 1;
        int K = 2;
        int Result = 1;
        while (K < N) {
            K = K * 2;
            Result++;
        }
        return Result - 1;
    }
    public static void main(String[] args) {
        int N = 1000031;
        StdOut.printf("N:%d,Result:%d",N,lg(N));
    }
}
