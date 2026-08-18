class Node{
    boolean ifEnd;
    Node[] next;

    public Node(){
        next = new Node[26];
    }
}

class PrefixTree {
    private Node dummyRoot;

    public PrefixTree() {
        dummyRoot = new Node();
    }

    public void insert(String word) {
        Node curr = dummyRoot;
        for(char c: word.toCharArray()){
            if(curr.next[c-'a'] == null) curr.next[c-'a'] = new Node();
            curr = curr.next[c-'a'];
        }
        curr.ifEnd = true;
    }

    public boolean search(String word) {
        Node node = move(word);
        if(node == null) return false;
        return node.ifEnd;
    }

    public boolean startsWith(String prefix) {
        Node node = move(prefix);
        if(node == null) return false;
        return true;
    }

    private Node move(String s){
        Node curr = dummyRoot;
        for(char c: s.toCharArray()){
            int pos = c - 'a';
            if(curr.next[pos] == null) return null;
            curr = curr.next[pos];
        }
        return curr;
    }
}
