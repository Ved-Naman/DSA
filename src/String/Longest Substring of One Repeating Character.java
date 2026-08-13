class Solution {
    int[] maxLen;
    int[] prefLen;
    int[] suffLen;
    char[] prefChar;
    char[] suffChar;
    int[] sz;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        maxLen = new int[4 * n];
        prefLen = new int[4 * n];
        suffLen = new int[4 * n];
        prefChar = new char[4 * n];
        suffChar = new char[4 * n];
        sz = new int[4 * n];

        build(0, 0, n - 1, s);

        int k = queryIndices.length;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            update(0, 0, n - 1, queryIndices[i], queryCharacters.charAt(i));
            ans[i] = maxLen[0];
        }
        return ans;
    }

    private void build(int node, int l, int r, String s) {
        if (l == r) {
            maxLen[node] = prefLen[node] = suffLen[node] = 1;
            prefChar[node] = suffChar[node] = s.charAt(l);
            sz[node] = 1;
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * node + 1, l, mid, s);
        build(2 * node + 2, mid + 1, r, s);
        merge(node, 2 * node + 1, 2 * node + 2);
    }

    private void update(int node, int l, int r, int idx, char c) {
        if (l == r) {
            prefChar[node] = suffChar[node] = c;
            return;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            update(2 * node + 1, l, mid, idx, c);
        } else {
            update(2 * node + 2, mid + 1, r, idx, c);
        }
        merge(node, 2 * node + 1, 2 * node + 2);
    }

    private void merge(int node, int left, int right) {
        sz[node] = sz[left] + sz[right];
        prefChar[node] = prefChar[left];
        suffChar[node] = suffChar[right];

        prefLen[node] = prefLen[left];
        if (prefLen[left] == sz[left] && prefChar[left] == prefChar[right]) {
            prefLen[node] += prefLen[right];
        }

        suffLen[node] = suffLen[right];
        if (suffLen[right] == sz[right] && suffChar[right] == suffChar[left]) {
            suffLen[node] += suffLen[left];
        }

        maxLen[node] = Math.max(maxLen[left], maxLen[right]);
        if (suffChar[left] == prefChar[right]) {
            maxLen[node] = Math.max(maxLen[node], suffLen[left] + prefLen[right]);
        }
    }
}