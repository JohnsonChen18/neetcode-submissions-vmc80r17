class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //init
        List<List<int[]>> adjList = buildAdjList(times, n);
        int[] dist = new int[n+1];
        for(int i = 0; i < dist.length; i++){
            dist[i] = Integer.MAX_VALUE;
            if(i == k) dist[i] = 0;
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        minHeap.offer(new int[]{k,0});

        while(minHeap.isEmpty() == false){
            int[] curr = minHeap.poll();
            int currNode = curr[0];
            int currCost = curr[1];
            
            for(int[] edge: adjList.get(currNode)){
                int nextNode = edge[0];
                int edgeCost = edge[1];

                // skip if cant update
                if(currCost + edgeCost >= dist[nextNode]) continue;

                dist[nextNode] = currCost + edgeCost;
                minHeap.offer(new int[]{nextNode, dist[nextNode]});
            }
            
        }
        
        int res = 0;
        for(int i = 1; i <= n; i++){
            int num = dist[i];
            if(num == Integer.MAX_VALUE) return -1;
            res = Math.max(res, num);
        }
        return res;
    }

    private List<List<int[]>> buildAdjList(int[][] times, int n) {
        List<List<int[]>> adjList = new ArrayList<>();

        // nodes are labeled from 1 to n
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];

            // int[]{neighbor, weight}
            adjList.get(from).add(new int[]{to, weight});
        }

        return adjList;
    }
}
