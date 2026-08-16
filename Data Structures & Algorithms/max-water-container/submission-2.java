class Solution {
    public int maxArea(int[] nums) {
        int n = nums.length;
        int left =0;
        int right = n-1;
        int res = 0;

        while(left < right){
            int currArea = Math.min(nums[left], nums[right]) * (right - left);
            res= Math.max(res, currArea);

            if(nums[left] <= nums[right]){
                int currNum = nums[left];
                while(left < right && nums[left] <= currNum) left++;
            }else{
                int currNum = nums[right];
                while(left < right && nums[right] <= currNum) right--;
            }
        }
        return res;
    }
}
