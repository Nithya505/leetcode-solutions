class Solution {

    int rows;
    int cols;
    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        cols = grid[0].length;

        seen = new boolean[rows][cols];

        int max_area = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1 && !seen[i][j]) {
                    max_area = Math.max(max_area, area(i, j, grid));
                }
            }
        }

        return max_area;
    }

    public int area(int row, int col, int[][] grid) {

        // boundary conditions
        if (row < 0 || row >= rows || col < 0 || col >= cols
                || grid[row][col] == 0 || seen[row][col]) {
            return 0;
        }

        seen[row][col] = true;

        return 1
                + area(row + 1, col, grid)
                + area(row - 1, col, grid)
                + area(row, col + 1, grid)
                + area(row, col - 1, grid);
    }
}