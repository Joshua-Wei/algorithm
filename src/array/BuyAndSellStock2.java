package array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 * @author Joshua Wei
 */
public class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int profit = 0;
        
        int i = 0;
        int j = 0;
        while (i < prices.length - 1 && j < prices.length - 1) {
            while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                i++;
            }
            if (i == prices.length - 1) break;
            
            j = i + 1;
            while (j < prices.length - 1 && prices[j + 1] >= prices[j]) {
                j++;
            }
            profit += prices[j] - prices[i];
            i = j + 1;
        }
        
        return profit;
    }
}
