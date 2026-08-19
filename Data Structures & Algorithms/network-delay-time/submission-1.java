class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i = 0; i < n; i++){
            for(int[] edge: times){
                int start = edge[0];
                int end = edge[1];
                int edgeCost = edge[2];
                if(dist[start] == Integer.MAX_VALUE) continue;
                if(dist[start] + edgeCost >= dist[end]) continue;
                dist[end] = dist[start] + edgeCost;
            }
        }
        
        int res = 0;
        for(int i = 1; i <dist.length; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;
    }
}
