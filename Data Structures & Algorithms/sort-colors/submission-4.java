class Solution {
    public void sortColors(int[] nums) {
        // init
        int n = nums.length;
        int left = 0;
        int right = n-1;
        
        // main
        int i = 0;
        while(i <= right){
            if(nums[i] == 0){
                swap(nums, left, i);
                left += 1;
                i++;
            }else if(nums[i] == 2){
                swap(nums, right, i);
                right -= 1;
            }else{
                i++;
            }
        }
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}