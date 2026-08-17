

class Solution {
    private static final String[] MAP = {
        "",     "",     "abc",  "def",  "ghi",
        "jkl",  "mno",  "pqrs", "tuv",  "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;  // 空输入返回空列表
        }
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> res) {
        // 拼满了,记录结果
        if (index == digits.length()) {
            res.add(path.toString());
            return;
        }
        // 取出当前数字对应的字母表
        String letters = MAP[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));       // 选择
            backtrack(digits, index + 1, path, res);
            path.deleteCharAt(path.length() - 1); // 撤销选择(回溯)
        }
    }
}