class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        if(n<=1)return n;
        int u=1,d=1;
        int ans=1;
        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                u=d+1;
                d=1;
            }else if(arr[i]<arr[i-1]){
                d=u+1;
                u=1;
            }else{
                u=1;
                d=1;
            }
            if(u>ans)ans=u;
            if(d>ans)ans=d;
        }
        return ans;
        
    }
}