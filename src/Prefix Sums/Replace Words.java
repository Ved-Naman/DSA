class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    TrieNode root;

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public String searchAndReplace(String word) {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();

        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                break;
            }

            prefix.append(c);
            node = node.children[index];

            if (node.isEnd) {
                return prefix.toString();
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();

        for (String word : dictionary) {
            insert(word);
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                result.append(" ");
            }
            result.append(searchAndReplace(words[i]));
        }

        return result.toString();
    }
}