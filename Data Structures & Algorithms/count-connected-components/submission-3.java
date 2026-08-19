class Solution {
    public int countComponents(int n, int[][] edges) {
        // init
        int[] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        int[] rank = new int[n];

        for(int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            union(parent, rank, a, b);
        }

        for(int i = 0; i < n; i++){
            find(parent, i);
        }

        Set<Integer> set = new HashSet<>();
        for(int num: parent){
            set.add(num);
        }
        return set.size();
    }


    private int find(int[] parent, int a){
        if(parent[a] == a) return a;
        int updatedParent = find(parent, parent[a]);
        parent[a] = updatedParent;
        return parent[a];
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        int rootA = find(parent, a);
        int rootB = find(parent, b);

        if (rootA == rootB) return;

        if (rank[rootA] < rank[rootB]) {
            parent[rootA] = rootB;

        } else if (rank[rootA] > rank[rootB]) {
            parent[rootB] = rootA;

        } else {
            parent[rootB] = rootA;
            rank[rootA]++;
        }
    }
}
