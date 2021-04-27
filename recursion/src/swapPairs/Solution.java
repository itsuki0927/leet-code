package swapPairs;

/**
 * @author: itsuki
 * @create: 2021-04-26 20:38
 **/
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
