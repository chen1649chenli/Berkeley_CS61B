import java.util.Stack;

public class UnionFind {

    // TODO-done - Add instance variables?
    private int[] parent;

    /* Creates a UnionFind data structure holding n vertices. Initially, all
       vertices are in disjoint sets. */
    public UnionFind(int n) {
        // TODO-done
        for (int i = 0; i < n; i += 1){
            parent[i] = -1;
        }
    }

    /* Throws an exception if v1 is not a valid index. */
    private void validate(int vertex) {
        // TODO-done
        if (vertex >= parent.length || vertex < 0){
            throw new IllegalArgumentException();
        }
    }

    /* Returns the size of the set v1 belongs to. */
    public int sizeOf(int v1) {
        // TODO-done
        validate(v1);
        int root = find(v1);
        return parent(root) ;

    }

    /* Returns the parent of v1. If v1 is the root of a tree, returns the
       negative size of the tree for which v1 is the root. */
    public int parent(int v1) {
        // TODO-done
        validate(v1);
        return this.parent[v1];
    }

    /* Returns true if nodes v1 and v2 are connected. */
    public boolean connected(int v1, int v2) {
        // TODO-done
        return find(v1) == find(v2);
    }

    /* Connects two elements v1 and v2 together. v1 and v2 can be any valid 
       elements, and a union-by-size heuristic is used. If the sizes of the sets
       are equal, tie break by connecting v1's root to v2's root. Unioning a 
       vertex with itself or vertices that are already connected should not 
       change the sets but may alter the internal structure of the data. */
    public void union(int v1, int v2) {
        // TODO-done
        validate(v1);
        validate(v2);

        if (connected(v1, v2)){
            return;
        }else{
            int size_v1 = sizeOf(v1);
            int size_v2 = sizeOf(v2);
            if (size_v1 < size_v2){
                this.parent[find(v2)] = find(v1);
                this.parent[v1] = size_v1 + size_v2;
            }else{
                this.parent[find(v1)] = find(v2);
                this.parent[v2] = size_v1 + size_v2;
            }
        }
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. */
    public int find(int vertex) {
        // TODO-done
        int root = vertex;
        Stack s = new Stack<Integer>();
        while(parent(root) >= 0){
            root = parent(root);
            s.add(root);
        }
        //path compress
        while(s.size() > 0){
            int t = (int)s.pop();
            parent[t] = root;
        }
        return root;
    }

}
