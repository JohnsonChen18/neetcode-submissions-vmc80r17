/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Codec {

    // 序列化：把树编码成一个字符串
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // 前序遍历(根 -> 左 -> 右),用 "#" 表示空节点,"," 分隔每个值
    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");   // 遇到空节点,写入占位符,保证结构信息不丢失
            return;
        }
        sb.append(node.val).append(",");  // 先写当前节点的值
        serializeHelper(node.left, sb);   // 再递归左子树
        serializeHelper(node.right, sb);  // 最后递归右子树
    }

    // 反序列化:把字符串还原成树
    public TreeNode deserialize(String data) {
        // 按逗号切分成数组,放进队列方便按顺序逐个取用
        Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    // 按照序列化时相同的前序顺序重建这棵树
    private TreeNode deserializeHelper(Queue<String> nodes) {
        String val = nodes.poll();        // 取出当前要处理的值
        if (val.equals("#")) {            // 是占位符说明这里是空节点
            return null;
        }
        // 创建当前节点,顺序与序列化保持一致:先左后右
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(nodes);
        node.right = deserializeHelper(nodes);
        return node;
    }
}