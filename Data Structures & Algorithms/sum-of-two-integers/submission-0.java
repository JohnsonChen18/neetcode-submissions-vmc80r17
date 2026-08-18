class Solution {
    public int getSum(int a, int b) {
        // init 
        int carry = 0;
        int res = 0;

        res = a ^ b; // add withouth carry
        carry = (a & b) << 1;

        while(carry != 0){
            int oldRes = res;
            res = oldRes ^ carry; // add previous carry without new carry
            carry = (oldRes & carry) << 1; // update to new carry
        }

        return res;
    }
}
