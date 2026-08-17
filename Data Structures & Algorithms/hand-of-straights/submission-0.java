class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(count.keySet());
        
        while (!minHeap.isEmpty()) {
            int start = minHeap.peek();          // 当前最小的牌
            for (int num = start; num < start + groupSize; num++) {
                if (count.getOrDefault(num, 0) == 0) {
                    return false;                // 缺牌,凑不齐
                }
                count.put(num, count.get(num) - 1);
                if (count.get(num) == 0) {
                    if (num != minHeap.peek()) { // 关键判断
                        return false;
                    }
                    minHeap.poll();
                }
            }
        }
        return true;
    }
}