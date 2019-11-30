package Graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import org.junit.jupiter.api.Test;



class GraphTest {

    @Test
    void TestNew() {
        String rootPath = this.getClass().getResource("/tinyG.txt").getPath();
        int s = 9;
        Graph G = new Graph(new In(rootPath));
        Search search = new Search(G, s);

        for(int v = 0;v < G.V(); v++) {
            if(search.marked(v)) {
                StdOut.println(v);
            }
        }

        if(search.count() != G.V()) {
            StdOut.println("Not connected");
        }

    }

    <T extends Paths> void PrintS(T search,Graph G,int s) {
        for(int v = 0; v < G.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if(search.hasPathTo(v))
                for(int x : search.pathTo(v)) {
                    if(x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
                }
            StdOut.println();
        }
    }

    @Test
    void TestDfsPaths() {
        String rootPath = this.getClass().getResource("/mediumG.txt").getPath();
        Graph G = new Graph(new In(rootPath));
        int s = 0;
        Paths search = new DfsPaths(G, s);
        PrintS(search,G, s);
    }

    @Test
    void TestBfsPaths() {
        String rootPath = this.getClass().getResource("/mediumG.txt").getPath();
        Graph G = new Graph(new In(rootPath));
        int s = 0;
        Paths search = new BreadthFirstPaths(G, s);
        PrintS(search,G, s);
    }


    @Test
    void TestSymbolGraph() {
        String rootPath = this.getClass().getResource("/movies.txt").getPath();

        String delim = "/";

        SymbolGraph sg = new SymbolGraph(rootPath, delim);

        Graph G = sg.G();

        String source = "À la folie... pas du tout (2002)";
        for(int w : G.adj(sg.index(source))) {
            StdOut.println("  "+ sg.name(w));
        }


    }


    @Test
    void DegreesOfSymbolGraph() {
        String rootPath = this.getClass().getResource("/movies.txt").getPath();

        String delim = "/";

        SymbolGraph sg = new SymbolGraph(rootPath, delim);

        Graph G = sg.G();

        String source = "Merino, Ángel";

        int s = sg.index(source);

        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);

        for(int v = 0; v < G.V(); v++) {
            StdOut.print(sg.name(s) + " to " + sg.name(v) + ": ");
            if(bfs.hasPathTo(v))
                for(int x : bfs.pathTo(v)) {
                    if(x == s) StdOut.print(sg.name(x));
                    else StdOut.print("-" + sg.name(x));
                }
            StdOut.println();
        }

    }
}
