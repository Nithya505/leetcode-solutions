

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb) {
                parent[pa] = pb;
            }
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;

        if (n == 1) return true;

        for (int x : nums) {
            if (x == 1) return false;
        }

        DSU dsu = new DSU(n);
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int f = 2; f * f <= x; f++) {

                if (x % f == 0) {

                    if (map.containsKey(f)) {
                        dsu.union(i, map.get(f));
                    } else {
                        map.put(f, i);
                    }

                    while (x % f == 0) {
                        x /= f;
                    }
                }
            }

            if (x > 1) {
                if (map.containsKey(x)) {
                    dsu.union(i, map.get(x));
                } else {
                    map.put(x, i);
                }
            }
        }

        int root = dsu.find(0);

        for (int i = 1; i < n; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }

        return true;
    }
}