class Solution {
    private Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int remOpen = 0;
        int remClose = 0;

        // Step 1: Count minimum removals needed
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                remOpen++;
            } else if (c == ')') {
                if (remOpen > 0) {
                    remOpen--;
                } else {
                    remClose++;
                }
            }
        }

        // Step 2: DFS Backtracking
        dfs(s, 0, remOpen, remClose, 0, new StringBuilder());
        return new ArrayList<>(validExpressions);
    }

    private void dfs(String s, int index, int remOpen, int remClose, int balance, StringBuilder current) {
        // Prune if balance drops below 0 (invalid state: more ')' than '(')
        if (balance < 0) {
            return;
        }

        // Base case: processed entire string
        if (index == s.length()) {
            if (remOpen == 0 && remClose == 0 && balance == 0) {
                validExpressions.add(current.toString());
            }
            return;
        }

        char c = s.charAt(index);
        int length = current.length();

        // Option 1: Skip (remove) the current parenthesis
        if (c == '(' && remOpen > 0) {
            dfs(s, index + 1, remOpen - 1, remClose, balance, current);
        } else if (c == ')' && remClose > 0) {
            dfs(s, index + 1, remOpen, remClose - 1, balance, current);
        }

        // Option 2: Include the current character
        current.append(c);
        if (c == '(') {
            dfs(s, index + 1, remOpen, remClose, balance + 1, current);
        } else if (c == ')') {
            dfs(s, index + 1, remOpen, remClose, balance - 1, current);
        } else {
            // For regular characters (letters, numbers, etc.)
            dfs(s, index + 1, remOpen, remClose, balance, current);
        }

        // Backtrack
        current.setLength(length);
    }
}