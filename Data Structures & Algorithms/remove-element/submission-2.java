class Solution {
    public int removeElement(int[] nums, int val) {
        // check
        if(val > 50) return nums.length;

        // init 
        int n = nums.length;
        int slow = 0;
        int fast = 0;

        while(fast < n){
            if(nums[fast] == val){
                fast += 1;
                continue;
            }else{
                nums[slow] = nums[fast];
                slow += 1;
                fast += 1;
            }
        }

        return slow;
    }
}