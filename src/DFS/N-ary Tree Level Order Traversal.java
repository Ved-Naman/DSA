/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, 0 , result);
        return result;
    }
    private void dfs(Node node, int level, List<List<Integer>> result){
        if(result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        for (Node child : node.children) {
            dfs(child, level + 1, result);
        }
    }
}