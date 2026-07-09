class Solution {

    public int openLock(String[] deadends, String target) {

        HashSet<String> dead = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();

        if (dead.contains("0000")) {
            return -1;
        }

        visited.add("0000");
        queue.offer("0000");

        int level = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size > 0) {

                String lock_position = queue.poll();

                if (lock_position.equals(target)) {
                    return level;
                }

                for (int i = 0; i < 4; i++) {

                    char[] arr = lock_position.toCharArray();

                    // Forward move
                    char current_position = arr[i];

                    arr[i] = (current_position == '9')
                            ? '0'
                            : (char)(current_position + 1);

                    String s1 = new String(arr);

                    if (!visited.contains(s1) && !dead.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }

                    // Backward move
                    arr = lock_position.toCharArray();

                    current_position = arr[i];

                    arr[i] = (current_position == '0')
                            ? '9'
                            : (char)(current_position - 1);

                    String s2 = new String(arr);

                    if (!visited.contains(s2) && !dead.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }

                size--;
            }

            level++;
        }

        return -1;
    }
}