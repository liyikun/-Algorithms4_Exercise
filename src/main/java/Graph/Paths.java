package Graph;

import edu.princeton.cs.algs4.Stack;

class Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    Paths(Graph G, int s) {
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int w = v; w != v; w = edgeTo[w]) {
            path.push(w);    
        }
        path.push(s);
        return path;
    }
}