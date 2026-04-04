class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int currSum = nums[i] + nums[left] + nums[right];
                if (currSum == 0){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int currLeft = nums[left];
                    int currRight = nums[right];
                    while (left < right && nums[left] == currLeft) left ++;
                    while (left < right && nums[right] == currRight) right--;
                }else if(currSum < 0){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }
}
