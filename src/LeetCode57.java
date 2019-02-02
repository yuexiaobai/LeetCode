import java.util.Iterator;
import java.util.List;

/**
 * 57. Insert Interval
 * https://leetcode.com/problems/insert-interval/
 * 这道题的难点在于怎么在更新完newInterval覆盖的范围后，删除旧的，在正确的地方insert进去新的
 * 优秀方法通过置空来判断，比我的方法要优雅很多，而且减少了一次循环
 * 主要iterator不能一边删一遍加貌似，试了下会出错
 * todo 学了一招，加到list后置空，用判空来看是否已经加过了
 */
public class LeetCode57 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (newInterval == null) {
            return intervals;
        }
        int start = newInterval.start;
        int end = newInterval.end;
        Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()) {
            Interval interval = iterator.next();
            if (interval.start > end) {
                break;
            } else if (interval.end < start) {
                continue;
            }
            start = start < interval.start ? start : interval.start;
            end = end > interval.end ? end : interval.end;
            iterator.remove();
        }
        int pos;
        for (pos = 0; pos < intervals.size(); pos++) {
            if (intervals.get(pos).start > start) {
                intervals.add(pos, new Interval(start, end));
                break;
            }
        }
        if (pos == intervals.size()) {
            intervals.add(new Interval(start, end));
        }
        return intervals;
    }

    // Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}





/*
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        for(int i=0; i<intervals.size(); i++) {
            Interval it = intervals.get(i);
            if(newInterval == null || it.end < newInterval.start) {
                res.add(it);
            }
            else if(newInterval != null && it.start > newInterval.end) {
                res.add(newInterval);
                newInterval = null;
                res.add(it);
            }
            else {
                newInterval.start = Math.min(it.start, newInterval.start);
                newInterval.end = Math.max(it.end, newInterval.end);

            }

        }
        if(newInterval != null) res.add(newInterval);
        return res;
    }
}
*/
