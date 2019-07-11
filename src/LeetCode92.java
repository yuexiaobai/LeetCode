/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 题不难，思路比较容易，但是一次写对也比较难，有很多细节需要考虑
 */
public class LeetCode92 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = new ListNode(0);
        node.next = head;
        int index = 1;
        ListNode prehead = node;
        while (index < m && head != null) {
            index++;
            prehead = head;
            head = head.next;
        }
        ListNode pre = head, cur = pre.next, next;
        while (index < n && cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            index++;
        }
        prehead.next = pre;
        head.next = cur;

        return node.next;
    }
}
