class Solution {
    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        Set<String> result = new TreeSet<>();
        queue.offer(expression);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.indexOf('{') == -1) {
                result.add(current);
                continue;
            }

            int right = current.indexOf('}');
            int left = current.lastIndexOf('{', right);

            String before = current.substring(0, left);
            String after = current.substring(right + 1);
            String[] parts = current.substring(left + 1, right).split(",");

            for (String part : parts) {
                queue.offer(before + part + after);
            }
        }

        return new ArrayList<>(result);
    }
}