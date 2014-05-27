package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * @author Joshua Wei
 */
public class BuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int[] left = new int[prices.length]; // max profit left of each element
        int[] right = new int[prices.length]; // max profit right of each element
        
        int lowest = prices[0];
        left[0] = 0;
        for (int i = 1; i < left.length; i++) {
            if (prices[i] < lowest) lowest = prices[i];
            left[i] = prices[i] - lowest > left[i - 1] ? prices[i] - lowest : left[i - 1];
        }
        
        int highest = prices[prices.length - 1];
        right[right.length - 1] = 0;
        for (int i = right.length - 2; i >= 0; i--) {
            if (prices[i] > highest) highest = prices[i];
            right[i] = highest - prices[i] > right[i + 1] ? highest - prices[i] : right[i + 1];
        }
        
        int ret = 0;
        for (int i = 0; i < prices.length; i++) {
            int sum = left[i] + right[i];
            if (sum > ret) ret = sum;
        }
        return ret;
    }
}
