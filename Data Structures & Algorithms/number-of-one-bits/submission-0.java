class Solution {
    public int hammingWeight(int n) {
        int res = 0;
        int base = 1;

        while(base != 0){
            if((base & n) != 0) res += 1;
            base = base << 1;
        }

        return res;
    }
}
