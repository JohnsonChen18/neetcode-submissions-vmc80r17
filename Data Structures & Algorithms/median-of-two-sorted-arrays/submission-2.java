class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 保证在较短数组上二分
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;      // 左半应有的元素个数

        int left = 0, right = m;         // 在 nums1 上二分「切几个」i
        while (left <= right) {
            int i = left + (right - left) / 2;   // nums1 左边取 i 个
            int j = half - i;                    // nums2 左边取 j 个

            // 四个边界值，越界用 ±∞ 兜底
            int L1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int R1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int L2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int R2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (L1 <= R2 && L2 <= R1) {          // 合法切割
                if (total % 2 == 1) {
                    return Math.max(L1, L2);
                } else {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                }
            } else if (L1 > R2) {                // nums1 左边切多了
                right = i - 1;
            } else {                             // L2 > R1，nums1 左边切少了
                left = i + 1;
            }
        }
        return 0.0;   // 不会到达
    }
}