package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
 * an algorithm to find the maximum profit.
 * 
 * @author Joshua Wei
 */
public class BuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int max = 0;
        
        int lowest = prices[0];
        int highest = prices[0];
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > highest) {
                highest = prices[i];
                int diff = highest - lowest;
                if (diff > max) max = diff;
            }
            if (prices[i] < lowest) {
                lowest = prices[i];
                highest = prices[i];
            }
        }
        
        return max;
    }
}
