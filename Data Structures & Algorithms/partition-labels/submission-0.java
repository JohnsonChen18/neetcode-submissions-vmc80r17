class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;   // 记录每个字母最后出现的位置
        }

        List<Integer> res = new ArrayList<>();
        int start = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, last[s.charAt(i) - 'a']);  // 拓展右边界
            if (i == right) {              // 追平边界 → 一段结束
                res.add(i - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
