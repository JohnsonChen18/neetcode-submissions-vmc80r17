class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int minIdx = i;
            for(int j = i; j < n; j++){
                if(nums[j] < nums[minIdx]) minIdx = j;
            }
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
        }
        return nums;
    }
}