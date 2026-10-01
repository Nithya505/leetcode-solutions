class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> available = new PriorityQueue<>();
        PriorityQueue<long[]> busy = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });
        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        int[] count = new int[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                available.offer((int) busy.poll()[1]);
            }
            if(!available.isEmpty()){
                int room=available.poll();
                count[room]++;
                busy.offer(new long[]{end,room});
            }else{
                long[] earliest=busy.poll();
                long finishtime=earliest[0];
                int room=(int)earliest[1];
                count[room]++;
                long duration=end-start;
                busy.offer(new long[]{finishtime+duration,room});
            }
        }
        int answer=0;
        for(int i=1;i<n;i++){
            if(count[i]>count[answer]){
                answer=i;
            }
        }
        return answer;
    }
}