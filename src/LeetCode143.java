/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * 这道题思路比较简单，分为一下三步：
 * 1、找到中心点，然后分为两个链表
 * 2、逆转第二个链表
 * 3、合并第一个链表和逆转后的第二个链表
 * 虽然思路简单，但是貌似写起来错误了好多遍，代码多了还是容易错，思路没有那么清晰
 */
public class LeetCode143 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head != null) {
            // 第一步
            ListNode fast = head;
            ListNode slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            fast = slow.next;
            slow.next = null;
            // 第二步
            ListNode right = reverse(fast);

            // 第三步
            ListNode left = head;
            ListNode leftnext, rightnext;
            while (left != null && right != null) {
                leftnext = left.next;
                rightnext = right.next;
                left.next = right;
                right.next = leftnext;
                right = rightnext;
                left = leftnext;
            }
        }
    }

    /**
     * 递归逆转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
