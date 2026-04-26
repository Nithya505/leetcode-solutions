class Solution {
    public int splitArray(int[] nums, int k) {
        int low=0,high=0;
        for(int num:nums){
            low=Math.max(low,num);
            high+=num;
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(cansplit(nums,k,mid)){
                high=mid;
            }else{
                low=mid+1;
            }
        }
        return low;
        
    }
    private boolean cansplit(int[] nums,int k,int maxsumallowed){
        int count=1,currentsum=0;
        for(int num:nums){
            if(currentsum+num>maxsumallowed){
                count++;
                currentsum=num;
            }else{
                currentsum+=num;
            }
        }
        return count<=k;
    }
}