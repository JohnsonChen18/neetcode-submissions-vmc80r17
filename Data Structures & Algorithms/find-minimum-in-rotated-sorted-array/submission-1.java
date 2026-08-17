class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int last = nums[n - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= last) {   // mid 落在右段（含断崖底）→ 往左找边界
                right = mid - 1;
            } else {                   // mid 在左段 → 往右
                left = mid + 1;
            }
        }
        return nums[left];   // left = 右段的第一个元素 = 最小值。无 +1
    }
}