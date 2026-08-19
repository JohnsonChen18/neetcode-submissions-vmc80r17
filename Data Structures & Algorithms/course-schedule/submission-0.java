class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<Integer>[] adjList = new List[numCourses];
        for(int i = 0; i < adjList.length; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge: prerequisites){
            int start = edge[1];
            int end = edge[0];
            inDegrees[edge[0]] += 1;
            adjList[start].add(end);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegrees[i] == 0) q.offer(i);
        }

        while(q.size() > 0){
            int currNode = q.poll();
            for(int next: adjList[currNode]){
                inDegrees[next] -= 1;
                if(inDegrees[next] == 0) q.offer(next);
            }
        }

        for(int num: inDegrees){
            if(num != 0) return false;
        }

        return true;
    }
}
