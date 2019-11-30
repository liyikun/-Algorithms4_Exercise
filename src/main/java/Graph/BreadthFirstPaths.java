package Graph;

import DataStruct.Queue;
import DataStruct.Stack;

 class BreadthFirstPaths implements Paths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        BFS(G, s);
    }

    private void BFS(Graph G,int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enQueues(s);

        while (!queue.isEmpty()) {
            int v = queue.deQueues();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enQueues(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v] = true;
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
