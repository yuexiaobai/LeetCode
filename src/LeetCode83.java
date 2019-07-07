/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 有了前一道题的提示，这道题就非常简单，
 * 总结如下:
 * 如果要把重复的节点都去掉，就要比较head.next.val 和head.next.next.val
 * 如果保留一个重复的节点就是比较head.next.val 和 head.val,不相等时后移pre节点
 */
public class LeetCode83 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        while (head != null) {
            while (head.next != null && head.next.val == head.val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        return first.next;
    }
}
