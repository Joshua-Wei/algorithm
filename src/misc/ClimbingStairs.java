package misc;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * 
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * @author Joshua Wei
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] steps = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 2) steps[i] = i;
            else steps[i] = steps[i - 2] + steps[i - 1];
        }
        return steps[n];
    }
}
