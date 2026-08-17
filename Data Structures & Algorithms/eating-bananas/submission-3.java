class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // 二分的范围是 k 的取值:[1, max(piles)]
        int left = 1;
        int right = 0;
        for (int p : piles) {
            right = Math.max(right, p);   // right = 最大的那堆
        }

        // 在 [left, right] 上二分找"最小可行的 k"
        while (left < right) {            // 注意:这里用 < ,收敛到唯一答案
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                // mid 可行,但也许还能更小 —— 保留 mid,往左找
                right = mid;
            } else {
                // mid 太慢吃不完 —— 答案一定比 mid 大
                left = mid + 1;
            }
        }

        return left;   // left == right,停在第一个可行的 k
    }

    // 判断:以速度 k,能否在 h 小时内吃完所有香蕉
    private boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int p : piles) {
            // ceil(p / k) 的整数写法:向上取整
            hours += (p + k - 1) / k;
            if (hours > h) return false;  // 提前剪枝,超了就不用继续
        }
        return hours <= h;
    }
}
