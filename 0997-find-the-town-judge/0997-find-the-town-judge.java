class Solution {
    public int findJudge(int n, int[][] trust) {
        int len=trust.length;
        if(len<n-1){
            return -1;
        }
        int outdegree[]=new int[n+1];
        int indegree[]=new int[n+1];
        for(int i=0;i<len;i++){
            outdegree[trust[i][0]]++;
            indegree[trust[i][1]]++;
        }
        for(int i=1;i<=n;i++){
            if(outdegree[i]==0&&indegree[i]==n-1){
                return i;
            }
        }
        return -1;
        
    }
}