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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null && n == 1) {
            return null;
        }
        int quantityOfNodesInList = amountOfNodeInList(head);
        int count = 0;
        List<Integer> necessaryValues = new ArrayList<>();
        while (head != null) {
            if (quantityOfNodesInList - n != count) {
                necessaryValues.add(head.val);
            }
            head = head.next;
            count++;
        }
        return createNodeList(necessaryValues);
    }
    public ListNode createNodeList(List<Integer> values) {
        List<ListNode> nodes = new ArrayList<>();
        for (Integer elem : values) {
            nodes.add(new ListNode(elem));
        }
        ListNode result = new ListNode();
        ListNode pointer = result;
        result.val = nodes.get(0).val;
        for (int i = 1; i < nodes.size(); i++) {
            pointer.next = nodes.get(i);
            pointer = pointer.next;
        }
        return result;
    }
    public int amountOfNodeInList(ListNode nodes) {
        ListNode pointer = nodes;
        int count = 0;
        while (pointer != null) {
            pointer = pointer.next;
            count++;
        }
        return count;
    }
}