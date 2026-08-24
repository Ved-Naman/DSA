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
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode current = null;

        while (!queue.isEmpty()) {
            current = queue.poll();

            if (current.right != null) {
                queue.offer(current.right);
            }

            if (current.left != null) {
                queue.offer(current.left);
            }
        }

        return current.val;
    }
}