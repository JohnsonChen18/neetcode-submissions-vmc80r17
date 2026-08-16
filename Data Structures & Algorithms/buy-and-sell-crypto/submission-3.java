class Solution {
    public int maxProfit(int[] prices) {
        //init
        int minPrice = 101;
        int res = 0;

        // main
        for(int price: prices){
            res = Math.max(res, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return res;
    }
}
