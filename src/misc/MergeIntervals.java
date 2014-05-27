package misc;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18]. 
 * 
 * @author Joshua Wei
 */
public class MergeIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Interval[] a = new Interval[intervals.size()];
		a = intervals.toArray(a);
		Arrays.sort(a, new Comparator<Interval>() {
			@Override
			public int compare(Interval interval1, Interval interval2) {
				return interval1.start - interval2.start;
			}
		});
		
		for (int i = 0; i < a.length - 1; i++) {
			if (isOverlap(a[i], a[i + 1])) {
				a[i + 1].start = a[i].start;
				a[i + 1].end = Math.max(a[i].end, a[i + 1].end);
				a[i] = null;
			}
		}
		
		intervals.clear();
		for (Interval interval : a) {
			if (interval != null) intervals.add(interval);
		}
        
        return intervals;
    }
    
    private boolean isOverlap(Interval x, Interval y) {
        return !(x.start > y.end || x.end < y.start);
    }
}
