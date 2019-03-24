package Basic;

import edu.princeton.cs.algs4.StdOut;

public class Basic1_1_20 {
    //https://zh.wikipedia.org/wiki/%E6%96%AF%E7%89%B9%E9%9D%88%E5%85%AC%E5%BC%8F

    private static double Ln(int N) {
        if(N == 1) return 0;
        return Ln(N-1) + Math.log(N);
    }

    public static void main(String[] args) {
        StdOut.println(Ln(10));
    }
}
