class Solution {
    public int majorityElement(int[] nums) {
        int majorElement = Integer.MAX_VALUE;
        int count = 0;

        for(int num: nums){
            if(num == majorElement){
                count += 1;
            }else if(count == 0){
                majorElement = num;
                count = 1;
            }else{
                count -= 1;
            }
        }


        return majorElement;
    }
}