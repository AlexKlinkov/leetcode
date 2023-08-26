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
import java.util.Optional;
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Optional<ListNode> checkList1 = Optional.ofNullable(list1);
        Optional<ListNode> checkList2 = Optional.ofNullable(list2);
        if (checkList1.isEmpty() && checkList2.isEmpty()) {
            return null;
        } else if (checkList1.isEmpty()) {
            return list2;
        } else if (checkList2.isEmpty()) {
            return list1;
        } else {
            return sortNodeLists(list1, list2);
        }
    }

    public ListNode sortNodeLists(ListNode checkList1, ListNode checkList2) {
        ListNode list1 = checkList1;
        ListNode list2 = checkList2;
        ListNode result = new ListNode(); // Dummy head node
        ListNode current = result;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next; // go over to the last element of result list
        }
        if (list1 != null) {
            current.next = list1;
        }
        if (list2 != null) {
            current.next = list2;
        }
        return result.next; // Skip the dummy head node
    }
}