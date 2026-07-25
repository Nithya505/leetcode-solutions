

class DSU {
    int[] parent, rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
        return true;
    }
}

class Solution {

    private int mst(int n, int[][] edges, int skip, int force) {
        DSU dsu = new DSU(n);
        int weight = 0;
        int count = 0;

        // Force include an edge
        if (force != -1) {
            int[] e = edges[force];
            if (dsu.union(e[0], e[1])) {
                weight += e[2];
                count++;
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;

            int[] e = edges[i];
            if (dsu.union(e[0], e[1])) {
                weight += e[2];
                count++;
            }
        }

        return count == n - 1 ? weight : Integer.MAX_VALUE;
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {

        int m = edges.length;

        int[][] newEdges = new int[m][4];

        for (int i = 0; i < m; i++) {
            newEdges[i][0] = edges[i][0];
            newEdges[i][1] = edges[i][1];
            newEdges[i][2] = edges[i][2];
            newEdges[i][3] = i; // original index
        }

        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int baseMST = mst(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            // Critical edge check
            if (mst(n, newEdges, i, -1) > baseMST) {
                critical.add(newEdges[i][3]);
            }
            // Pseudo-critical edge check
            else if (mst(n, newEdges, -1, i) == baseMST) {
                pseudo.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }
}