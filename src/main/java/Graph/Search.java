package Graph;

import edu.princeton.cs.algs4.QuickUnionUF;

public class Search {
    private QuickUnionUF uf;
    private boolean[] marked;
    private int root;
    Search(Graph G, int s) {
        uf = new QuickUnionUF(G.V());
        marked = new boolean[G.V()];
        root = s;
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for(int i: G.adj(v)) {
            if(!marked[i]) {
                uf.union(v, i);
                dfs(G, i);
            }
        }
    }
    public boolean marked(int v) {
        return uf.connected(root, v);
    }
    public int count() {
        return uf.count();
    }

}
