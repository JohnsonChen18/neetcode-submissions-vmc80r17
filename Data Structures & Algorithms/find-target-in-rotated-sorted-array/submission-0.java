class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {          // 左半 [left, mid] 有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;                // target 在左半有序区
                } else {
                    left = mid + 1;                 // 否则去右半
                }
            } else {                                // 右半 [mid, right] 有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;                 // target 在右半有序区
                } else {
                    right = mid - 1;                // 否则去左半
                }
            }
        }
        return -1;
    }
}