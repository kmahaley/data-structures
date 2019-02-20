package edu.basic.preparation.trie;

import java.util.Map;

/**
 * Trie structure is good for searching string. dictionary.
 * prefix based search or complete word search
 */
public class TrieStructure {

    TrieNode root;

    public TrieStructure() {
        this.root = new TrieNode();
    }

    /**
     * Insert string
     *
     * @param str
     */
    public void insert(String str) {

        TrieNode curr = root;
        for (int i = 0; i < str.length() ; i++) {

            final char charAt = str.charAt(i);
            TrieNode newNode = curr.children.get(charAt);

            if(newNode == null) {
                newNode = new TrieNode();
                curr.children.put(charAt, newNode);
            }

            curr = newNode;
        }
        curr.endOfWord = true;
    }

    /**
     * Search complete string
     *
     * @param input string
     * @return boolean
     */
    public boolean searchCompleteWord(String input) {

        TrieNode curr = root;
        for (int i = 0; i < input.length() ; i++) {
            final char charAt = input.charAt(i);

            final TrieNode node = curr.children.get(charAt);
            if(node == null) {
                return false;
            }
            curr = node;
        }
        return curr.endOfWord;
    }

    /**
     * Delete string from trie
     */
    public void delete(String str) {

        deleteHelper(0, str, root);
    }

    /**
     * delete word helper
     * @param index index
     * @param word word to delete
     * @param curr current trie node
     * @return if node is deleted
     */
    private boolean deleteHelper(int index, String word, TrieNode curr) {

        if (index == word.length()) {
//          word exists or not
            if (!curr.endOfWord) {
                return false;
            }
//          word exist in Trie set node value to false to remove the word
            curr.endOfWord = false;
//          If children exist in current node or not
            return curr.children.size() == 0;
        }

        final char charAt = word.charAt(index);
        final Map<Character, TrieNode> mapOfCharacters = curr.children;
        final TrieNode node = mapOfCharacters.get(charAt);

        if (node != null) {
            boolean shouldDeleteNode = deleteHelper(index + 1, word, node);
            if (shouldDeleteNode) {
                mapOfCharacters.remove(charAt);
                return mapOfCharacters.size() == 0;
            }
        }
        return false;
    }
}
