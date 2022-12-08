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
import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        StringBuilder mySum = new StringBuilder();
        ListNode s1 = l1;
        ListNode s2 = l2;
        while (true) {
            if (s1 != null) {
                first.append(s1.val);
                s1 = s1.next;
            }
            if (s2 != null) {
                second.append(s2.val);
                s2 = s2.next;
            }
            if (s1 == null && s2 == null) {
                break;
            }
        }
        BigInteger f = new BigInteger(first.reverse().toString());
        BigInteger s = new BigInteger(second.reverse().toString());
        mySum.append(f.add(s)).reverse();
        char[] elementsOfSum = String.valueOf(mySum).toCharArray();
        ListNode[] answer = new ListNode[elementsOfSum.length];
        for (int i = 0; i < elementsOfSum.length; i++) {
            answer[i] = new ListNode(elementsOfSum[i] - '0');
        }
        for (int j = 0; j < elementsOfSum.length - 1; j++) {
            answer[j].next = answer[j + 1];
        }
        return answer[0];
        
    }
}