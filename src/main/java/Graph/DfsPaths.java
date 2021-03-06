package Graph;

import edu.princeton.cs.algs4.Stack;

class DfsPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;
    DfsPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for(int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }

        path.push(s);
        return path;
    }
}
