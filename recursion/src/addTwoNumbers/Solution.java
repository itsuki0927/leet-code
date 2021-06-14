package addTwoNumbers;

/**
 * @author: itsuki
 * @create: 2021-06-13 15:17
 **/
public class Solution {
    int carry = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null && carry == 0) return null;

        if (l1 == null && l2 != null && carry == 0) return l2;
        if (l2 == null && l1 != null && carry == 0) return l1;

        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;

        int sum = n1 + n2 + carry;
        carry = sum / 10;
        ListNode node = new ListNode(sum % 10);

        node.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next);

        return node;
    }
}
