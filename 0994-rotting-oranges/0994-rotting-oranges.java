class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0;

        // Put all rotten oranges into queue
        // Count fresh oranges
        for(int i = 0; i < rows; i++) {

            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions: right, down, left, up
        int[][] dirs = {
            {0,1},
            {1,0},
            {0,-1},
            {-1,0}
        };

        int minutes = 0;

        // BFS
        while(!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            // Process one level = one minute
            for(int i = 0; i < size; i++) {

                int[] curr = queue.poll();

                int row = curr[0];
                int col = curr[1];

                // Explore 4 directions
                for(int[] dir : dirs) {

                    int newrow = row + dir[0];
                    int newcol = col + dir[1];

                    // Valid fresh orange
                    if(newrow >= 0 &&
                       newrow < rows &&
                       newcol >= 0 &&
                       newcol < cols &&
                       grid[newrow][newcol] == 1) {

                        // Make rotten
                        grid[newrow][newcol] = 2;

                        fresh--;

                        queue.offer(
                            new int[]{newrow, newcol}
                        );
                    }
                }
            }

            minutes++;
        }

        // If fresh oranges still remain
        if(fresh > 0) {
            return -1;
        }

        return minutes;
    }
}