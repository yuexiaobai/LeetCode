/**
 * 24. Swap Nodes in Pairs
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 递归实现，递归要比循环慢些
 */
public class LeetCode24 {

    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode ncur = head.next;
        if (cur != null && ncur != null) {
            cur.next=swapPairs(ncur.next);
            ncur.next = cur;
        }
        return ncur;
    }
}


/**
 * 循环版本，更快
 * 需要多采用一个previous变量
 */

/*class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode output = head.next;
        ListNode previous = null;
        while(head != null && head.next != null) {
            ListNode next = head.next;
            head.next = next.next;
            next.next = head;
            if(previous != null) {
                previous.next = next;
            }
            if(head.next == null) {
                break;
            }
            previous = head;
            head = head.next;
        }
        return output;
    }
}*/
