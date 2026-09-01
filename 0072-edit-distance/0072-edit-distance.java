class Solution {
    public int minDistance(String word1, String word2) {
        final int m=word1.length();
        final int n=word2.length();
        int[][] costdp=new int[m+1][n+1];
        for(int i=1;i<=m;++i)
        costdp[i][0]=i;
        for(int j=1;j<=n;++j)
        costdp[0][j]=j;
        for(int i=1;i<=m;++i){
            for(int j=1;j<=n;++j){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    costdp[i][j]=costdp[i-1][j-1];
                }else{
                    int topleft=costdp[i-1][j-1];
                    int top=costdp[i-1][j];
                    int left=costdp[i][j-1];
                    costdp[i][j]=Math.min(topleft,Math.min(top,left))+1;
                }

            }
        }
        return costdp[m][n];

        
    }
}
