/**
 * 61. Rotate List
 * https://leetcode.com/problems/rotate-list/
 * 一次通过，效率还可以
 */
public class LeetCode61 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode start = head;
        while (start != null) {
            len++;
            start = start.next;
        }
        k %= len;
        ListNode end = head;
        start = end;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }
        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = head;
        head = start.next;
        start.next = null;
        return head;
    }

}
