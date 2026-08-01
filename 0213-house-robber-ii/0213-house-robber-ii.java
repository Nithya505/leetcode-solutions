class Solution {
    public int rob(int[] nums) {
        if (nums.length < 2)
            return nums[0];
        int[] skipfirsthouse = new int[nums.length - 1];
        int[] skiplasthouse = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            skiplasthouse[i] = nums[i];
            skipfirsthouse[i]= nums[i + 1];
        }
        int lootskippinglast = robhelper(skiplasthouse);
        int lootskippingfirst = robhelper(skipfirsthouse);
        return Math.max(lootskippinglast, lootskippingfirst);
    }
    private int robhelper(int[] nums) {
        if(nums.length<2)return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
