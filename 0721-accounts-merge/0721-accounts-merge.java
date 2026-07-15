class Solution {

    public void dfs(String srcEmail,
                    HashSet<String> visited,
                    HashMap<String, List<String>> adjmap,
                    List<String> sublist) {

        visited.add(srcEmail);

        sublist.add(srcEmail);

        if (!adjmap.containsKey(srcEmail)) {
            return;
        }

        for (String neighbour : adjmap.get(srcEmail)) {

            if (!visited.contains(neighbour)) {

                dfs(neighbour, visited, adjmap, sublist);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        HashMap<String, List<String>> adjmap = new HashMap<>();

        // Build graph
        for (List<String> account : accounts) {

            String firstemail = account.get(1);

            adjmap.putIfAbsent(firstemail, new ArrayList<>());

            for (int i = 2; i < account.size(); i++) {

                String email = account.get(i);

                adjmap.putIfAbsent(email, new ArrayList<>());

                // Bidirectional connection
                adjmap.get(firstemail).add(email);
                adjmap.get(email).add(firstemail);
            }
        }

        List<List<String>> res = new ArrayList<>();

        HashSet<String> visited = new HashSet<>();

        // DFS on each component
        for (List<String> account : accounts) {

            String firstemail = account.get(1);

            if (!visited.contains(firstemail)) {

                List<String> sublist = new ArrayList<>();

                dfs(firstemail, visited, adjmap, sublist);

                Collections.sort(sublist);

                sublist.add(0, account.get(0));

                res.add(sublist);
            }
        }

        return res;
    }
}