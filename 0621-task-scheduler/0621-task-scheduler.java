class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char t:tasks){
            freq[t-'A']++;
        }
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq){
            if(f>0)maxHeap.offer(f);
        }
        int time=0;
        while(!maxHeap.isEmpty()){
            List<Integer>temp=new ArrayList<>();
            int cycle=n+1;
        
     
        while(cycle>0&&!maxHeap.isEmpty()){
            int curr=maxHeap.poll();
            if(curr>1)temp.add(curr-1);
            time++;
            cycle--;
        }
        for(int t:temp){
            maxHeap.offer(t);
        }
        if(maxHeap.isEmpty())break;
        time+=cycle;
    }
        
    
    return time;
}
}

