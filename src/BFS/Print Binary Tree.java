/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    class State {
        TreeNode node;
        int r;
        int c;

        State(TreeNode node, int r, int c) {
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int m = height + 1;
        int n = (1 << (height + 1)) - 1;

        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add("");
            }
            res.add(row);
        }

        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(root, 0, (n - 1) / 2));

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            res.get(curr.r).set(curr.c, String.valueOf(curr.node.val));

            if (curr.node.left != null) {
                int offset = 1 << (height - curr.r - 1);
                queue.offer(new State(curr.node.left, curr.r + 1, curr.c - offset));
            }

            if (curr.node.right != null) {
                int offset = 1 << (height - curr.r - 1);
                queue.offer(new State(curr.node.right, curr.r + 1, curr.c + offset));
            }
        }

        return res;
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }
}