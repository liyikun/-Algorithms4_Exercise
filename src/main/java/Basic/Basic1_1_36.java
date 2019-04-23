package Basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.stream.IntStream;

public class Basic1_1_36{

    public static int[][] ShuffleTest(int M,int N) {
        int[] initprobability = IntStream.range(0, M).toArray();
        int[][] result = new int[M][M];
        for(int i=0;i< N;i++) {
            StdRandom.shuffle(initprobability);
            for(int j=0;j< M;j++) {
                int value = initprobability[j];
                result[j][value]++;
            }
            initprobability = IntStream.range(0, M).toArray();
        }

        return result;
    }

    public static void main(String[] args) {

        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        int[][] result = ShuffleTest(m,n);

        StdOut.printf("%4s",'|');
        for(int i=0;i<m;i++){
            StdOut.printf("%5d",i);
        }
        StdOut.println();
        StdOut.printf("%4s",'|');
        StdOut.println();

        for(int i=0;i<m;i++){
            StdOut.printf("%d  |", i);
            for(int j=0;j<m;j++)
                StdOut.printf("%5d",result[i][j]);
            StdOut.println();
        }

    }
}
