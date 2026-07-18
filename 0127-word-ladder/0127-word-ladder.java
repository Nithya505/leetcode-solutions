class Solution {
    public List<String> getneighbours(String word, HashSet<String> set) {
        List<String> neighbours = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == word.charAt(i)) {
                    continue;
                }
                String newword = word.substring(0, i) + ch + word.substring(i + 1, word.length());
                if (set.contains(newword)) {
                    neighbours.add(newword);
                }
            }
        }
        return neighbours;
    }

    public int ladderLength(String beginword, String endword, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endword)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginword);
        if (set.contains(beginword)) {
            set.remove(beginword);
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int currlevelsize = queue.size();
            for (int i = 0; i < currlevelsize; i++) {
                String node = queue.poll();
                if (node.equals(endword)) {
                    return level + 1;
                }
                List<String> neighbours = getneighbours(node,set);
                for (String word : neighbours) {
                    if (set.contains(word)) {
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
                level++;
            
        }
        return 0;
    }
}
