import java.util.ArrayList;
import java.util.List;

public class CC {
    private boolean[] marked;
    private int[] id;
    private int count = 0;

    public CC(Graph G) {
        id = new int[G.V()];
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s += 1) {
            if (!marked[s]) {
                dfs(G, s);
                count += 1;
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

    public boolean connected(int v, int u) {
        return id[v] == id[u];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        Graph G = new Graph(new In(args[0]));
        CC cc = new CC(G);

        int M = cc.count();
        StdOut.println(M + " components");
        List<Integer>[] components = (List<Integer>[]) new ArrayList[M];

        for (int i = 0; i < M; i += 1) {
            components[i] = new ArrayList<Integer>();
        }

        for (int v = 0; v < G.V(); v += 1) {
            components[cc.id(v)].add(v);
        }

        for (int i = 0; i < M; i += 1) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

    }
}
