class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][] extended=new int[n][3];
        for(int i=0;i<n;i++){
            extended[i][0]=tasks[i][0];
            extended[i][1]=tasks[i][1];
            extended[i][2]=i;
        }
        Arrays.sort(extended,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]!=b[1]?Integer.compare(a[1],b[1]):Integer.compare(a[2],b[2]));
        int time=0,i=0,idx=0;
        int[] result=new int[n];
        while(i<n||!pq.isEmpty()){
            while(i<n&&extended[i][0]<=time){
                pq.offer(extended[i]);
                i++;
            }
            if(!pq.isEmpty()){
                int[] curr=pq.poll();
                time+=curr[1];
                result[idx++]=curr[2];
            }else{
                time=extended[i][0];
            }
        }
        return result;

        
    }
}