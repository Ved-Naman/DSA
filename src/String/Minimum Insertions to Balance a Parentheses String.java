class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openCount = 0; // Tracks the number of needed '('

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                openCount++;
            } else {
                // If we see a single ')', check if the next character is also ')'
                if (i + 1 < n && s.charAt(i + 1) == ')') {
                    i++; // Skip the second ')' of the pair "))"
                } else {
                    // Missing a matching ')' to form "))"
                    insertions++;
                }

                // Match the "))" with an opening '('
                if (openCount > 0) {
                    openCount--;
                } else {
                    // Missing an opening '('
                    insertions++;
                }
            }
        }

        // Each remaining '(' needs two ')'
        insertions += openCount * 2;

        return insertions;
    }
}