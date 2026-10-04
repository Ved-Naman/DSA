class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        // Pass 1: Match closing brackets with available opens or stars
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                openStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else { // c == ')'
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false; // No '(' or '*' left to match this ')'
                }
            }
        }

        // Pass 2: Match leftover opening brackets with remaining stars
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            int openIndex = openStack.pop();
            int starIndex = starStack.pop();

            // A star can only act as ')' if it appears AFTER the '('
            if (openIndex > starIndex) {
                return false;
            }
        }

        return openStack.isEmpty();
    }
}