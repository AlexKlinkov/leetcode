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
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (getSize(head) == 1) {
            return head;
        }
        List<Integer> intermediate = new ArrayList<>();
        while (head != null) {
            intermediate.add(head.val);
            head = head.next;
        }
        int[] resultArr = new int[intermediate.size()];
        for (int i = 0; i < intermediate.size(); i++) {
            if (i % 2 == 0) {
                if (i + 1 == resultArr.length) {
                    resultArr[i] = intermediate.get(i);
                } else {
                    resultArr[i + 1] = intermediate.get(i);
                }
            } else {
                resultArr[i - 1] = intermediate.get(i);
            }
        }
        return createSwapList(resultArr);
    }
    private ListNode createSwapList(int[] arr) {
        ListNode result = new ListNode();
        ListNode pointer = result;
        for (int j : arr) {
            pointer.next = new ListNode(j);
            pointer = pointer.next;
        }
        return result.next;
    }
    private int getSize(ListNode node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }
}