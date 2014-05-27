package misc;

import java.util.*;

/**
 * Definition for a point.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * @author Joshua Wei
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        if (points.length == 1) {
            return 1;
        }
        
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopes = new HashMap<Double, Integer>();
            
            for (int j = i + 1; j < points.length; j++) {
                Double slope;
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        slope = Double.NaN;
                    } else {
                        slope = Double.POSITIVE_INFINITY;
                    }
                } else if (points[i].y == points[j].y) {
	                	slope = Double.valueOf(0);
                } else {
                    slope = 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
                }
                
                if (slopes.containsKey(slope)) {
                    slopes.put(slope, slopes.get(slope).intValue() + 1);
                } else {
                    slopes.put(slope, 1);
                }
            }
            
            for (Double d : slopes.keySet()) {
                int cnt;
                if (d.equals(Double.NaN)) {
                    cnt = slopes.get(d);
                } else {
                    cnt = slopes.get(d);
                    if (slopes.containsKey(Double.NaN)) {
                        cnt += slopes.get(Double.NaN);
                    }
                }
                
                if (cnt > max) max = cnt;
            }
        }
        
        return max + 1;
    }
}
