/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 感觉这题并不是很难，但是还是做不出来，不太应该，很难受呀
 * 主要问题在于删除相同的数字中的第一个，答案采用了p.next和p.next.next对比，成功保证了p和p.next值肯定不同
 * 在链表前面加一个头之前的问题遇到过，所以记住了
 */
public class LeetCode82 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode p = first;
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup) {
                    p.next = p.next.next;
                }
            } else {
                p = p.next;
            }

        }
        return first.next;
    }
}
