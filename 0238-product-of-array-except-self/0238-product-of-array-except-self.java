class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] res=new int[n];
        Map<Integer,Integer>prefixMap=new HashMap<>();
        Map<Integer,Integer>suffixMap=new HashMap<>();
        int  prefix=1;
        for(int i=0;i<n;i++){
            prefixMap.put(i,prefix);
            prefix*=nums[i];
        }
        int suffix=1;
        for(int i=nums.length-1;i>=0;i--){
            suffixMap.put(i,suffix);
            suffix*=nums[i];
        }
        for(int i=0;i<n;i++){
            res[i]=prefixMap.get(i)*suffixMap.get(i);
        }
        return res;
        
        
    }
}  
