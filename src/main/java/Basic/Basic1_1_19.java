package Basic;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Basic1_1_19 {
    private static HashMap<Integer, Long> result = new HashMap<>();
    private static long F (int N)
    {

        if(N == 0) return 0;
        if(N == 1) return 1;
        if(result.containsKey(N)) {
            return result.get(N);
        }
        long v = F(N - 1) + F(N - 2);
        result.put(N, v);
        return v;
    }
    public static void main(String[] args) {
        for(int N =0;N<100;N++) {
            StdOut.println(N + " " + F(N));
        }
    }
}
