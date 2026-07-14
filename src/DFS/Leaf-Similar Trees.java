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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        findLeaves(root1, leaves1);
        findLeaves(root2, leaves2);
        return leaves1.equals(leaves2);
    }
    private void findLeaves(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            leafList.add(node.val);
        }

        findLeaves(node.left, leafList);
        findLeaves(node.right, leafList);
    }
}