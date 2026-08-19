class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int INF = 1_000_000_000;

        // dist[i][j] = shortest distance from i to j
        int[][] dist = new int[n + 1][n + 1];

        // init
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // build graph
        for (int[] edge : times) {
            int start = edge[0];
            int end = edge[1];
            int cost = edge[2];

            dist[start][end] = Math.min(dist[start][end], cost);
        }

        // Floyd-Warshall
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {

                    if (dist[start][mid] == INF ||
                        dist[mid][end] == INF) {
                        continue;
                    }

                    dist[start][end] = Math.min(
                        dist[start][end],
                        dist[start][mid] + dist[mid][end]
                    );
                }
            }
        }

        // only care about distances from k
        int res = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[k][i] == INF) {
                return -1;
            }

            res = Math.max(res, dist[k][i]);
        }

        return res;
    }
}