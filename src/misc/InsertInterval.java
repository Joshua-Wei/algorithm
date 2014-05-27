package misc;

import java.util.*;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9]. 
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10]. 
 * 
 * @author Joshua Wei
 */
public class InsertInterval {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        
        if (intervals == null && newInterval == null) {
            // do nothing
        } else if (newInterval == null) {
            result.addAll(intervals);
        } else if (intervals == null) {
            result.add(newInterval);
        } else {
            int i = 0;
            while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
                result.add(intervals.get(i));
                i++;
            }
            
            if (i == intervals.size()) {
                result.add(newInterval);
            } else {
                while (i < intervals.size() && isOverlap(intervals.get(i), newInterval)) {
                    newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                    newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                    i++;
                }
                result.add(newInterval);
                while (i < intervals.size()) {
                    result.add(intervals.get(i));
                    i++;
                }
            }
        }
        
        return result;
    }
    
    private boolean isOverlap(Interval a, Interval b) {
        return !(a.start > b.end || a.end < b.start);
    }
}
