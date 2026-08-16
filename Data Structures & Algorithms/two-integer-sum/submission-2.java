class Solution {
    public int[] twoSum(int[] nums, int target) {
        // init
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[]{-1,-1};

        for(int i = 0; i < nums.length; i++){
            int currNum = nums[i];

            //check if map has (target-currNum)
            if(map.containsKey(target - currNum)){
                res[0] = i;
                res[1] = map.get(target-currNum);
                break;
            }
            map.put(currNum, i);
        }
        if(res[0] > res[1]){
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }

        return res;
    }
}
