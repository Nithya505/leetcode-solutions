class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n=queries.length;
        int[] result=new int[n];
        Integer[] queryindices=new Integer[n];
        for(int i=0;i<n;i++){
            queryindices[i]=i;
        }
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        Arrays.sort(queryindices,(a,b)->Integer.compare(queries[a],queries[b]));
        PriorityQueue<int[]>minheap=new PriorityQueue<>((a,b)->Integer.compare(a[1]-a[0],b[1]-b[0]));
        int intervalindex=0;
        for(int i=0;i<n;i++){
            int query=queries[queryindices[i]];
            while(intervalindex<intervals.length&&intervals[intervalindex][0]<=query){
                int left=intervals[intervalindex][0];
                int right=intervals[intervalindex][1];
                if(right>=query){
                    minheap.offer(new int[] {left,right});
                }
                intervalindex++;
            }
            while(!minheap.isEmpty()&&minheap.peek()[1]<query){
                minheap.poll();
            }
            if(minheap.isEmpty()){
                result[queryindices[i]]=-1;

            }else{
                int[] smallestinterval=minheap.peek();
                result[queryindices[i]]=smallestinterval[1]-smallestinterval[0]+1;
            }
        }
        return result;
        
    }
}

