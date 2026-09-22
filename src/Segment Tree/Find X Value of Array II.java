class Solution {
    class Node {
        long[] remain = new long[5];
        int prod = 1;
    }

    class SegmentTree {
        Node[] tree;
        int n, k;

        public SegmentTree(int[] nums, int k) {
            this.n = nums.length;
            this.k = k;
            tree = new Node[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                tree[i] = new Node();
            }
            build(nums, 0, 0, n - 1);
        }

        private void build(int[] nums, int node, int start, int end) {
            if (start == end) {
                int val = nums[start] % k;
                tree[node].prod = val;
                tree[node].remain[val] = 1;
                return;
            }

            int mid = start + (end - start) / 2;
            build(nums, 2 * node + 1, start, mid);
            build(nums, 2 * node + 2, mid + 1, end);
            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public void update(int node, int start, int end, int idx, int val) {
            if (start == end) {
                val = val % k;
                tree[node].prod = val;
                for (int i = 0; i < k; i++) {
                    tree[node].remain[i] = 0;
                }
                tree[node].remain[val] = 1;
                return;
            }

            int mid = start + (end - start) / 2;
            if (idx <= mid) {
                update(2 * node + 1, start, mid, idx, val);
            } else {
                update(2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = merge(tree[2 * node + 1], tree[2 * node + 2]);
        }

        public Node query(int node, int start, int end, int l, int r) {
            if (l <= start && end <= r) {
                return tree[node];
            }
            if (r < start || end < l) {
                Node empty = new Node();
                empty.prod = 1;
                return empty;
            }

            int mid = start + (end - start) / 2;
            if (r <= mid) {
                return query(2 * node + 1, start, mid, l, r);
            }
            if (l > mid) {
                return query(2 * node + 2, mid + 1, end, l, r);
            }
            return merge(
                    query(2 * node + 1, start, mid, l, r),
                    query(2 * node + 2, mid + 1, end, l, r)
            );
        }

        private Node merge(Node left, Node right) {
            Node res = new Node();
            res.prod = (left.prod * right.prod) % k;

            for (int i = 0; i < k; i++) {
                res.remain[i] += left.remain[i];
            }

            for (int i = 0; i < k; i++) {
                int newMod = (i * left.prod) % k;
                res.remain[newMod] += right.remain[i];
            }

            return res;
        }
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        SegmentTree st = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            st.update(0, 0, nums.length - 1, index, value);
            Node res = st.query(0, 0, nums.length - 1, start, nums.length - 1);

            ans[i] = (int) res.remain[x];
        }

        return ans;
    }
}