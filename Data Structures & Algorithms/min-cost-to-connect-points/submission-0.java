class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int cost = Math.abs(points[i][0] - points[j][0])
                         + Math.abs(points[i][1] - points[j][1]);

                graph[i].add(new int[]{j, cost});
                graph[j].add(new int[]{i, cost});
            }
        }
        boolean[] visited = new boolean[n];

        // {node, cost}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});

        int res = 0;

        while(pq.isEmpty() == false){
            int[] curr = pq.poll();
            int cost = curr[1];
            int node = curr[0];

            if(visited[node]) continue;
            visited[node] = true;

            res += cost;

            for(int[] edge: graph[node]){
                int next = edge[0];
                int nextCost = edge[1];

                if(visited[next]) continue;
                pq.offer(new int[]{next, nextCost});
            }
        }
        return res;
    }
}
