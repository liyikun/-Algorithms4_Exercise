package Graph;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

class Graph {
    private int V;
    private Bag<Integer>[] adj; 

    Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i ++) {
            adj[i] = new Bag<Integer>(); 
        }
    }
    Graph(In in) {

    }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    Iterable<Integer> adj(int v) {
        return adj[v];  
    }
    public int V() {
        
    }
    public int E() {

    }
    @Override
    public String toString() {
        
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for(int _w : G.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0;
        for(int i = 0; i < G.V(); i++) {
            int cur = degree(G, i);
            if(cur > max) {
                max = cur;
            };
        }
        return max;
    }


    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int numberOfSelfLoop(Graph G) {
        int count = 0;
        for(int i = 0; i < G.V(); i++) {
            for(int w : G.adj(i)) {
                if(w == i) {
                    count++;
                }
            }
        }
        return count;
    }
}