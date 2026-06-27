class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root = new TrieNode();

    public int minExtraChar(String s, String[] dictionary) {

        // build trie
        for (String word : dictionary) {
            insert(word);
        }

        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s, dp);
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }

            node = node.children[idx];
        }

        node.isEnd = true;
    }

    private int solve(int i, String s, int[] dp) {

        int n = s.length();

        // base case
        if (i == n)
            return 0;

        // memoization
        if (dp[i] != -1)
            return dp[i];

        // option 1 -> current char is extra
        int ans = 1 + solve(i + 1, s, dp);

        TrieNode node = root;

        // option 2 -> traverse trie
        for (int j = i; j < n; j++) {

            int idx = s.charAt(j) - 'a';

            // no further word possible
            if (node.children[idx] == null)
                break;

            node = node.children[idx];

            // found a word
            if (node.isEnd) {
                ans = Math.min(ans, solve(j + 1, s, dp));
            }
        }

        return dp[i] = ans;
    }
}