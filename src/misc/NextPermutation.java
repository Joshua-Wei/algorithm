package misc;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending
 * order).
 * 
 * The replacement must be in-place, do not allocate extra memory. 
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand
 * column.
 * 1,2,3 -> 1,3,2
 * 3,2,1 -> 1,2,3
 * 1,1,5 -> 1,5,1
 * 
 * Algorithm from http://fisherlei.blogspot.ca/2012/12/leetcode-next-permutation.html
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) return;
        
        // 1. From right to left, find the first digit (PartitionNumer)which violate the increase trend
        int partitionIdx = num.length - 1;
        while (partitionIdx > 0 && num[partitionIdx - 1] >= num[partitionIdx]) partitionIdx--;
        partitionIdx -= 1;
        if (partitionIdx == -1) {
            reverse(num, 0, num.length - 1);
            return;
        }
        
        // 2. From right to left, find the first digit which larger than PartitionNumber, call it ChangeNumber
        int changeIdx = num.length - 1;
        while (changeIdx > partitionIdx && num[changeIdx] <= num[partitionIdx]) changeIdx--;
        
        // 3. Swap the PartitionNumber and ChangeNumber
        int swap = num[partitionIdx];
        num[partitionIdx] = num[changeIdx];
        num[changeIdx] = swap;
        
        // 4. Reverse all the digit on the right of partition index
        reverse(num, partitionIdx + 1, num.length - 1);
    }
    
    private void reverse(int[] num, int start, int end) {
        while (start < end) {
            int swap = num[start];
            num[start] = num[end];
            num[end] = swap;
            start++;
            end--;
        }
    }
}
