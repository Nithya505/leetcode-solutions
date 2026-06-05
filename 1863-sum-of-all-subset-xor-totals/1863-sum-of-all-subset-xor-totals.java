class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums,0,0);
        
    }
    private int backtrack(int[] nums,int idx,int currxor){
        if(idx==nums.length){
            return currxor;
        }
        int include=backtrack(nums,idx+1,currxor^nums[idx]);
        int exclude=backtrack(nums,idx+1,currxor);
        return include+exclude;
    }}