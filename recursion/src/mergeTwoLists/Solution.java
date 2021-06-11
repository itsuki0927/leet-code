package mergeTwoLists;

/**
 * @author: itsuki
 * @create: 2021-06-11 10:09
 **/
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode L1 = new ListNode(1);
        L1.next = new ListNode(2);
        L1.next.next = new ListNode(4);

        ListNode L2 = new ListNode(1);
        L2.next = new ListNode(3);
        L2.next.next = new ListNode(4);

        ListNode listNode = new Solution().mergeTwoLists(L1, L2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
