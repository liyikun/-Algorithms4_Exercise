package Basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Date;

public class Basic1_1_13 {
    public static int[][] replaceArray(int[][] arr) {
        int mlength = arr.length;
        int nlength = arr[0].length;
        int [][] NM = new int[nlength][mlength];
        for(int i = 0;i < mlength; i++) {
            for (int j = 0;j < nlength; j++) {
                NM[j][i] = arr[i][j];
            }
        }
        return NM;
    }
    public static void main(String[] args) {
        Date now = new Date();
        long s = now.getTime();
        StdRandom.setSeed(s);
        int M = 10;
        int N = 10;
        int[][] MN = new int[M][N];
        int mlength = MN.length;
        int nlength = MN[0].length;
        for(int i = 0;i < mlength; i++) {
            for (int j = 0;j < nlength; j++) {
                MN[i][j] = StdRandom.uniform(1, 20);
                StdOut.printf("[%d][%d]:%d",i,j,MN[i][j]);
            }
            StdOut.println();
        }
        int[][] NM = replaceArray(MN);
        for(int i = 0;i < NM.length; i++) {
            for (int j = 0;j < NM[i].length; j++) {
                StdOut.printf("[%d][%d]:%d",i,j,NM[i][j]);
            }
            StdOut.println();
        }
    }
}
