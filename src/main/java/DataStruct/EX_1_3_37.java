package DataStruct;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class EX_1_3_37 {
    public static void main(String[] args) {
        Queue<Integer> josephus = new Queue<Integer>();
        int N = StdIn.readInt();
        int M = StdIn.readInt();

        for(int i =0;i <N;i++) {
            josephus.enQueues(new Integer(i));
        }

        int k = 0;
        while (!josephus.isEmpty()) {
            int x = josephus.deQueues();
            if(++k % M == 0) {
                StdOut.println(x);
            } else {
                josephus.enQueues(x);
            }
        }

    }
}
