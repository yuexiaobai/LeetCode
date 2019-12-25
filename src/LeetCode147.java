/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/insertion-sort-list/
 * 思路比较简单，就是取出每个节点从链表头部开始比较
 * tips：在链表头部增加一个最小值的表头更好处理
 * 但是最简洁的算法可以参考
 * https://leetcode-cn.com/problems/insertion-sort-list/solution/pai-xu-de-san-chong-si-lu-di-gui-zeng-duan-lian-bi/
 * 思路是真的强
 */
public class LeetCode147 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        /**
         * 在head之前添加一个节点，这样链表头部比较好处理
         */
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        pre.next = head;
        ListNode node = pre;
        ListNode next, iter;
        while (node != null) {
            next = node.next;
            if (next != null && node.val > next.val) {
                node.next = next.next;
                iter = pre;
                while (!(iter.val <= next.val && iter.next.val > next.val)) {
                    iter = iter.next;
                }
                next.next = iter.next;
                iter.next = next;
            } else {
                node = node.next;
            }
        }
        return pre.next;
    }
}
