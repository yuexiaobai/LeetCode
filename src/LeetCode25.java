/**
 * 25. Reverse Nodes in k-Group
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 采用了递归的形式，注意链表翻转的实现
 * 非递归效率更高，而且在链表翻转时更易于理解和实现 todo 非递归链表翻转思路
 */
public class LeetCode25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        } else if (head != null && k == 1) {
            return head;
        }

        int i = 1;
        ListNode temp = new ListNode(head.val);
        temp.next = head.next;
        while (i <= k && temp != null) {
            i++;
            temp = temp.next;
        }

        if (i > k) {
            ListNode pre = head;
            ListNode cur = head.next;

            for (int j = 2; j <= k; j++) {
                ListNode next = cur.next;
                cur.next = head;
                pre.next = next;
                head = cur;
                cur = next;
            }
            pre.next = reverseKGroup(cur, k);
        }
        return head;
    }
}






/*
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int len = 0;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode begin = dummy;
        int i = 0;

        while (head != null) {
            ++i;
            if (i % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }

        }

        return dummy.next;
    }

    private ListNode reverse(ListNode begin, ListNode end) {
        ListNode pre = begin;
        ListNode cur = begin.next;
        ListNode first = cur;

        while (cur != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        begin.next = pre;
        first.next = end;
        return first;
    }
}
*/
