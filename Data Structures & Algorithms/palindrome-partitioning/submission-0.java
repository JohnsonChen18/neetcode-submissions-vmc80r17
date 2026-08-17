class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<List<String>> result) {
        // 已经切到末尾,当前 path 是一个合法方案
        if (start == s.length()) {
            result.add(new ArrayList<>(path));   // 拷贝一份加入结果
            return;
        }

        // 枚举从 start 开始的每一个可能的结束位置
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));   // 选择这段回文
                backtrack(s, end + 1, path, result);      // 递归处理剩余部分
                path.remove(path.size() - 1);             // 回溯,撤销选择
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}