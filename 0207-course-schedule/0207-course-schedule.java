class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // indegree array
        int[] indegree = new int[numCourses];

        // build graph
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            graph.get(b).add(a); // b -> a
            indegree[a]++;
        }

        // queue for courses having indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        // BFS (Kahn's Algorithm)
        while (!q.isEmpty()) {

            int curr = q.poll();
            count++;

            for (int nei : graph.get(curr)) {

                indegree[nei]--;

                if (indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}