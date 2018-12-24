/**
 * 23. Merge k Sorted Lists
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 暴力循环解决了问题，但是时间复杂度太高
 * 最优算法采用了二分+递归的方法，需要重点review
 * 此题和LeetCode4有一定的相似性，可以一起分析
 */
// todo 和LeetCode4一起分析
public class LeetCode23 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        int len = lists.length;
        int minvalue;
        int pos;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (true) {
            pos = -1;
            minvalue = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                ListNode listNode = lists[i];
                if (listNode != null && minvalue > listNode.val) {
                    pos = i;
                    minvalue = listNode.val;
                }
            }
            if (pos == -1) {
                break;
            } else {
                ListNode n = new ListNode(minvalue);
                cur.next = n;
                cur = cur.next;
                ListNode listNode = lists[pos];
                lists[pos] = listNode.next;
            }
        }
        return head.next;
    }
}


/*
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }

        int mid = (start + end) / 2;

        ListNode left = merge(lists, start, mid);
        ListNode right = merge(lists, mid+1, end);
        ListNode res = new ListNode(0);
        ListNode temp = res;
        while(left != null || right != null){
            if(left == null){
                res.next = right;
                return temp.next;
            }

            if(right == null){
                res.next = left;
                return temp.next;
            }

            if(left.val < right.val){
                res.next = left;
                res = res.next;
                left = left.next;
            }else{
                res.next = right;
                res = res.next;
                right = right.next;
            }
        }
        return temp.next;
    }
}
*/
