class Solution {
    public int jump(int[] nums) {
        // init
        int currEnd = 0;
        int globalEnd = 0;
        int res = 0;

        // main
        for(int i = 0; i < nums.length; i++){
            globalEnd = Math.max(globalEnd, i + nums[i]);
            if(i == currEnd && currEnd != nums.length-1){
                res += 1;
                currEnd = globalEnd;
            }
        }

        return res;
    }
}
