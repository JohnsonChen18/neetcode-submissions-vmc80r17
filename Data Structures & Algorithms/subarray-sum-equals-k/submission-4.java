class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        // key: 前缀和, value: 该前缀和出现的次数
        Map<Integer, Integer> sumCount = new HashMap<>();
        sumCount.put(0, 1);   // 关键:前缀和为 0 预置一次

        for (int num : nums) {
            prefixSum += num;
            // 找有没有之前的前缀和等于 prefixSum - k
            count += sumCount.getOrDefault(prefixSum - k, 0);
            // 记录当前前缀和
            sumCount.put(prefixSum, sumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}