package Basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Basic {
    public static void main(String[] args) {
//        StdOut.println((0+15)/2);
//        StdOut.println((1+2.236)/2);
//        StdOut.println(1+2+3+4.0);
//        StdOut.println((4.1>=4));
//        StdOut.println((1+2+"3"));
//        int a = 1;int b = 2;
//        int c = 3;
//        if(a > b) c = 0;else b = 1;
//
//        int f = 0;
//        int g = 1;
//        for (int i =0; i<=15;i++) {
//            StdOut.println(f);
//            f = f + g;
//            g = f - g;
//        }
//        double t = 9.0;
//        while(Math.abs(t - 9.0/t) > .001) {
//            t = (9.0/t + t) / 2.0;
//        }
//        StdOut.printf("%.5f\n",t);
        int sum = 0;
        for(int i =1;i < 1000;i *=2) {
            for(int j =0;j<1000;j++) {
                sum++;
            }
        }


        StdOut.println(sum);
        System.out.println(('a' + 4));




    }
}
