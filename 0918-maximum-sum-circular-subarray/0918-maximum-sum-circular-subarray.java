class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;

        int maxending = nums[0];
        int minending = nums[0];

        int maxsofar = nums[0];
        int minsofar = nums[0];

        int total = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];

            maxending = Math.max(x, maxending + x);
            maxsofar = Math.max(maxending, maxsofar);

            minending = Math.min(x, minending + x);
            minsofar = Math.min(minending, minsofar);

            total += x;
        }

            if (maxsofar < 0) {
                return maxsofar;
            }
        

        return Math.max(maxsofar, total - minsofar);
    }
}