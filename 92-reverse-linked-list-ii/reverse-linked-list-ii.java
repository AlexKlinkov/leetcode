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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right)
            return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        // finds the previous and a left element moving a pointer
        int count = 1;
        while (count < left) {
            prev = curr; // left - 1
            curr = curr.next; // left
            count++;
        }

        // saves important pointers
        ListNode beforeLeft = prev; // can be null if left = 1
        ListNode start = curr; // the left element

        // reverse a list from left to right + 1. Example: [1, 2, 3, 4, 5], left = 2, right = 4
        // prev: 4 -> 3 -> 2 -> 1 -> null and curr = 5
        // i0: 1 <- 2             3 -> 4 -> 5
        // i1: 1 <- 2 <- 3        4 -> 5
        // i2: 1 <- 2 <- 3 <- 4   5
        for (int i = 0; i < right - left + 1; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // sews the list, previous left now pointers at a node after right
        start.next = curr; // узел 2.next = узел 5. 2 → 5
        if (beforeLeft != null) {
            beforeLeft.next = prev; // 1 → 4
            return head;  // 1 -> 4 -> 3 -> 2 -> 5
        } else {
            return prev;
        }
    }
}