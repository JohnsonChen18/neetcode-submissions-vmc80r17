class Solution {
    public boolean canJump(int[] nums) {
        //init
        int curr = 0;
        int rightEdge = 0;

        while(curr <= rightEdge){
            rightEdge = Math.max(rightEdge, curr + nums[curr]);
            rightEdge = Math.min(rightEdge, nums.length-1);
            curr += 1;
        }

        return rightEdge == nums.length-1;
    }
}
