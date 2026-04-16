import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int[] res = new int[queries.length];

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i];
            int val = nums[idx];

            List<Integer> list = map.get(val);

            // Only one occurrence
            if (list.size() == 1) {
                res[i] = -1;
                continue;
            }

            // Binary search
            int pos = Collections.binarySearch(list, idx);

            int left = list.get((pos - 1 + list.size()) % list.size());
            int right = list.get((pos + 1) % list.size());

            int d1 = Math.abs(idx - left);
            int d2 = Math.abs(idx - right);

            int dist1 = Math.min(d1, n - d1);
            int dist2 = Math.min(d2, n - d2);

            res[i] = Math.min(dist1, dist2);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : res) {
            ans.add(x);
        }
        return ans;
    }
}