class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int current=0;
        for(int[] trip:trips){
            int p=trip[0];
            int from=trip[1];
            int to=trip[2];
            while(!pq.isEmpty()&&pq.peek()[0]<=from){
                current-=pq.poll()[1];
            }
            current+=p;
            if(current>capacity)return false;
            pq.offer(new int[]{to,p});
        }
        return true;
        
    }
}