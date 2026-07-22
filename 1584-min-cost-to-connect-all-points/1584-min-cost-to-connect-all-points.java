class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        PriorityQueue<Point>pq=new PriorityQueue<>((a,b)->a.distance-b.distance);
        boolean[] inmst=new boolean[n];
        pq.offer(new Point(0,0));
        int mincost=0;
        int pointsconnected=0;
        while(pointsconnected<n){
            Point current=pq.poll();
            if(inmst[current.index]){
            continue;
            }
            inmst[current.index]=true;
            mincost+=current.distance;
            pointsconnected++;
            for(int i=0;i<n;i++){
                if(!inmst[i]){
                    int distance=Math.abs(points[current.index][0]-points[i][0])+Math.abs(points[current.index][1]-points[i][1]);
                        pq.offer(new Point(i,distance));
                }
                }
            }
            return mincost;
        }
        static class Point{
            int index;
            int distance;
            Point(int index,int distance){
                this.index=index;
                this.distance=distance;
            }
        }
    

}
