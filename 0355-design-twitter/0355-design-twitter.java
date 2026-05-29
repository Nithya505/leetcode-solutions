class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweets;

    public Twitter() {
        followMap=new HashMap<>();
        tweets=new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId,new ArrayList<>());
        tweets.get(userId).add(new int[] {timestamp++,tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]>maxHeap=new PriorityQueue<>(
            (a,b)->b[0]-a[0]);
        followMap.putIfAbsent(userId,new HashSet<>());
        followMap.get(userId).add(userId);
        for(int uid:followMap.get(userId)){
            if(tweets.containsKey(uid)){
                List<int[] >twList=tweets.get(uid);
                for(int i=twList.size()-1;i>=0&&i>=twList.size()-10;i--){
                    maxHeap.offer(twList.get(i));
                }
            }
        }
        List<Integer>res=new ArrayList<>();
        while(!maxHeap.isEmpty()&&res.size()<10){
            res.add(maxHeap.poll()[1]);
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId)return ;
        followMap.putIfAbsent(followerId,new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)return ;
        if(followMap.containsKey(followerId)){
            followMap.get(followerId).remove(followeeId);
        }
    }
}
