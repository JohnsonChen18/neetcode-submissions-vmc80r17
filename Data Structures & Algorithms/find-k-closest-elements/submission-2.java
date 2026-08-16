class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // 搜索空间:窗口起点的范围。窗口长度固定为 k,
        // 所以起点最远只能到 arr.length - k(再往右装不下 k 个)。
        int windowStartLow = 0;
        int windowStartHigh = arr.length - k;

        while (windowStartLow < windowStartHigh) {
            int candidateStart = (windowStartLow + windowStartHigh) / 2;

            // 窗口 = [candidateStart .. candidateStart + k - 1]
            // 若把窗口右移一格,会「丢掉左边界外的这个」、「捡起右边界外的这个」:
            int elementToDrop = arr[candidateStart];          // 右移时失去的左端元素
            int elementToGain = arr[candidateStart + k];      // 右移时得到的右端元素

            int distIfWeDrop = x - elementToDrop;             // 左端离 x 的距离
            int distIfWeGain = elementToGain - x;             // 右端离 x 的距离

            if (distIfWeDrop > distIfWeGain) {
                // 左端更远 → 右移窗口更划算,起点往右挪
                windowStartLow = candidateStart + 1;
            } else {
                // 右端更远,或距离相等(相等时保留较小的左端)→ 不右移
                windowStartHigh = candidateStart;
            }
        }

        // 循环结束时 windowStartLow == windowStartHigh,即最优起点
        int bestStart = windowStartLow;
        List<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}