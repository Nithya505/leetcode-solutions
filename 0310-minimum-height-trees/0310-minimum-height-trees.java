class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1){
            List<Integer>res=new ArrayList<>();
            res.add(0);
            return res;
        }
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        int[] degree=new int[n];
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            adj[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        ArrayDeque<Integer>leaves=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(degree[i]==1)leaves.add(i);
        }
        int remaining=n;
        while(remaining>2){
            int leavescount=leaves.size();
            remaining-=leavescount;
            for(int i=0;i<leavescount;i++){
                int leaf=leaves.remove();
                for(int nei:adj[leaf]){
                    degree[nei]--;
                    if(degree[nei]==1){
                        leaves.add(nei);
                    }
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!leaves.isEmpty())ans.add(leaves.remove());
        return ans;
        
    }
}