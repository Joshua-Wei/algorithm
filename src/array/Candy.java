package array;

/**
 * There are N children standing in a line. Each child is assigned a rating value. 
 * 
 * You are giving candies to these children subjected to the following requirements:
 * - Each child must have at least one candy.
 * - Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give? 
 * 
 * @author Joshua Wei
 */
public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        
        int[] candies = new int[ratings.length];
        for (int i = 0; i < candies.length; i++) candies[i] = 1;
        
        for (int i = 1; i < candies.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = candies.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int count = 0;
        for (int c : candies) count += c;
        return count;
    }
}
