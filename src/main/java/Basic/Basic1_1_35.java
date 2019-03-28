package Basic;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Basic1_1_35 {
    private static int SIDES = 6;
    public static double[] getProbability()
    {
        double[] dist = new double[2*SIDES+1];

        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;

        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= SIDES*SIDES;

        return dist;
    }

    public static double[] getExperiment(int n)
    {
        double[] probability = getProbability();
        double[] dist = new double[2*SIDES+1];
        for(int i = 0; i < n; i ++) {
            int value = StdRandom.discrete(probability);
            dist[value]++;
        }

        for (int k = 2; k <= 2*SIDES; k++)
            dist[k] /= n;

        return dist;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        double[] probability = getProbability();

        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7d", i);
        StdOut.println();

        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", probability[i]);
        StdOut.println();

        double[] experim = getExperiment(n);

        for (int i = 2; i <= 2*SIDES; i++)
            StdOut.printf("%7.3f", experim[i]);
        StdOut.println();

    }

}
