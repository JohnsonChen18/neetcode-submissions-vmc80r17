class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }

            digits[i] = 0;
        }

        // 能走到这里说明原数组全是9，比如 999
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }
}