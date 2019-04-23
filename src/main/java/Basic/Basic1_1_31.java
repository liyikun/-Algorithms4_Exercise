package Basic;


import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Basic1_1_31 {

    private static void Draw (int N, double p) {

        StdDraw.setXscale(0, 300);
        StdDraw.setYscale(0, 300);
        StdDraw.setPenRadius(0.01);
        StdDraw.circle(150,150,100);

        StdDraw.setPenRadius(0.05);
        double theta = (double)2 * Math.PI / N;

        double[][] points = new double[N][N];

        for(int i = 0;i < N;i++) {
            double start = theta * i;
            System.out.println(Math.cos(start));
            System.out.println(Math.sin(start));
            double x = Math.cos(start) * 100 + 150;
            double y = Math.sin(start) * 100 + 150;
            points[i][0] = x;
            points[i][1] = y;
            StdDraw.point(x,y);
        }

        StdDraw.setPenRadius(0.01);

        for(int i = 0;i < N; i++) {
            for(int y = i + 1;y < N; y++) {
                if(StdRandom.bernoulli(p)) {
                    StdDraw.line(points[i][0], points[i][1], points[y][0], points[y][1]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Draw(10,.4);



    }

}
