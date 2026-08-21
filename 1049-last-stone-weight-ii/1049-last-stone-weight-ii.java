class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int w:stones)sum+=w;
        int half=sum/2;
        boolean[][] dp=new boolean[n+1][half+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            int val=stones[i-1];
            for(int j=0;j<=half;j++){
                if(dp[i-1][j]){
                    dp[i][j]=true;
                }else{
                    if(j>=val&&dp[i-1][j-val]){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }
            }
        }
        for(int j=half;j>=0;j--){
            if(dp[n][j]){
                return sum-2*j;
            }
        }
        return sum;
        
    }
}