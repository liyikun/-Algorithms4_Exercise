package Graph;

import edu.princeton.cs.algs4.Stack;

interface Paths {
    boolean hasPathTo(int v);
    Iterable<Integer> pathTo(int v);
}
