class Solution {
    public int[] getConcatenation(int[] nums) {
        //init 
        int n = nums.length;
        int[] res = new int[n*2];
        
        // main
        for(int i = 0; i < n; i++){
            res[i] = nums[i];
            res[i+n] = nums[i];
        }

        return res;
    }
}