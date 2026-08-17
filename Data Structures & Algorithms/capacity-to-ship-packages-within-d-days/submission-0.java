class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // init
        int left = 0;
        int right = 0;
        for(int weight: weights){
            left = Math.max(left, weight);
            right += weight;
        }

        //main
        while(left <= right){
            int mid = left + (right-left)/2;

            if(check(weights, days, mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        return left;
    }


    private boolean check(int[] weights, int days, int cap){
        // init
        int res = 0;
        int currCap = cap;

        // main
        for(int weight: weights){
            if(currCap - weight >= 0){
                currCap -= weight;
                continue;
            }else{
                res += 1;
                currCap = cap;
                currCap -= weight;
            }
        }
        if (currCap < cap) res += 1;

        return res <= days;
    }
}