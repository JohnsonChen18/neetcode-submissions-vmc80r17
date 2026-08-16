class Solution {
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        // 预先分配一个长度相同的辅助数组，避免在递归中频繁创建数组
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
        return nums;
    }
    
    private void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        
        // 防止溢出的求中点方法
        int mid = left + (right - left) / 2;
        
        // 分治：递归排序左半部分和右半部分
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        
        // 合并：将两个有序区间合并为一个有序区间
        merge(nums, left, mid, right, temp);
    }
    
    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int i = left;      // 左半部分起始指针
        int j = mid + 1;   // 右半部分起始指针
        int t = 0;         // 辅助数组起始指针
        
        // 比较左右两部分的元素，将较小的放入辅助数组
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[t++] = nums[i++];
            } else {
                temp[t++] = nums[j++];
            }
        }
        
        // 如果左半部分还有剩余，直接追加到辅助数组尾部
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        
        // 如果右半部分还有剩余，直接追加到辅助数组尾部
        while (j <= right) {
            temp[t++] = nums[j++];
        }
        
        // 将排好序的辅助数组中的元素拷贝回原数组 nums 的对应位置
        for (int p = 0; p < t; p++) {
            nums[left + p] = temp[p];
        }
    }
}