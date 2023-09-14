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
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        if (isAllArrayElemEqualNull(lists)) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lists.length; i++) {
            ListNode nextElem = lists[i];
            while (nextElem != null) {
                result.add(nextElem.val);
                nextElem = nextElem.next;
            }
        }
        Collections.sort(result);
        return createListNode(result);
    }

    private ListNode createListNode(List<Integer> sortedList) {
        ListNode result = new ListNode();
        ListNode pointer = result; // refers to result
        result.val = sortedList.get(0);
        for (int i = 1; i < sortedList.size(); i++) {
            pointer.next = new ListNode(sortedList.get(i));
            pointer = pointer.next; // ListNode (value, new ListNode(value, new ListNode(value, new ListNode(value)))
                                                // ↑                   ↑        ↑          ↑           ↑       ↑
                                          // result.val;     pointer.next; pointer; pointer.next; pointer; pointer.next;
        }
        return result;
    }

    private boolean isAllArrayElemEqualNull(ListNode[] lists) {
        int countArray = lists.length;
        int countNullArray = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                countNullArray++;
            }
        }
        return countArray == countNullArray;
    }
}