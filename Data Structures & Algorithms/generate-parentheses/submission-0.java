class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb,
                           int left, int right, int n) {
        // 终止条件：用满 n 对括号
        if (sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }

        // 选择1：还能放左括号
        if (left < n) {
            sb.append('(');
            backtrack(result, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1); // 撤销选择（回溯）
        }

        // 选择2：右括号数量小于左括号时才能放
        if (right < left) {
            sb.append(')');
            backtrack(result, sb, left, right + 1, n);
            sb.deleteCharAt(sb.length() - 1); // 撤销选择（回溯）
        }
    }
}