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

    private void union(int[] parent, int[] rank, int a, int b){
        int aParent = find(parent, a);
        int bParent = find(parent, b);
        if(aParent == bParent) return;

        if(rank[aParent] <= rank[bParent]){
            parent[aParent] = bParent;
            rank[bParent] += 1;
        }else{
            parent[bParent] = aParent;
            rank[aParent] += 1;
        }

    }
}
