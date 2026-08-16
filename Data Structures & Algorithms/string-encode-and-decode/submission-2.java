class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // 1. 找到分隔符 '#' 的位置
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            // 2. 解析出长度
            int len = Integer.parseInt(str.substring(i, j));
            // 3. 从 '#' 后面取 len 个字符
            String s = str.substring(j + 1, j + 1 + len);
            res.add(s);
            // 4. 移动指针到下一段的开头
            i = j + 1 + len;
        }
        return res;
    }
}