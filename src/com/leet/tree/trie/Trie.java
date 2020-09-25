package com.leet.tree.trie;

/**
 * 208. 实现 Trie (前缀树)
 */
public class Trie {

    private Trie[] next;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        char[] wChars = word.toCharArray();
        for (int i = 0; i < wChars.length; i++) {
            if(root.next[wChars[i] - 'a'] == null) {
                root.next[wChars[i] - 'a'] = new Trie();
            }
            root = root.next[wChars[i] - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = searchTrie(word);
        return trie != null && trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = searchTrie(prefix);
        return trie != null;
    }

    private Trie searchTrie(String word) {
        Trie root = this;
        char[] wChars = word.toCharArray();
        for (int i = 0; i < wChars.length; i++) {
            if(root.next[wChars[i] - 'a'] == null) {
                return null;
            }
            root = root.next[wChars[i] - 'a'];
        }
        return root;
    }
}
