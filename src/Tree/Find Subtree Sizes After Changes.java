class Solution {
    private int[] ans;
    private int[] newParent;
    private int[] lastAncestor;
    private List<Integer>[] origTree;
    private List<Integer>[] finalTree;
    private String s;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        this.s = s;
        this.ans = new int[n];
        this.newParent = Arrays.copyOf(parent, n);
        this.lastAncestor = new int[26];
        Arrays.fill(this.lastAncestor, -1);

        this.origTree = new ArrayList[n];
        this.finalTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            origTree[i] = new ArrayList<>();
            finalTree[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            origTree[parent[i]].add(i);
        }

        findNewParents(0);

        for (int i = 1; i < n; i++) {
            finalTree[newParent[i]].add(i);
        }
        computeSubtreeSize(0);

        return ans;
    }

    private void findNewParents(int u) {
        int charIdx = s.charAt(u) - 'a';
        int prevAncestor = lastAncestor[charIdx];
        lastAncestor[charIdx] = u;

        for (int v : origTree[u]) {
            int vCharIdx = s.charAt(v) - 'a';
            if (lastAncestor[vCharIdx] != -1) {
                newParent[v] = lastAncestor[vCharIdx];
            } else {
                newParent[v] = u;
            }
            findNewParents(v);
        }

        lastAncestor[charIdx] = prevAncestor;
    }

    private int computeSubtreeSize(int u) {
        int size = 1;
        for (int child : finalTree[u]) {
            size += computeSubtreeSize(child);
        }
        ans[u] = size;
        return size;
    }
}