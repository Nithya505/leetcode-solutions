class Solution {
    public boolean canPartition(int[] nums) {
        int totalsum = 0;
        for (int num : nums) {
            totalsum += num;
        }
        if (totalsum % 2 != 0) {
            return false;
        }
        int target = totalsum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) {
                    dp[j] = true;
                }
            }
        }
        return dp[target];
    }
}
