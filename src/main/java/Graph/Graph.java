package Graph;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

class Graph {
    private int V;
<<<<<<< HEAD
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i ++) {
            adj[i] = new Bag<Integer>();
        }
    }
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for(int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
=======
    private Bag<Integer>[] adj; 

    Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int i = 0; i < V; i ++) {
            adj[i] = new Bag<Integer>(); 
        }
    }
    Graph(In in) {

>>>>>>> eb654a14da547a698eaac25f71cd1c2e73498ebf
    }
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }
    Iterable<Integer> adj(int v) {
<<<<<<< HEAD
        return adj[v];
    }
    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
    @Override
    public String toString() {
        String s = V + " vertices, " + E + " edges \n";
        for(int v  = 0 ; v < V; v++) {
            s += v + ": ";
            for(int w : this.adj(v)) {
                s += w + " ";
            }
            s += " \n";
        }
        return s;
=======
        return adj[v];  
    }
    public int V() {
        
    }
    public int E() {

    }
    @Override
    public String toString() {
        
>>>>>>> eb654a14da547a698eaac25f71cd1c2e73498ebf
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
<<<<<<< HEAD

=======
>>>>>>> eb654a14da547a698eaac25f71cd1c2e73498ebf
}