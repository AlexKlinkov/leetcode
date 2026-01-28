/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) // check a list not null and it contains more than 1 element
            return false;

        ListNode pointerSlow = head; // turtle
        ListNode pointerFast = head.next; // hare

        while (pointerSlow != pointerFast) {
            if (pointerFast == null || pointerFast.next == null)
                return false;
            pointerSlow = pointerSlow.next; // move 1 step
            pointerFast = pointerFast.next.next; // move 2 steps
        }
        return true;
    }
}