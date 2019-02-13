import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 60. Permutation Sequence
 * https://leetcode.com/problems/permutation-sequence/
 * 这个借鉴之前的算法把所有的情况列了出来，排序求得了答案，效率太低，有更好的方法
 * 当时也考虑了根据规律来计算的方法，但是没有整明白
 * 优秀算法博客讲解http://bangbingsyb.blogspot.com/2014/11/leetcode-permutation-sequence.html
 * TODO 没别的，记一下呗
 */
public class LeetCode60 {
    List<Integer> result = new ArrayList<>();

    public String getPermutation(int n, int k) {
        int[] nums = getnums(n);
        constructNums(n, nums, new ArrayList<>(), 0);
        Collections.sort(result);
        return result.get(k - 1).toString();
    }

    private int[] getnums(int n) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        return nums;
    }

    private void constructNums(int n, int[] nums, List<Integer> list, int start) {
        if (start == n) {
            result.add(getNumFromList(list));
            return;
        }
        for (int i = start; i < n; i++) {
            exchangeNums(nums, i, start);
            list.add(nums[start]);
            constructNums(n, nums, list, start + 1);
            list.remove(list.size() - 1);
            exchangeNums(nums, start, i);
        }
    }

    private int getNumFromList(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int i : list) {
            builder.append(i);
        }
        return Integer.parseInt(builder.toString());
    }

    private void exchangeNums(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}


// 优秀算法
/*
class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> set=new LinkedList<>();
        int fact=1;
        for(int i=1;i<=n;i++){
            if(i<n){
                fact*=i;
            }
            set.add(i);
        }
        k--;
        StringBuffer buf=new StringBuffer();
        for(int i=n-1;i>=0;i--){
            int index=k/fact;
            k%=fact;
            buf.append(set.remove(index));
            if(i>0){
                fact /= i;
            }
        }
        return buf.toString();
    }
}
*/
