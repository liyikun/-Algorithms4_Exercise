package Graph;

class CC {
    private Boolean[] marked;
    private int count;
    private int[] id;

    CC(Graph G) {
        marked = new Boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    public void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }

    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int Count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

}