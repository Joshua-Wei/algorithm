package array;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note:
 * 
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * 
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * 
 * @author Joshua Wei
 */
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (num != null && num.length >= 4) {
            Arrays.sort(num);
            
            int i = 0;
            while (i < num.length - 3) {
                int j = i + 1;
                while (j < num.length - 2) {
                    int m = j + 1;
                    int n = num.length - 1;
                    
                    while (m < n) {
                        int sum = num[i] + num[j] + num[m] +num[n];
                        if (sum < target) {
                            do {
                                m++;
                            } while (m < n && num[m] == num[m - 1]);
                        } else if (sum > target) {
                            do {
                                n--;
                            } while (m < n && num[n] == num[n + 1]);
                        } else {
                            ArrayList<Integer> list = new ArrayList<Integer>();
                            list.add(num[i]);
                            list.add(num[j]);
                            list.add(num[m]);
                            list.add(num[n]);
                            result.add(list);
                            do {
                                m++;
                            } while (m < n && num[m] == num[m - 1]);
                            do {
                                n--;
                            } while (m < n && num[n] == num[n + 1]);
                        }
                    }
                    do {
                        j++;
                    } while (j < num.length - 2 && num[j] == num[j - 1]);
                }
                do {
                    i++;
                } while (i < num.length - 3 && num[i] == num[i - 1]);
            }
        }
        
        return result;
    }
}
