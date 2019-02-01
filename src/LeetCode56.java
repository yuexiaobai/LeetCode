import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 * 完美通过，效率也还可以
 * todo 最优化方法更快，但是不好想，可以重点记下
 * 相当于对start和end都进行了重排，然后让小的start对应小的end，结果是不变的
 */
public class LeetCode56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval t1) {
                return interval.start - t1.start;
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= start && interval.start <= end) {
                if (interval.end > end) {
                    end = interval.end;
                    continue;
                }
            } else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
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
    public List<Interval> merge(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new ArrayList<Interval>();
        int i = 0;
        while(i<intervals.size()) {
            int start = starts[i];
            while(i<intervals.size()-1&&starts[i+1]<=ends[i]) {
                i++;
            }
            int end = ends[i];
            res.add(new Interval(start,end));
            i++;
        }


        return res;
    }
}
*/
