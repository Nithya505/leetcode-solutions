class Solution {
    public boolean canJump(int[] nums) {
        int finalposition=nums.length-1;
        for(int idx=nums.length-2;idx>=0;idx--){
            if(idx+nums[idx]>=finalposition){
                finalposition=idx;
            }
        }
        return finalposition==0;
        
    }
}
