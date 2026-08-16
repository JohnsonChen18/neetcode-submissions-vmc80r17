public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = Arrays.copyOfRange(nums, n - k % n, n);
        System.arraycopy(nums, 0, nums, k % n, n - k % n);
        System.arraycopy(rotated, 0, nums, 0, rotated.length);
    }
}