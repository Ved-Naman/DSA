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
    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        // Building the tree
        for (int[] desc : descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            // Create the nodes if they don't exist yet
            nodeMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodeMap.putIfAbsent(childVal, new TreeNode(childVal));

            // Grab the actual objects from our map
            TreeNode parentNode = nodeMap.get(parentVal);
            TreeNode childNode = nodeMap.get(childVal);

            // Link them together
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Record that this child is definitely NOT the root
            children.add(childVal);
        }

        // Find the Root
        for (int[] desc : descriptions) {
            int parentVal = desc[0];

            // The root is the only node that is never someone's child
            if (!children.contains(parentVal)) {
                return nodeMap.get(parentVal);
            }
        }

        return null;
    }
}