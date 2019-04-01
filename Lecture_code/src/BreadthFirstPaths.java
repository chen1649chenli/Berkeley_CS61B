import java.util.Stack;

public class BreadthFirstPaths {
    private int[] edgeTo;
    private boolean[] marked;
    private final int s;

    public BreadthFirstPaths(Graph G, int s) {
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] = true;
        queue.enqueue(s);
        while(!queue.isEmpty()) {
            int v = queue.dequeue();
            for(int w: G.adj(v)) {
                if (!marked[w]) {
                    queue.enqueue(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }

            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        Stack<Integer> path2 = new Stack<Integer>();
        for (int y = w; y !=s; y = edgeTo[y]) {
            path2.push(y);
        }
        path2.push(s);
        return path2;
    }

}
