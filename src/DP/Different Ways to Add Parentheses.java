class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        // 1. Scan the string for operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c == '+' || c == '-' || c == '*') {
                // Split the string into left and right parts
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                // 2. Recursively get all results for the left and right parts
                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                // 3. Combine every left result with every right result
                for (int left : leftResults) {
                    for (int right : rightResults) {
                        if (c == '+') {
                            result.add(left + right);
                        } else if (c == '-') {
                            result.add(left - right);
                        } else if (c == '*') {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        // 4. Base Case: If there were no operators, it's just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }
}