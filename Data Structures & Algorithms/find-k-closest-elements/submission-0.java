class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - 1;
        // 收缩窗口，直到只剩 k 个元素
        while (hi - lo >= k) {
            if (x - arr[lo] > arr[hi] - x) {
                lo++;      // 左端更远，去掉左端
            } else {
                hi--;      // 右端更远或平局，去掉右端（保留较小的左端）
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = lo; i <= hi; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}