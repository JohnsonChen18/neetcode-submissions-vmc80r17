class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Tree with n nodes must have exactly n - 1 edges
        if (edges.length != n - 1) return false;

        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];

        // Start DFS from node 0
        dfs(0, graph, visited);

        // Check whether every node was visited
        for (boolean nodeVisited : visited) {
            if (!nodeVisited) return false;
        }

        return true;
    }

    private void dfs(
        int node,
        List<List<Integer>> graph,
        boolean[] visited
    ) {
        visited[node] = true;

        for (int next : graph.get(node)) {
            if (visited[next]) continue;

            dfs(next, graph, visited);
        }
    }
}