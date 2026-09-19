class Solution {
    public boolean canReach(String s, int minjump, int maxjump) {
        int n=s.length();
        boolean[] dp=new boolean[n];
        char[] ch=s.toCharArray();
        dp[0]=ch[0]=='0';
        int reachable=0;
        for(int i=1;i<n;i++){
            if(i>=minjump){
                reachable+=dp[i-minjump]?1:0;

            }
            if(i>maxjump){
                reachable-=dp[i-maxjump-1]?1:0;
            }
            dp[i]=reachable>0&&ch[i]=='0';
        }
        return dp[n-1];
        
    }
}