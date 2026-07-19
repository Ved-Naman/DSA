class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> x = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                x.add(nums1[p1]);
                p1++;
            } else {
                x.add(nums2[p2]);
                p2++;
            }
        }

        while (p1 < m) {
            x.add(nums1[p1]);
            p1++;
        }

        while (p2 < n) {
            x.add(nums2[p2]);
            p2++;
        }

        for (int i = 0; i < x.size(); i++) {
            nums1[i] = x.get(i);
        }
    }
}