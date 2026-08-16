class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        int[] need = new int[26];
        int[] window = new int[26];
        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        for (int i = 0; i < m; i++) {
            window[s2.charAt(i) - 'a']++;        // 右端进入
            if (i >= n) {
                window[s2.charAt(i - n) - 'a']--; // 左端移出,保持窗口长度 = n
            }
            if (Arrays.equals(window, need)) {    // 用 Arrays.equals 比较内容
                return true;
            }
        }
        return false;
    }
}