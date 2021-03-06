package array;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique. 
 * 
 * @author Joshua Wei
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0 || cost == null || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        
        int start = 0;
        int net = 0;
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            net += diff;
            sum += diff;
            if (sum < 0) {
                // sum form 0 to i is negative. start point must be after i, if there is one
                sum = 0;
                start = i + 1;
            }
        }
        
        if (net < 0) return -1;
        else return start;
    }
}
