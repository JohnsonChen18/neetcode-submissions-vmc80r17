class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;   // 总账:所有站的油加起来够不够烧
        int tank = 0;    // 从当前起点出发,油箱现在还剩多少
        int start = 0;   // 当前尝试的起点

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];   // 这一站净赚/净亏多少油
            total += diff;
            tank += diff;
            if (tank < 0) {        // 油箱见底,开不下去了
                start = i + 1;     // 换下一站当起点
                tank = 0;          // 油箱清零,重新开始记
            }
        }

        return total >= 0 ? start : -1;   // 总油够就返回起点,不够返回 -1
    }
}
