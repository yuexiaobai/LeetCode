/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * 本题思路：根据141题思路，先找到相遇节点，并且根据count可以算出环的长度
 * 然后fast节点先走环的长度个节点，slow和fast再共同走length - count个节点
 * 即fast走了length个长度，slow走了length - count个长度，相遇在第一个节点
 * 看不懂可以画个图
 * 最优算法是Floyd算法，但是找相遇节点的循环起始条件有点不一样，需要注意
 * TODO Floyd算法 快慢指针 + 规律
 */
public class LeetCode142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        int count = 1;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            count++;
        }
        fast = head;
        slow = head;
        while (count > 0) {
            count--;
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
