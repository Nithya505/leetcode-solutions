class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] effort = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] {0, 0, 0});
        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] min = pq.poll();
            int dist = min[0], row = min[1], col = min[2];

            if (dist > effort[row][col])
                continue;
            if (row == m - 1 && col == n - 1)
                return dist;
            for (int[] d : dir) {
                int newrow = row + d[0];
                int newcol = col + d[1];

                if (newrow >= 0 && newrow < m && newcol >= 0 && newcol < n) {
                    int newdist =
                        Math.max(dist, Math.abs(heights[newrow][newcol] - heights[row][col]));
                    if (newdist < effort[newrow][newcol]) {
                        effort[newrow][newcol] = newdist;
                        pq.offer(new int[] {newdist, newrow, newcol});
                    }
                }
            }
        }
        return 0;
    }
}
