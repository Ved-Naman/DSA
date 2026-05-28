class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int bestIndex = -1;
    }

    TrieNode root = new TrieNode();
    String[] words;

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        this.words = wordsContainer;
        for (int i = 0; i < words.length; i++) {
            insert(i);
        }

        int[] result = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            result[i] = search(wordsQuery[i]);
        }

        return result;
    }

    private void insert(int index) {
        TrieNode current = root;
        String word = words[index];

        current.bestIndex = getBetterIndex(current.bestIndex, index);

        for (int i = word.length() - 1; i >= 0; i--) {
            int charIndex = word.charAt(i) - 'a';

            if (current.children[charIndex] == null) {
                current.children[charIndex] = new TrieNode();
            }

            current = current.children[charIndex];

            current.bestIndex = getBetterIndex(current.bestIndex, index);
        }
    }

    private int search(String query) {
        TrieNode current = root;
        for (int i = query.length() - 1; i >= 0; i--) {
            int charIndex = query.charAt(i) - 'a';

            if (current.children[charIndex] == null) {
                break;
            }

            current = current.children[charIndex];
        }

        return current.bestIndex;
    }

    private int getBetterIndex(int oldIndex, int newIndex) {
        if (oldIndex == -1) return newIndex;

        int oldLen = words[oldIndex].length();
        int newLen = words[newIndex].length();

        if (newLen < oldLen) {
            return newIndex;
        }
        else if (newLen == oldLen && newIndex < oldIndex) {
            return newIndex;
        }

        return oldIndex;
    }
}