class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // need[c]：字符 c 在 t 中需要的数量；window[c]：当前窗口中 c 的数量
        int[] need = new int[128];
        int[] window = new int[128];
        int required = 0;   // t 中不同字符的种类数

        for (char c : t.toCharArray()) {
            if (need[c] == 0) {
                required++;
            }
            need[c]++;
        }

        int left = 0;
        int valid = 0;                 // 窗口中已满足数量要求的字符种类数
        int start = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);          // 即将进入窗口的字符
            window[c]++;
            if (need[c] > 0 && window[c] == need[c]) {
                valid++;
            }

            // 窗口已覆盖 t，尝试收缩左边界
            while (valid == required) {
                // 更新最短答案
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }

                char d = s.charAt(left);       // 即将移出窗口的字符
                left++;
                window[d]--;
                if (need[d] > 0 && window[d] < need[d]) {
                    valid--;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}