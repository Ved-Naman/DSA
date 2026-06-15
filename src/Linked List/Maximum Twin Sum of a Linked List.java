/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> values = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        int n = values.size();
        int maxTwinSum = 0;
        for (int i = 0; i < n / 2; i++) {
            int currentTwinSum = values.get(i) + values.get(n - 1 - i);
            maxTwinSum = Math.max(maxTwinSum, currentTwinSum);
        }

        return maxTwinSum;
    }
}