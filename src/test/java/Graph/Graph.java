package Graph;

import edu.princeton.cs.algs4.In;
import org.junit.jupiter.api.Test;



class GraphTest {

    @Test
    void TestNew() {
        String rootPath = this.getClass().getResource("/tinyG.txt").getPath();

        Graph G = new Graph(new In(rootPath));
    }
}
