class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums) sum += n;
        if (sum % k != 0)
            return false;
        int target = sum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > target)
            return false;
        int[] buckets = new int[k];
        return backtrack(nums,n-1,buckets,target);
    }
    private boolean backtrack(int[] nums, int idx, int[] buckets, int target) {
        if (idx < 0)
            return true;
        int val = nums[idx];
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] + val <= target) {
                buckets[i] += val;
                if (backtrack(nums, idx - 1, buckets, target))
                    return true;
                buckets[i] -= val;
            }
            if (buckets[i] == 0)
                break;
        }
        return false;
    }
}