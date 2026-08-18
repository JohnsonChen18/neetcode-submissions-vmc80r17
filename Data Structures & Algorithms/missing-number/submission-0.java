class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int curr = 0;

        for(int i = 1; i <= n; i++){
            curr = curr ^ i;
        }
        for(int num: nums){
            curr = curr ^ num;
        }

        return curr;
    }
}
