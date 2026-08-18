class Solution {
    public int reverse(int x) {
        int res = 0;
        int upperBoundLastDigit = Integer.MAX_VALUE % 10;
        int lowerBoundLastDigit = Integer.MIN_VALUE % 10;

        while (x != 0) {
            int digit = x % 10; // 拿最后一位
            x /= 10;            // 去掉最后一位

            // 检查正溢出
            if (res > Integer.MAX_VALUE / 10 ||
                (res == Integer.MAX_VALUE / 10 && digit > upperBoundLastDigit)) {
                return 0;
            }

            // 检查负溢出
            if (res < Integer.MIN_VALUE / 10 ||
                (res == Integer.MIN_VALUE / 10 && digit < lowerBoundLastDigit)) {
                return 0;
            }

            res = res * 10 + digit;
        }

        return res;
    }
}