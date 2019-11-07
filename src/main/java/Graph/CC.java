package Graph;

class CC {
    private Boolean[] marked;
    private int count;
    private int[] id;

    CC(Graph G) {
        marked = new Boolean[G.V()];

        for (int v = 0; v < marked.length; v++) {
            if (!marked[v]) {
                dfs(G, v);
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

    public int Count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

}