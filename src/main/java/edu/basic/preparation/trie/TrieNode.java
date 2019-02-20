package edu.basic.preparation.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * trie node
 */
public class TrieNode {

    Map<Character, TrieNode> children;
    boolean endOfWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.endOfWord = false;
    }
}
