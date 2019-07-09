/**
 * 86. Partition List
 * https://leetcode.com/problems/partition-list/
 * 先分成两个链表再合并
 */
public class LeetCode86 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode firsthead = first, secondhead = second;
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        second.next = null;
        first.next = secondhead.next;
        return firsthead.next;
    }
}
