/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        return cloneHelper(node, map);
    }

    private Node cloneHelper(Node node, Map<Node, Node> map){
        // if already cloned
        if(map.containsKey(node)) return map.get(node);

        // create clone
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        // clone all neighbors
        for(Node next: node.neighbors){
            Node clonedNext = cloneHelper(next, map);
            newNode.neighbors.add(clonedNext);
        }

        return newNode;
    }
}