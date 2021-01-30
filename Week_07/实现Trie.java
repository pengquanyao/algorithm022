//leetcode 208
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] cs = word.toCharArray();
        int n = cs.length;
        TrieNode node = this.root;
        for(int i = 0; i < n; i++) {
            if(!node.contains(cs[i])) {
                node.put(cs[i], new TrieNode());
            }
            node = node.get(cs[i]);
        }
        node.setEnd();
    }

    private TrieNode searchPrefix(String word) {
        char[] cs = word.toCharArray();
        TrieNode node = this.root;
        for(char c:cs) {
            if(node == null) return node;
            node = node.get(c);
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

class TrieNode {
    private TrieNode[] links;
    private int R = 26;
    private boolean isEnd;

    public TrieNode() {
        this.links = new TrieNode[R];
    }

    public boolean contains(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }


    public void setEnd() {
        this.isEnd = true;
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
