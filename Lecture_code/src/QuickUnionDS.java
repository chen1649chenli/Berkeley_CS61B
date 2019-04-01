public class QuickUnionDS implements DisjointSets {
    private int[] parent;
    private int[] size;

    public QuickUnionDS(int N) {
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i += 1) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int child) {
        while(child != parent[child]) {
            child = parent[child];
        }
        return child;

    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) return;
        if (size[pid] < size[qid]) {
            parent[pid] = qid;
            size[qid] += size[pid];
        } else {
            parent[qid] = pid;
            size[pid] += size[qid];
        }
    }
}
