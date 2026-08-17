public class Solution {
    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            map.put(interval[0], map.getOrDefault(interval[0], 0) + 1);
            map.put(interval[1], map.getOrDefault(interval[1], 0) - 1);
        }

        List<int[]> res = new ArrayList<>();
        int have = 0;
        int[] interval = new int[2];

        for (int point : map.keySet()) {
            if (have == 0) interval[0] = point;
            have += map.get(point);
            if (have == 0) {
                interval[1] = point;
                res.add(new int[] {interval[0], interval[1]});
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}