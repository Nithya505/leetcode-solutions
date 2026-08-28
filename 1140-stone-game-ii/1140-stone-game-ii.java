class Solution {

    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {

        n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        suffix[n - 1] = piles[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = piles[i] + suffix[i + 1];
        }

        return solve(0, 1);
    }

    private int solve(int i, int m) {

        if (2 * m >= n - i)
            return suffix[i];

        if (dp[i][m] != -1)
            return dp[i][m];

        int maxStones = 0;

        for (int x = 1; x <= 2 * m; x++) {

            int opponent = solve(i + x, Math.max(m, x));

            int current = suffix[i] - opponent;

            maxStones = Math.max(maxStones, current);
        }

        return dp[i][m] = maxStones;
    }
}