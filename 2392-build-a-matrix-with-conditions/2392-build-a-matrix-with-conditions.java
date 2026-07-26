class Solution {
    int[] toposort(int v, int pairs[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int pair[] : pairs) {
            int u = pair[0];
            int w = pair[1];

            adj.get(u).add(w);
        }

        int indegree[] = new int[v + 1];

        for (int u = 1; u <= v; u++) {
            for (int neighbour : adj.get(u)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (res.size() != v) {
            return new int[0];
        }

        int ans[] = new int[v];

        for (int i = 0; i < v; i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
    public int[][] buildMatrix(int k, int[][] rowconditions, int[][] colconditions) {
        int[] rowtoposort = toposort(k, rowconditions);
        if (rowtoposort.length == 0) {
            return new int[0][0];
        }
        int[] coltoposort = toposort(k, colconditions);
        if (coltoposort.length == 0) {
            return new int[0][0];
        }
        int matrix[][] = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rowtoposort[i] == coltoposort[j]) {
                    matrix[i][j] = coltoposort[j];
                }
            }
        }
        return matrix;
    }
}