class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] selected = new boolean[3];

        for(int[] triplet: triplets){
            if(triplet[0] < target[0] && triplet[1] < target[1] && triplet[2] < target[2]) continue;
            if(triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) continue;
            
            if(triplet[0] == target[0]) selected[0] = true;
            if(triplet[1] == target[1]) selected[1] = true;
            if(triplet[2] == target[2]) selected[2] = true;
        }

        for(boolean b: selected){
            if(b == false) return false;
        }
        return true;
    }
}
