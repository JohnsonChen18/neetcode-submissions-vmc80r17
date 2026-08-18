class WordDictionary {

    // Trie 的节点
    private static class TrieNode {
        // children[i] 表示字符 ('a' + i) 对应的下一个节点
        TrieNode[] children = new TrieNode[26];

        // 标记当前节点是否是一个完整单词的结尾
        boolean isEnd;
    }

    // Trie 根节点
    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // 添加一个单词到 Trie
    public void addWord(String word) {
        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            int index = c - 'a';

            // 如果这个字符对应的节点不存在，就创建
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }

            // 往下一层走
            cur = cur.children[index];
        }

        // 单词插入完毕，标记最后一个节点
        cur.isEnd = true;
    }

    public boolean search(String word) {

        // queue 中保存：
        // “匹配到当前字符之前，所有仍然可能匹配成功的 TrieNode”
        Queue<TrieNode> queue = new LinkedList<>();

        // 一开始还没有匹配任何字符，所以从 root 开始
        queue.offer(root);

        // 逐个处理 pattern 中的字符
        for (char c : word.toCharArray()) {

            /*
             * 这里一定要先记录当前 queue 的 size。
             *
             * 因为当前字符只能处理“当前这一层”的节点。
             * 我们在处理过程中加入 queue 的新节点，
             * 是给下一个字符处理的，不能这一轮继续处理。
             */
            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TrieNode node = queue.poll();

                // 情况 1：当前字符是 '.'
                if (c == '.') {

                    /*
                     * '.' 可以匹配任意字符，
                     * 所以当前 node 的所有非空 child
                     * 都有可能成为下一步状态。
                     */
                    for (TrieNode child : node.children) {
                        if (child != null) {
                            queue.offer(child);
                        }
                    }

                } else {

                    // 情况 2：普通字符
                    int index = c - 'a';

                    TrieNode next = node.children[index];

                    /*
                     * 普通字符只能走指定的那一条边。
                     * 如果这条边存在，就加入 queue，
                     * 给下一个字符继续处理。
                     */
                    if (next != null) {
                        queue.offer(next);
                    }
                }
            }

            /*
             * 当前字符处理完之后，如果 queue 已经空了，
             * 说明不存在任何可能继续匹配的路径。
             */
            if (queue.isEmpty()) {
                return false;
            }
        }

        /*
         * pattern 所有字符都处理完之后，
         * queue 中可能还有多个候选节点。
         *
         * 只要其中一个节点是完整单词结尾，
         * 就说明 search 成功。
         */
        while (!queue.isEmpty()) {
            TrieNode node = queue.poll();

            if (node.isEnd) {
                return true;
            }
        }

        return false;
    }
}